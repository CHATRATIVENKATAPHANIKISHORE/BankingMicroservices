package com.bankTwo.AdminService.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CustomerDto {
	
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + "]";
	}

	public CustomerDto(String name) {
		super();
		this.name = name;
	}

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}	

	
	}
