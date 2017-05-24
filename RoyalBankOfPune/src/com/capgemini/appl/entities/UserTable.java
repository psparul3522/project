package com.capgemini.appl.entities;

import java.io.Serializable;

public class UserTable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int accountId;
	private int userId;
	private String loginPassword;
	private String secretQuestion;
	private String secretAnswer;
	private String transactionPassword;
	private String lockStatus;
	
	public UserTable() {
		super();
	}

	
	public UserTable(String secretQuestion) {
		super();
		this.secretQuestion = secretQuestion;
	}


	public UserTable(int accountId, int userId, String loginPassword,
			String secretQuestion, String secretAnswer,
			String transactionPassword, String lockStatus) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
	}

	
	
	public UserTable(String loginPassword, String secretQuestion,
			String secretAnswer, String transactionPassword, String lockStatus) {
		super();
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
	}

	public UserTable(int userId, String loginPassword, String secretQuestion,
			String secretAnswer, String transactionPassword, String lockStatus) {
		super();
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	@Override
	public String toString() {
		return "UserTable [accountId=" + accountId + ", userId=" + userId
				+ ", loginPassword=" + loginPassword + ", secretQuestion="
				+ secretQuestion + ", secretAnswer=" + secretAnswer
				+ ", transactionPassword=" + transactionPassword
				+ ", lockStatus=" + lockStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result
				+ ((lockStatus == null) ? 0 : lockStatus.hashCode());
		result = prime * result
				+ ((loginPassword == null) ? 0 : loginPassword.hashCode());
		result = prime * result
				+ ((secretAnswer == null) ? 0 : secretAnswer.hashCode());
		result = prime * result
				+ ((secretQuestion == null) ? 0 : secretQuestion.hashCode());
		result = prime
				* result
				+ ((transactionPassword == null) ? 0 : transactionPassword
						.hashCode());
		result = prime * result + userId;
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
		UserTable other = (UserTable) obj;
		if (accountId != other.accountId)
			return false;
		if (lockStatus == null) {
			if (other.lockStatus != null)
				return false;
		} else if (!lockStatus.equals(other.lockStatus))
			return false;
		if (loginPassword == null) {
			if (other.loginPassword != null)
				return false;
		} else if (!loginPassword.equals(other.loginPassword))
			return false;
		if (secretAnswer == null) {
			if (other.secretAnswer != null)
				return false;
		} else if (!secretAnswer.equals(other.secretAnswer))
			return false;
		if (secretQuestion == null) {
			if (other.secretQuestion != null)
				return false;
		} else if (!secretQuestion.equals(other.secretQuestion))
			return false;
		if (transactionPassword == null) {
			if (other.transactionPassword != null)
				return false;
		} else if (!transactionPassword.equals(other.transactionPassword))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}