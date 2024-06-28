package com.marcelorar.software.tata.balancemanager;

import org.springframework.boot.SpringApplication;

public class TestBalanceManagerApplication {

    public static void main(String[] args) {
        SpringApplication.from(BalanceManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
