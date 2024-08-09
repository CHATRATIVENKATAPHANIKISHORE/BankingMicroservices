package com.bankTwo.AdminService.Controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankTwo.AdminService.Dto.BalanceDto;
import com.bankTwo.AdminService.Repository.CustomerRepository;
import com.bankTwo.AdminService.Service.BankServices;

@RestController
@RequestMapping("/data")
public class BankController {
	
	@Autowired
	BankServices bank;
	
	@GetMapping("/checkbal/{accountNumber}")
    public Double knowBalance(@PathVariable("accountNumber") Long accountNumber) {
		return (Double)bank.checkBalance(accountNumber).get().accountBalance();	
	}
	@PutMapping("/addbal/{accountNumber}/{amount}")
    public void addBalance(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") Double amount) {
	 Double existing =  (Double)bank.checkBalance(accountNumber).get().accountBalance();	
		amount = amount + existing;
		bank.modifyBalance(accountNumber, amount);
		
		
	}
	@PutMapping("/deductbal/{accountNumber}/{amount}")
    public void deductBalance(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") Double amount) {
	 Double existing =  (Double)bank.checkBalance(accountNumber).get().accountBalance();	
		amount = existing - amount;
		bank.modifyBalance(accountNumber, amount);
		
		
	}
	
	
	@GetMapping("/validate/{accountNumber}")
    public Boolean validate(@PathVariable("accountNumber") Long accountNumber) {
		accountNumber = accountNumber - 100000 ;
		return bank.validate(accountNumber);		
	}
	
	

}
