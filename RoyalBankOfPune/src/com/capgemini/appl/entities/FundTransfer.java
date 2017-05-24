package com.capgemini.appl.entities;

import java.io.Serializable;
import java.util.Date;

public class FundTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	private int fundTransferId;
	private int accountId;
	private int payeeAccountId;
	private Date dateOfTransfer;
	private double transferAmount;
	
	public FundTransfer() {
		super();
	}

	public FundTransfer(int fundTransferId, int accountId, int payeeAccountId,
			Date dateOfTransfer, double transferAmount) {
		super();
		this.fundTransferId = fundTransferId;
		this.accountId = accountId;
		this.payeeAccountId = payeeAccountId;
		this.dateOfTransfer = dateOfTransfer;
		this.transferAmount = transferAmount;
	}

	public int getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(int fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getPayeeAccountId() {
		return payeeAccountId;
	}

	public void setPayeeAccountId(int payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}

	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Override
	public String toString() {
		return "FundTransfer [fundTransferId=" + fundTransferId
				+ ", accountId=" + accountId + ", payeeAccountId="
				+ payeeAccountId + ", dateOfTransfer=" + dateOfTransfer
				+ ", transferAmount=" + transferAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result
				+ ((dateOfTransfer == null) ? 0 : dateOfTransfer.hashCode());
		result = prime * result + fundTransferId;
		result = prime * result + payeeAccountId;
		long temp;
		temp = Double.doubleToLongBits(transferAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FundTransfer other = (FundTransfer) obj;
		if (accountId != other.accountId)
			return false;
		if (dateOfTransfer == null) {
			if (other.dateOfTransfer != null)
				return false;
		} else if (!dateOfTransfer.equals(other.dateOfTransfer))
			return false;
		if (fundTransferId != other.fundTransferId)
			return false;
		if (payeeAccountId != other.payeeAccountId)
			return false;
		if (Double.doubleToLongBits(transferAmount) != Double
				.doubleToLongBits(other.transferAmount))
			return false;
		return true;
	}
}