package com.capgemini.appl.entities;

import java.io.Serializable;
import java.util.Date;

public class AccountMaster implements Serializable{

	private static final long serialVersionUID = 1L;

	private int accountId; 
	private String accountType;
	private double accountBalance;
	private Date openDate;
	
	public AccountMaster() {
		super();
	}

	
	public AccountMaster(String accountType, double accountBalance,
			Date openDate) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
	}


	public AccountMaster(int accountId, String accountType,
			double accountBalance, Date openDate) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Override
	public String toString() {
		return "AccountMaster [accountId=" + accountId + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance
				+ ", openDate=" + openDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountId;
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result
				+ ((openDate == null) ? 0 : openDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountMaster other = (AccountMaster) obj;
		if (Double.doubleToLongBits(accountBalance) != Double
				.doubleToLongBits(other.accountBalance))
			return false;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (openDate == null) {
			if (other.openDate != null)
				return false;
		} else if (!openDate.equals(other.openDate))
			return false;
		return true;
	}
	
}