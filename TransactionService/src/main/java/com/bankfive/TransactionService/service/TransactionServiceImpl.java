package com.bankfive.TransactionService.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankfive.TransactionService.Model.Transaction;
import com.bankfive.TransactionService.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl {
	@Autowired
	private TransactionRepository transaction;
	@Transactional
	public void transfer(Long fromAccount, Long toAccount, Double amount) {
		//boolean ce = cr.existByAccountNumber(fromAccount);
		//if(ce) {
		//cr.updateBalance(amount,fromAccount);
		Transaction tr = new Transaction();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setTransferAmount(amount);
		tr.setTimestamp(LocalDateTime.now());
		tr.setTransactionType("Self-Deposit");
		transaction.save(tr);
		
		}
		
		
		
		
	
	@Transactional
	public void transferFunctionality(Long fromAccount, Long toAccount, Double amount, String trs ) {
		//boolean ce = cr.existByAccountNumber(fromAccount);
		//boolean cd = cr.existByAccountNumber(toAccount);
		
		//cr.updateBalance(amount,toAccount);
		//cr.updateAfterTransferBalance(amount,fromAccount);
		Transaction tr = new Transaction();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setTransferAmount(amount);
		tr.setTimestamp(LocalDateTime.now());
		tr.setTransactionType(trs);
		transaction.save(tr);
		
		}
		
		
		
		
	
	@Transactional
	public void withdrawl(Long fromAccount, Long toAccount, Double amount) {
		// TODO Auto-generated method stub
		//boolean ce = cr.existByAccountNumber(fromAccount);
		//boolean cd = cr.existByAccountNumber(toAccount);
		//if(ce && cd) {
		//cr.updateAfterTransferBalance(amount,fromAccount);
		Transaction tr = new Transaction();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setTransferAmount(amount);
		tr.setTimestamp(LocalDateTime.now());
		tr.setTransactionType("Withdrawl");
		transaction.save(tr);
		
	}
	

	
	public List<Transaction> getRecentTransaction(Long accountnumber) {
		// TODO Auto-generated method stub
		return transaction.getRecentTransaction(accountnumber);
	}


}
