package com.gateway.BankApiGate;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class BankApiGateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApiGateApplication.class, args);
	}

}
