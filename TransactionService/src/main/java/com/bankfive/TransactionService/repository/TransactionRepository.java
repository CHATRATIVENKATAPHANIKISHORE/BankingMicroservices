package com.bankfive.TransactionService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bankfive.TransactionService.Model.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	

	@Query("select c from Transaction c where c.fromAccount = :accountnumber or "
			+ "c.toAccount = :accountnumber order by c.timestamp desc")
	List<Transaction> getRecentTransaction(Long accountnumber);
}
