package com.marcelorar.software.tata.balancemanager.repository;

import com.marcelorar.software.tata.balancemanager.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    @Query("select t from Transaction t where t.account.client.clientId = ?1 and t.date between ?2 and ?3 order by t.date")
    List<Transaction> findByAccount_Client_ClientIdAndDateBetween(Integer clientId, OffsetDateTime dateStart, OffsetDateTime dateEnd, Pageable pageable);
    @Query("select t from Transaction t where t.id is not null")
    List<Transaction> findByIdNotNull(Pageable pageable);

}
