package com.bankEight.CustomersUI.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerUiService {

	public static String getTemplateContent(String templateName ) {
		// TODO Auto-generated method stub
		 if ("index".equals(templateName)) {
	            return "index";
	        }
	        
	        else if ("normal".equals(templateName)){
	            	return "normal";
	            
	        }
	        else if ("deposit".equals(templateName)){
	        	return "deposit";
	        
	    }
	        else if ("addCustomer".equals(templateName)){
	        	return "addCustomer";
	        
	    }
	        else if ("adminhome".equals(templateName)){
	        	return "adminhome";
	        
	    }
	        else if ("adminlogin".equals(templateName)){
	        	return "adminlogin";
	        
	    }
	        else if ("checkBalence".equals(templateName)){
	        	return "checkBalence";
	        
	    }
	        else if ("depositmsg".equals(templateName)){
	        	return "depositmsg";
	        
	    }
	        else if ("home".equals(templateName)){
	        	return "home";
	        
	    }
	        else if ("logout".equals(templateName)){
	        	return "logout";
	        
	    }
	        else if ("message".equals(templateName)){
	        	return "message";
	        
	    }
	        else if ("recent".equals(templateName)){
	        	return "recent";
	        
	    }
	        else if ("transfer".equals(templateName)){
	        	return "transfer";
	        
	    }else if ("validated".equals(templateName)){
	    	return "validated";
	    	
	        
	}
	    else if ("viewCustomer".equals(templateName)){
	    	return "viewCustomer";
	    
	}
	    else if ("withdraw".equals(templateName)){
	    	return "withdraw";
	    
	}else if ("withdrawmsg".equals(templateName)){
		return "withdrawmsg";
	    
	}

	 
	 
	 
	     
	     
	     
	     
	     
	        
	        else {
	            return "errors";
	        }
	    }

	}


