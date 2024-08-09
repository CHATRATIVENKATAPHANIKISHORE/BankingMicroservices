package com.bankTwo.AdminService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bankTwo.AdminService.Dto.Balance;
import com.bankTwo.AdminService.Dto.BalanceDto;
import com.bankTwo.AdminService.Repository.CustomerRepository;

@Service
public class BankServices {
	@Autowired
	CustomerRepository customerRepository;
	
	public Optional<BalanceDto> checkBalance(Long accNo) {

		
		return (Optional<BalanceDto>) customerRepository.getAccountBalance( accNo);
		
	}
	public void modifyBalance(Long accNo, Double amount) {
		customerRepository.updateBalance(accNo, amount);
	}

	public Boolean validate(Long accNo) {
		return customerRepository.existsById(accNo);
		
	}

}
