package com.bankfive.TransactionService.controller;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;







import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bankfive.TransactionService.Model.Transaction;
import com.bankfive.TransactionService.client.CustomerDataClient;
import com.bankfive.TransactionService.client.CustomerUiClient;
import com.bankfive.TransactionService.service.TransactionServiceImpl;

import jakarta.servlet.http.HttpServletResponse;
//import com.banking.Bank.Model.CustomerTransaction;


@RestController
@RequestMapping("/customer")
@SessionAttributes("name")
public class CustomerController {
	@Autowired
	CustomerUiClient customerUiClient;
	@Autowired
	CustomerDataClient customerDataClient;
	@Autowired
	TransactionServiceImpl tr;
	@Value("${api.gateway.url}")
    private String apiGatewayUrl;
	
	
	public void dologout(HttpServletResponse response) throws IOException  {
	
		
		response.sendRedirect(apiGatewayUrl);

		
		
	}
	
	 @GetMapping("/logout")
	    public void redirectToUrl(HttpServletResponse response) throws IOException {
	        // This method is not necessary if the redirect is handled by the gateway
	        response.sendRedirect("http://localhost:9091/login/validateLogin");
	    }
	@GetMapping("/checkbal/{accountnumber}")
	public String checkBal( ModelMap m , @PathVariable("accountnumber") Long accountnumber) {
		 Double balance = customerDataClient.checkBalance(accountnumber);

	        // Get template from UI service
	        String template = customerUiClient.getTemplate();
	        

	        // Add balance to the model map
	        String placeholder = "%BALANCE%";
	        String populatedTemplate = template.replace(placeholder, Double.toString(balance));
	        System.out.println("temp" +   "populatedTemplate"+ balance);


	        
	        return populatedTemplate;
	}
	@GetMapping("/deposit/{accountnumber}")
	public String doDeposit(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		//m.put("accountnumber",accountnumber);
		String template = customerUiClient.getDepositTemplate();
        

        // Add balance to the model map
        String placeholder = "%accountnumber%";
        String populatedTemplate = template.replace(placeholder, accountnumber.toString());
         
        System.out.println("temp" +   "populatedTemplate");


        
        return populatedTemplate;

		
		
		
	}
	@GetMapping("/withdrawl/{accountnumber}")
	public String doWithdrawl(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		//m.put("accountnumber",accountnumber);
		 String populatedTemplate = "" ;
		 String placeholder = "";
		

		String template = customerUiClient.getWithdrawTemplate();
        

        // Add balance to the model map
        placeholder = "%accountnumber%";
        populatedTemplate = template.replace(placeholder, accountnumber.toString());
         
        System.out.println("temp" +   "populatedTemplate");
		 
		 

        
        return populatedTemplate;

		
		
		
	}

	
	@PostMapping("/deposit/{accountnumber}")
	public String amountDeposit(ModelMap m, @PathVariable("accountnumber")
	Long accountnumber, @RequestParam("deposit") Double 
			deposit) {
		
		//m.put("accountnumber",accountnumber);
		//m.put("deposit",deposit);
		//ts.transfer(accountnumber, accountnumber, deposit);
		String template = customerUiClient.getDepositMsgTemplate();

		String placeholder = "%accountnumber%";
        String populatedTemplate = template.replace(placeholder, accountnumber.toString());
		String placeholderTwo = "%deposit%";
		populatedTemplate = populatedTemplate.replace(placeholderTwo, Double.toString(deposit));
		customerDataClient.addbal(accountnumber, deposit);
		tr.transferFunctionality(accountnumber, accountnumber, deposit, "Deposit");

		return populatedTemplate;
		
	}
	@PostMapping("/withdrawl/{accountnumber}")
	public String amountWithdrawl(ModelMap m, @PathVariable("accountnumber")
	Long accountnumber, @RequestParam("withdraw") Double 
			deposit) {
		
		//m.put("accountnumber",accountnumber);
		//m.put("deposit",deposit);
		//ts.transfer(accountnumber, accountnumber, deposit);
		 Double balance = customerDataClient.checkBalance(accountnumber);
		 Boolean checkValidAccNo = customerDataClient.isValidAccno(accountnumber);
		 String populatedTemplate = "" ;
		 String placeholder = "";
		 if(checkValidAccNo && balance > deposit) {
		String template = customerUiClient.getWithdrawMsgTemplate();

		placeholder = "%accountnumber%";
         populatedTemplate = template.replace(placeholder, accountnumber.toString());
		String placeholderTwo = "%withdraw%";
		populatedTemplate = populatedTemplate.replace(placeholderTwo, Double.toString(deposit));
		tr.transferFunctionality(accountnumber, accountnumber, deposit, "Withdrawl");

		customerDataClient.deductbal(accountnumber,deposit);
		
		 }
		 else {
			 populatedTemplate =  customerUiClient.getErrorTemplate();
			 placeholder = "%error%";
			 populatedTemplate = populatedTemplate.replace(placeholder, "Insufficient Funds");
		 }

		
		return populatedTemplate;
		
	}
	@GetMapping("/transfer/{accountnumber}")
	public String doTransfer(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
	
		String populatedTemplate = "" ;
		 String placeholder = "";
		

		String template = customerUiClient.getTransferTemplate();
       

       // Add balance to the model map
       placeholder = "%accountnumber%";
       populatedTemplate = template.replace(placeholder, accountnumber.toString());
       return populatedTemplate;

	}
	@PostMapping("/transfer/{accountnumber}")
	public String amountTransfer(ModelMap m, @PathVariable("accountnumber")
	
	Long accountnumber, @RequestParam("deposit") Double 
	deposit, @RequestParam("toaccount") Long toaccount) {
		Double balance = customerDataClient.checkBalance(accountnumber);

		 String populatedTemplate = "" ;
		 String placeholder = "";
		 Boolean checkValidAccNo = customerDataClient.isValidAccno(accountnumber);
		 Boolean checkValidToAccNo = customerDataClient.isValidAccno(toaccount);


		 if(checkValidToAccNo && checkValidAccNo && balance > deposit ) {
			 populatedTemplate = customerUiClient.getTransferMsgTemplate();
			 placeholder = "%accountnumber%";
			 populatedTemplate =populatedTemplate.replace(placeholder, accountnumber.toString())
					 ;
			 placeholder = "%deposit%";
			 populatedTemplate =populatedTemplate.replace(placeholder, deposit.toString());

				customerDataClient.deductbal(accountnumber,deposit);
				customerDataClient.addbal(toaccount, deposit);
				tr.transferFunctionality(accountnumber, toaccount, deposit, "Transfer");
				

		 }
		 else {
			 populatedTemplate =  customerUiClient.getErrorTemplate();
			 placeholder = "%error%";
			 populatedTemplate = populatedTemplate.replace(placeholder, "Insufficient Funds");
		 
		 }

		
		return populatedTemplate;
	}
	@GetMapping("/recents/{accountnumber}")
	public String recentTransactions(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		//String populatedTemplate = customerUiClient.getRecentTemplate();
		//String placeholder = "%accountnumber%";
		List<Transaction> o = tr.getRecentTransaction(accountnumber);

		 // =populatedTemplate.replace(placeholder, accountnumber.toString())
				 ;
		// placeholder = "%recent%";
		 //populatedTemplate =populatedTemplate.replace(placeholder, o.toString());
				m.put("accountnumber", accountnumber);
				 m.put("recent", o);
		// System.out.println("recent" + o +populatedTemplate);
		 return "recent";

	}
	
	
	
	
	
	private String renderTemplate(String template, ModelMap model) {
        // Replace placeholders in the template with model attributes
        // For demonstration, replacing "${checkbalance}" with the actual value
        String renderedTemplate =
        		template.replace("${balance}", String.valueOf(model.getAttribute("balance")));
        return renderedTemplate;
    }
	@GetMapping("/checkbals/{accountnumber}")
	public String checkBalence( ModelMap m , @PathVariable("accountnumber") Long accountnumber) {
		
		//double a = customerRepository.findById(accountnumber).get().getAccountBalance();
		RestTemplate restTemplate = new RestTemplate();
		var uri = """
		          http://localhost:8081/data/checkbal/%d
		          """.formatted(accountnumber);
		var values = restTemplate.getForEntity(uri, Double.class);
		 Double balance = values.getBody();
         
		
		RestTemplate ui = new RestTemplate();
		var templates = ui.getForEntity("http://localhost:8088/cui/checkBalence", String.class);
		 String template = templates.getBody();
		m.addAttribute("checkbalance", 1000);
		//String renderedTemplate = renderTemplate(template, m );
		System.out.println("renderedTemplate"+balance);
		System.out.println("renderedTemplate"+template);

		return template;
		
	}

	
	
	
	
//	
@InitBinder
	public void initBinder(WebDataBinder dataBinder) 
	{
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	


	
	

}
