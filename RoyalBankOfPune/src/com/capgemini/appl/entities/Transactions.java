package com.capgemini.appl.entities;

import java.io.Serializable;
import java.util.Date;

public class Transactions implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int transactionId;
	private String tranDescription;
	private Date dateOfTransaction;
	private String transactionType;
	private double tranAmount;
	private int accountId;
	
	public Transactions() {
		super();
	}
	

	public Transactions(int transactionId, String tranDescription,
			Date dateOfTransaction, String transactionType, double tranAmount) {
		super();
		this.transactionId = transactionId;
		this.tranDescription = tranDescription;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.tranAmount = tranAmount;
	}


	public Transactions(int transactionId, String tranDescription,
			Date dateOfTransaction, String transactionType, double tranAmount,
			int accountId) {
		super();
		this.transactionId = transactionId;
		this.tranDescription = tranDescription;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.tranAmount = tranAmount;
		this.accountId = accountId;
	}

	
	public Transactions(String tranDescription, Date dateOfTransaction,
			String transactionType, double tranAmount, int accountId) {
		super();
		this.tranDescription = tranDescription;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.tranAmount = tranAmount;
		this.accountId = accountId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTranDescription() {
		return tranDescription;
	}

	public void setTranDescription(String tranDescription) {
		this.tranDescription = tranDescription;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId
				+ ", tranDescription=" + tranDescription
				+ ", dateOfTransaction=" + dateOfTransaction
				+ ", transactionType=" + transactionType + ", tranAmount="
				+ tranAmount + ", accountId=" + accountId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime
				* result
				+ ((dateOfTransaction == null) ? 0 : dateOfTransaction
						.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tranAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((tranDescription == null) ? 0 : tranDescription.hashCode());
		result = prime * result + transactionId;
		result = prime * result
				+ ((transactionType == null) ? 0 : transactionType.hashCode());
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
		Transactions other = (Transactions) obj;
		if (accountId != other.accountId)
			return false;
		if (dateOfTransaction == null) {
			if (other.dateOfTransaction != null)
				return false;
		} else if (!dateOfTransaction.equals(other.dateOfTransaction))
			return false;
		if (Double.doubleToLongBits(tranAmount) != Double
				.doubleToLongBits(other.tranAmount))
			return false;
		if (tranDescription == null) {
			if (other.tranDescription != null)
				return false;
		} else if (!tranDescription.equals(other.tranDescription))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}	
}