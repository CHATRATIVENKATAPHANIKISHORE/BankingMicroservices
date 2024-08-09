package com.bankfive.TransactionService.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CustomersUI", url = "http://localhost:8088")  // Replace with your actual UI service URL
public interface CustomerUiClient {
	 String getErrorTemplate = null;
	@GetMapping("/cui/checkBalence")
	    String getTemplate();
	 @GetMapping("/cui/deposit")
	    String getDepositTemplate();
	 @GetMapping("/cui/depositmsg")
	    String getDepositMsgTemplate();
	 @GetMapping("/cui/withdraw")
	    String getWithdrawTemplate();
	 @GetMapping("/cui/withdrawmsg")
	    String getWithdrawMsgTemplate();
	 
	 @GetMapping("/cui/recent")
	    String getRecentTemplate();
	 @GetMapping("/cui/errors")
	String getErrorTemplate();
	 @GetMapping("/cui/transfer")
		String getTransferTemplate();
	 @GetMapping("/cui/depositmsg")
		String getTransferMsgTemplate();
		 
	 
	 
	 

}
