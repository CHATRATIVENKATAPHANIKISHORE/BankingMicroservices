package com.bankTwo.AdminService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custId;
	private String accountNumber;
	private String customerName;
	private Double accountBalance = 500.0;
	private String bankRole;
	private String password;
	private String phoneNumber;
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getBankRole() {
		return bankRole;
	}
	public void setBankRole(String bankRole) {
		this.bankRole = bankRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Register [custId=" + custId + ", accountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", accountBalance=" + accountBalance + ", bankRole=" + bankRole + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	public Register(Long custId, String accountNumber, String customerName, Double accountBalance, String bankRole,
			String password, String phoneNumber) {
		super();
		this.custId = custId;
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
		this.bankRole = bankRole;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	


}
