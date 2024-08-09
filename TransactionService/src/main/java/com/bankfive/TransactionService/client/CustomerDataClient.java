package com.bankfive.TransactionService.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "AdminService", url = "http://localhost:8081")  // Replace with your actual balance service URL
public interface CustomerDataClient {
	@GetMapping("/data/checkbal/{accountNumber}")
    Double checkBalance(@PathVariable("accountNumber") Long accountNumber);
	@PutMapping("/data/addbal/{accountNumber}/{amount}")
    void addbal(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") Double amount);
	@PutMapping("/data/deductbal/{accountNumber}/{amount}")
    void deductbal(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") Double amount);
	@GetMapping("/data/validate/{accountNumber}")
	Boolean isValidAccno(@PathVariable("accountNumber") Long accountNumber);
	
}
