package com.marcelorar.software.tata.balancemanager.repository;

import com.marcelorar.software.tata.balancemanager.model.Account;
import com.marcelorar.software.tata.balancemanager.model.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {
    @Query("select a from Account a where a.number = ?1")
    Account findByNumber(String number);
    @Transactional
    @Modifying
    @Query("update Account a set a.availableBalance = ?1 where a.number = ?2")
    int updateAvailableBalanceByNumber(String availableBalance, String number);
    @Transactional
    @Modifying
    @Query("delete from Account a where a.number = ?1")
    int deleteByNumber(String number);
    @Transactional
    @Modifying
    @Query("update Account a set a.type = ?1, a.isEnabled = ?2, a.client = ?3 where a.number = ?4")
    int updateTypeAndIsEnabledAndClientByNumber(Account.TypeEnum type, Boolean isEnabled, Client client, String number);
    @Query("select a from Account a where a.number is not null")
    List<Account> findByNumberNotNull(Pageable pageable);

}
