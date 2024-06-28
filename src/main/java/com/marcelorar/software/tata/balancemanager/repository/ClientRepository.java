package com.marcelorar.software.tata.balancemanager.repository;

import com.marcelorar.software.tata.balancemanager.model.Client;
import com.marcelorar.software.tata.balancemanager.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Client c where c.clientId = ?1")
    int deleteByClientId(Integer clientId);
    Optional<Client> findByClientId(Integer clientId);
    @Transactional
    @Modifying
    @Query("""
            update Client c set c.gender = ?1, c.password = ?2, c.isEnabled = ?3, c.name = ?4, c.birthDate = ?5, c.identificationCode = ?6, c.address = ?7, c.phoneNumber = ?8
            where c.clientId = ?9""")
    int updateGenderAndPasswordAndIsEnabledAndNameAndBirthDateAndIdentificationCodeAndAddressAndPhoneNumberByClientId(Person.GenderEnum gender, String password, Boolean isEnabled, String name, LocalDate birthDate, String identificationCode, String address, String phoneNumber, Integer clientId);

    List<Client> findByClientIdNotNullOrderByClientIdAsc(Pageable pageable);

}
