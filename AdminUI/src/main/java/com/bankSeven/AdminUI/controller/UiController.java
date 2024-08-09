package com.bankSeven.AdminUI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankSeven.AdminUI.service.TemplateService;

@Controller
public class UiController {
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
	
	
	@GetMapping("/bui/{temp}")
	 public String getTemplates(ModelMap m , @PathVariable("temp") String temp) {
      // Logic to fetch the template from storage or database
      // Assume you have a service called TemplateService that fetches templates
		//System.out.println("Welcome to Africa");
      
      String templateContent = TemplateService.getTemplateContent(temp);
      
      // Add any necessary data to the model
      //model.addAttribute("data", "Some dynamic data");

      // Return the name of the JSP file to be rendered
      return templateContent;
  }


}
