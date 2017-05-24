package com.capgemini.appl.entities;

import java.io.Serializable;
import java.util.Date;

public class ServiceTracker implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int serviceId;
	private String serviceDescription;
	private int accountId;
	private Date serviceRaisedDate;
	private String serviceStatus;
	
	public ServiceTracker() {
		super();
	}

	public ServiceTracker(int serviceId, String serviceDescription,
			int accountId, Date serviceRaisedDate, String serviceStatus) {
		super();
		this.serviceId = serviceId;
		this.serviceDescription = serviceDescription;
		this.accountId = accountId;
		this.serviceRaisedDate = serviceRaisedDate;
		this.serviceStatus = serviceStatus;
	}

	
	public ServiceTracker(String serviceDescription, int accountId,
			Date serviceRaisedDate, String serviceStatus) {
		super();
		this.serviceDescription = serviceDescription;
		this.accountId = accountId;
		this.serviceRaisedDate = serviceRaisedDate;
		this.serviceStatus = serviceStatus;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Date getServiceRaisedDate() {
		return serviceRaisedDate;
	}

	public void setServiceRaisedDate(Date serviceRaisedDate) {
		this.serviceRaisedDate = serviceRaisedDate;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	@Override
	public String toString() {
		return "ServiceTracker [serviceId=" + serviceId
				+ ", serviceDescription=" + serviceDescription + ", accountId="
				+ accountId + ", serviceRaisedDate=" + serviceRaisedDate
				+ ", serviceStatus=" + serviceStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime
				* result
				+ ((serviceDescription == null) ? 0 : serviceDescription
						.hashCode());
		result = prime * result + serviceId;
		result = prime
				* result
				+ ((serviceRaisedDate == null) ? 0 : serviceRaisedDate
						.hashCode());
		result = prime * result
				+ ((serviceStatus == null) ? 0 : serviceStatus.hashCode());
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
		ServiceTracker other = (ServiceTracker) obj;
		if (accountId != other.accountId)
			return false;
		if (serviceDescription == null) {
			if (other.serviceDescription != null)
				return false;
		} else if (!serviceDescription.equals(other.serviceDescription))
			return false;
		if (serviceId != other.serviceId)
			return false;
		if (serviceRaisedDate == null) {
			if (other.serviceRaisedDate != null)
				return false;
		} else if (!serviceRaisedDate.equals(other.serviceRaisedDate))
			return false;
		if (serviceStatus == null) {
			if (other.serviceStatus != null)
				return false;
		} else if (!serviceStatus.equals(other.serviceStatus))
			return false;
		return true;
	}	
}