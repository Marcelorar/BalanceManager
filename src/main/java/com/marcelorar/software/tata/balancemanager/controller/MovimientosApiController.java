package com.marcelorar.software.tata.balancemanager.controller;

import com.marcelorar.software.tata.balancemanager.api.MovimientosApi;
import com.marcelorar.software.tata.balancemanager.model.*;

import java.math.BigDecimal;
import java.util.UUID;


import com.marcelorar.software.tata.balancemanager.repository.AccountRepository;
import com.marcelorar.software.tata.balancemanager.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-27T22:48:20.411121100-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.balanceManager.base-path:/api/v1}")
public class MovimientosApiController implements MovimientosApi {

    private final NativeWebRequest request;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    @Autowired
    public MovimientosApiController(NativeWebRequest request,
                                    TransactionRepository transactionRepository,
                                    AccountRepository accountRepository) {
        this.request = request;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Transaction> createTransaction(TransactionPOST transactionPOST) {
       Transaction transaction = new Transaction(transactionPOST);
       transaction.setId(UUID.randomUUID());
       Account acc = accountRepository.findByNumber(transactionPOST.getAccount().getNumber());
       String balance;


       if(Transaction.TypeEnum.CREDIT.getValue().equals(transactionPOST.getType().getValue())){
           balance = new BigDecimal(acc.getAvailableBalance())
                   .add(new BigDecimal(transactionPOST.getAmount())).toPlainString();
           accountRepository.updateAvailableBalanceByNumber(
                   balance,
                   transactionPOST.getAccount().getNumber());
       } else if(Transaction.TypeEnum.DEBIT.getValue().equals(transactionPOST.getType().getValue())
         && new BigDecimal(acc.getAvailableBalance()).compareTo(new BigDecimal(transactionPOST.getAmount())) >= 0){
           balance = new BigDecimal(acc.getAvailableBalance())
                   .subtract(new BigDecimal(transactionPOST.getAmount())).toPlainString();
           accountRepository.updateAvailableBalanceByNumber(
                   balance,
                   transactionPOST.getAccount().getNumber());
       } else {
           return ResponseEntity.status(403).body(null);
       }
       transaction.currentBalance(balance);
       return ResponseEntity.ok(transactionRepository.save(transaction));
    }

    @Override
    public ResponseEntity<List<GetAllTransactions200ResponseInner>> getAllTransactions(Integer pgSize, Integer pg) {
        Pageable pageable = PageRequest.of(pg, pgSize);
        List<Transaction> result = transactionRepository.findByIdNotNull(pageable);
        return ResponseEntity.ok(result.stream().map(r -> (GetAllTransactions200ResponseInner) r).toList());
    }
}
