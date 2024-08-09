package com.bankfive.TransactionService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bankfive.TransactionService.Model.Transaction;
import com.bankfive.TransactionService.service.TransactionServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/customer")
@SessionAttributes("name")
public class TransactionController {
	@Autowired
	TransactionServiceImpl tr;
	@GetMapping("/recent/{accountnumber}")
	public String recentTransaction(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		
		m.put("accountnumber",accountnumber);
		//write code for recent transaction
		List<Transaction> o = tr.getRecentTransaction(accountnumber);
		//System.out.print(o);
		m.put("recent",o);

		
		
		return "recent";
		
	}
	

}
