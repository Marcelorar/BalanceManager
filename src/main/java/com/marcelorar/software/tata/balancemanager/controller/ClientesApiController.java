package com.marcelorar.software.tata.balancemanager.controller;

import com.marcelorar.software.tata.balancemanager.api.ApiUtil;
import com.marcelorar.software.tata.balancemanager.api.ClientesApi;
import com.marcelorar.software.tata.balancemanager.model.Client;
import com.marcelorar.software.tata.balancemanager.model.ClientPUT;
import com.marcelorar.software.tata.balancemanager.model.GetAllClient200ResponseInner;
import com.marcelorar.software.tata.balancemanager.model.Person;


import com.marcelorar.software.tata.balancemanager.repository.ClientRepository;
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

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-27T22:48:20.411121100-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.balanceManager.base-path:/api/v1}")
public class ClientesApiController implements ClientesApi {

    private final NativeWebRequest request;

    private final ClientRepository clientRepository;

    @Autowired
    public ClientesApiController(NativeWebRequest request, ClientRepository clientRepository) {
        this.request = request;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<GetAllClient200ResponseInner>> getAllClient(Integer pgSize, Integer pg) {
        Pageable pageable = PageRequest.of(pg, pgSize);
        List<Client> result = clientRepository.findByClientIdNotNullOrderByClientIdAsc(pageable);
        return ResponseEntity.ok(result.stream().map(r -> (GetAllClient200ResponseInner) r).toList());
    }

    @Override
    public ResponseEntity<Client> createClient(Person person) {
        Client client = new Client(person);
        client.setPassword(ApiUtil.generatePassword());
        client.setIsEnabled(true);
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @Override
    public ResponseEntity<Client> updateClient(Integer clientId, ClientPUT clientPUT) {
        int result = clientRepository.updateGenderAndPasswordAndIsEnabledAndNameAndBirthDateAndIdentificationCodeAndAddressAndPhoneNumberByClientId(
                clientPUT.getGender(), clientPUT.getPassword(),clientPUT.getIsEnabled(),
                clientPUT.getName(), clientPUT.getBirthDate(), clientPUT.getIdentificationCode(),
                clientPUT.getAddress(), clientPUT.getPhoneNumber(), clientId);

        if(result == 1) {
            return ResponseEntity.ok(clientRepository.findByClientId(clientId).orElse(null));
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<Void> deleteClient(Integer clientId) {
        long result = clientRepository.deleteByClientId(clientId);

        if(result == 1) {
            return ResponseEntity.ok(null);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
