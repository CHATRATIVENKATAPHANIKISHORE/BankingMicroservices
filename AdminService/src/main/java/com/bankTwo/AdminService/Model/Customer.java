package com.bankTwo.AdminService.Model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custId;
	
	@Column(unique = true)
	@NotNull
	private Long accountNumber;
	
	private String customerName;
	
	private Double accountBalance;
	
	@PrePersist
    public void generateAccountNo() {
        if (this.custId != null && this.accountNumber== null) {
            this.accountNumber =  100000 + this.custId ;
        }
	
	


}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
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

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", accountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", accountBalance=" + accountBalance + "]";
	}

	public Customer(Long custId, Long accountNumber, String customerName, Double accountBalance) {
		super();
		this.custId = custId;
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
}
