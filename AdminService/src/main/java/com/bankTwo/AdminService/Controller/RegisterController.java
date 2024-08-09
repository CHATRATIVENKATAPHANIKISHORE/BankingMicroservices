package com.bankTwo.AdminService.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankTwo.AdminService.Dto.AccountNumberDto;
import com.bankTwo.AdminService.Dto.CustomerDto;
import com.bankTwo.AdminService.Model.Customer;
import com.bankTwo.AdminService.Repository.CustomerRepository;


@RestController
@RequestMapping("/login")
public class RegisterController {
	@Autowired
	CustomerRepository customerRepository;
	
	
	@GetMapping("/validateLogin")
    public String home(Model model) {
        // Logic to fetch data or perform any other operations
        
        // Add any necessary data to the model
        //model.addAttribute("message", "Hello from the other microservice!");

        // Make a request to the Template Microservice to fetch the template
        RestTemplate restTemplate = new RestTemplate();
        String templateName = restTemplate.getForObject("http://localhost:8089/bui/index", String.class);
        model.addAttribute("accountnumber", new AccountNumberDto());
        // In reality, you would fetch the template content and render it here
        return templateName;
    }
	@RequestMapping("/admin")
	public String adminLogin(Model model) {
        		RestTemplate restTemplate = new RestTemplate();
				  String templateName = restTemplate.getForObject("http://localhost:8089/bui/adminlogin", String.class);
				  return templateName;
        // In reality, you would fetch the template content and render it here
        
    }
	@RequestMapping("/home")
	public String adminHome(Model model) {
        		RestTemplate restTemplate = new RestTemplate();
				  String templateName = restTemplate.getForObject("http://localhost:8089/bui/adminhome", String.class);
				  return templateName;
        // In reality, you would fetch the template content and render it here
        
    }


	@PostMapping("/validateLogin") public String validateLogin(@ModelAttribute AccountNumberDto accountnumber, Model m ) { 
		RestTemplate restTemplate = new RestTemplate();
		String templateName = restTemplate.getForObject("http://localhost:8089/bui/errors", String.class);
		//boolean b =customerRepository.existByAccountNumber(accountnumber); 
		//if(b == false) {
					//  m.put("error","Wrong Credentials");
					  
						//return templateName ;
				  System.out.print("acc"+accountnumber.getAccountnumber().toString());
				  
				  //accno=accountnumber;
			        String placeholder = "%accountnumber%";
				  templateName = restTemplate.getForObject("http://localhost:8089/bui/validated", String.class);
			        String populatedTemplate = templateName.replace(placeholder, accountnumber.getAccountnumber().toString());

				  return populatedTemplate;
				  
				  }
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String templateName = restTemplate.getForObject("http://localhost:8089/bui/addCustomer", String.class);
		model.addAttribute("customer", new CustomerDto());
		
		return templateName;
		
	}
	@PostMapping("/addCustomers")
	public String submitaddCustomer(@ModelAttribute CustomerDto customer) {
		RestTemplate restTemplate = new RestTemplate();
		//String n = restTemplate.postForObject("http://localhost:8089/bui/addCustomers", customer, String.class);
		// restTemplate.postForObject("http://microservice2/api/receive-account", customer, CustomerDto.class);
		System.out.println("custo"+customer.toString());
		Customer customer1 = new Customer(null,null,customer.getName().toString(),500.0);
		customerRepository.save(customer1);
		String templateName = restTemplate.getForObject("http://localhost:8089/bui/message", String.class);

		return templateName;
		
	}
	
	}
	

