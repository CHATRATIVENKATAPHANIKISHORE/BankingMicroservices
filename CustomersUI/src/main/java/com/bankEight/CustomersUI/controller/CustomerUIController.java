package com.bankEight.CustomersUI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bankEight.CustomersUI.service.CustomerUiService;

@Controller
public class CustomerUIController {
	@GetMapping("/ui")
	 public String getTemplate( ) {
      // Logic to fetch the template from storage or database
      // Assume you have a service called TemplateService that fetches templates
		System.out.println("Welcome to India");
      
      //String templateContent = TemplateService.getTemplateContent(templateName);
      
      // Add any necessary data to the model
      //model.addAttribute("data", "Some dynamic data");

      // Return the name of the JSP file to be rendered
      return "normal";
  }
	
	@GetMapping("/cui/{temp}")
	 public String getTemplates(ModelMap m , @PathVariable("temp") String temp) {
     // Logic to fetch the template from storage or database
     // Assume you have a service called TemplateService that fetches templates
		//System.out.println("Welcome to Africa");
     
     String templateContent = CustomerUiService.getTemplateContent(temp);
     
     // Add any necessary data to the model
     //model.addAttribute("data", "Some dynamic data");

     // Return the name of the JSP file to be rendered
     return templateContent;
 }

}
