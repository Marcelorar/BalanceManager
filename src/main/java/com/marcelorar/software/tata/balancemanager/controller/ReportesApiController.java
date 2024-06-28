package com.marcelorar.software.tata.balancemanager.controller;

import com.marcelorar.software.tata.balancemanager.api.ReportesApi;
import com.marcelorar.software.tata.balancemanager.model.Transaction;
import com.marcelorar.software.tata.balancemanager.model.TransactionReport;
import com.marcelorar.software.tata.balancemanager.repository.AccountRepository;
import com.marcelorar.software.tata.balancemanager.repository.ClientRepository;
import com.marcelorar.software.tata.balancemanager.repository.TransactionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import com.marcelorar.software.tata.balancemanager.model.GetTransactionsByDateByClient200ResponseInner;

import java.math.BigDecimal;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
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

import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-28T04:11:16.530160300-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.balanceManager.base-path:/api/v1}")
public class ReportesApiController implements ReportesApi {

    private final NativeWebRequest request;
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;


    @Autowired
    public ReportesApiController(NativeWebRequest request,
                                 ClientRepository clientRepository,
                                 AccountRepository accountRepository,
                                 TransactionRepository transactionRepository) {
        this.request = request;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<GetTransactionsByDateByClient200ResponseInner>> getTransactionsByDateByClient(Integer clientId,
                                                                                                             Integer pgSize,
                                                                                                             Integer pg,
                                                                                                             LocalDate startDate,
                                                                                                             LocalDate endDate) {
        Pageable pageable = PageRequest.of(pg, pgSize);
        List<Transaction> result = transactionRepository.findByAccount_Client_ClientIdAndDateBetween(clientId,startDate.atTime(0,0,0).atOffset(ZoneOffset.MIN), endDate.atTime(0,0,0).atOffset(ZoneOffset.MAX), pageable);
        List<TransactionReport> report = result.stream().map(res -> {
            TransactionReport tr = new TransactionReport();
            tr.setDate(res.getDate());
            tr.setAccount(res.getAccount().getNumber());
            tr.setAccountType(TransactionReport.AccountTypeEnum.fromValue(res.getAccount().getType().getValue()));
            tr.setName(res.getAccount().getClient().getName());
            tr.setIssuedAmount(res.getAmount());
            tr.setOperation(TransactionReport.OperationEnum.fromValue(res.getType().getValue()));
            tr.setCurrentBalance(res.getCurrentBalance());
            String balance = getInitialBalance(res, tr);
            tr.setLastBalance(balance);
            return tr;
        }).toList();
        return ResponseEntity.ok(report.stream().map(r -> (GetTransactionsByDateByClient200ResponseInner) r).toList());
    }

    private static String getInitialBalance(Transaction res, TransactionReport tr) {
        String balance = "0.0";
        if(Transaction.TypeEnum.CREDIT.getValue().equals(res.getType().getValue())){
            balance = new BigDecimal(tr.getCurrentBalance())
                    .subtract(new BigDecimal(tr.getIssuedAmount())).toPlainString();

        } else if(Transaction.TypeEnum.DEBIT.getValue().equals(res.getType().getValue())) {
            balance = new BigDecimal(tr.getCurrentBalance())
                    .add(new BigDecimal(tr.getIssuedAmount())).toPlainString();
        }
        return balance;
    }
}
