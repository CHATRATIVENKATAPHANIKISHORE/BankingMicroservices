package com.bankTwo.AdminService.Dto;

import java.util.Objects;

public class AccountNumberDto {
	String accountnumber;

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	@Override
	public String toString() {
		return "AccountNumberDto [accountnumber=" + accountnumber + "]";
	}

	public AccountNumberDto(String accountnumber) {
		super();
		this.accountnumber = accountnumber;
	}

	public AccountNumberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountnumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountNumberDto other = (AccountNumberDto) obj;
		return Objects.equals(accountnumber, other.accountnumber);
	}

}
