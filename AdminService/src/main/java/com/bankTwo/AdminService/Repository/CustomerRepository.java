package com.bankTwo.AdminService.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;

import com.bankTwo.AdminService.Dto.Balance;
import com.bankTwo.AdminService.Dto.BalanceDto;
import com.bankTwo.AdminService.Model.Customer;
import com.bankTwo.AdminService.Model.Register;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByAccountNumber(Long accountNumber);

	//@Query("SELECT f.accountNumber, f.accountBalance from Customer f where f.accountNumber = ?1")
	//Optional<BalanceDto> getAccountBalance(Long accountNumber);

	@Query("SELECT new com.bankTwo.AdminService.Dto.BalanceDto(f.accountNumber, f.accountBalance) from Customer f where f.accountNumber = ?1")
	Optional<BalanceDto> getAccountBalance(Long accountNumber);
	
	@Modifying
	@Query("Update Customer  set accountBalance = ?2 where accountNumber= ?1")
	void updateBalance(Long accountNumber, Double accountBalance);

	

	

	

	
}
