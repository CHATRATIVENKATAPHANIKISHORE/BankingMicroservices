package com.bankTwo.AdminService.Dto;

public class Balance {
	private Long accountNumber;
	private Double accountBalance;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Balance [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	}
	public Balance(Long accountNumber, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	public Balance() {
		super();
		// TODO Auto-generated constructor stub
	}

}
