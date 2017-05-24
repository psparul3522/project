package com.capgemini.appl.entities;

import java.io.Serializable;

public class PayeeTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private int accountId;
	private int  payeeAccountId;
	private String nickName;
	
	public PayeeTable() {
		super();
	}

	public PayeeTable(int accountId, int payeeAccountId, String nickName) {
		super();
		this.accountId = accountId;
		this.payeeAccountId = payeeAccountId;
		this.nickName = nickName;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "PayeeTable [accountId=" + accountId + ", payeeAccountId="
				+ payeeAccountId + ", nickName=" + nickName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + payeeAccountId;
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
		PayeeTable other = (PayeeTable) obj;
		if (accountId != other.accountId)
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (payeeAccountId != other.payeeAccountId)
			return false;
		return true;
	}
}