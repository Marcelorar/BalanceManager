package com.marcelorar.software.tata.balancemanager.controller;

import com.marcelorar.software.tata.balancemanager.api.CuentasApi;
import com.marcelorar.software.tata.balancemanager.model.*;


import com.marcelorar.software.tata.balancemanager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;



import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-27T22:48:20.411121100-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.balanceManager.base-path:/api/v1}")
public class CuentasApiController implements CuentasApi {

    private final NativeWebRequest request;

    private final AccountRepository accountRepository;

    @Autowired
    public CuentasApiController(NativeWebRequest request, AccountRepository accountRepository) {
        this.request = request;
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<GetAllAccounts200ResponseInner>> getAllAccounts(Integer pgSize, Integer pg) {
        Pageable pageable = PageRequest.of(pg, pgSize);
        List<Account> result = accountRepository.findByNumberNotNull(pageable);
        return ResponseEntity.ok(result.stream().map(r -> (GetAllAccounts200ResponseInner) r).toList());
    }

    @Override
    public ResponseEntity<Account> createAccount(AccountPOST accountPOST) {
        Account account = new Account(accountPOST);
        return ResponseEntity.ok( accountRepository.save(account));
    }

    @Override
    public ResponseEntity<Account> updateAccount(String number, AccountPUT accountPUT) {
       int result = accountRepository.updateTypeAndIsEnabledAndClientByNumber(
               Account.TypeEnum.fromValue(accountPUT.getType().getValue()),
               accountPUT.getIsEnabled(), accountPUT.getClient(),number);

        if(result == 1) {
            return ResponseEntity.ok(accountRepository.findById(number).orElse(null));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteAccount(String number) {
        long result = accountRepository.deleteByNumber(number);

        if(result == 1) {
            return ResponseEntity.ok(null);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
