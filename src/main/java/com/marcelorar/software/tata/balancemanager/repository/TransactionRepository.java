package com.marcelorar.software.tata.balancemanager.repository;

import com.marcelorar.software.tata.balancemanager.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    @Query("select t from Transaction t where t.id is not null")
    List<Transaction> findByIdNotNull(Pageable pageable);

}
