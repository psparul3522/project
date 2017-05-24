package com.capgemini.appl.services;

import java.util.ArrayList;

import com.capgemini.appl.daos.OnlineBankingDao;
import com.capgemini.appl.daos.OnlineBankingDaoImpl;
import com.capgemini.appl.entities.AccountMaster;
import com.capgemini.appl.entities.Customer;
import com.capgemini.appl.entities.FundTransfer;
import com.capgemini.appl.entities.PayeeTable;
import com.capgemini.appl.entities.ServiceTracker;
import com.capgemini.appl.entities.Transactions;
import com.capgemini.appl.entities.UserTable;
import com.capgemini.appl.exceptions.CustomException;

public class OnlineBankingServicesImpl implements OnlineBankingServices {
	
	private OnlineBankingDao onlineBankingDao;
	
	public OnlineBankingServicesImpl() throws CustomException{
		onlineBankingDao = new OnlineBankingDaoImpl();
	}

	@Override
	public int updateAddress(int accountId, String address)	throws CustomException {
		return onlineBankingDao.updateAddress(accountId, address);
	}

	@Override
	public int updateMobileNumber(int accountId, String phoneNo) throws CustomException {
		return onlineBankingDao.updateMobileNumber(accountId, phoneNo);
	}

	

	@Override
	public ServiceTracker trackServiceRequest(int serviceId) throws CustomException {
		return onlineBankingDao.trackServiceRequest(serviceId);
	}

	

	@Override
	public int changePassword(int accountId, String loginPassword) throws CustomException {
		return onlineBankingDao.changePassword(accountId, loginPassword);
	}

	

	@Override
	public ArrayList<Transactions> getTransactions() throws CustomException {
		return onlineBankingDao.getTransactions();
	}

	@Override
	public ArrayList<Transactions> getMiniStatement(int accountNo) throws CustomException {
		return onlineBankingDao.getMiniStatement(accountNo);
	}

	@Override
	public int insertrequestChequeBookDetails(ServiceTracker serviceTracker,
			int accountId) throws CustomException {
		
		return onlineBankingDao.insertrequestChequeBookDetails(serviceTracker, accountId);
	}

	@Override
	public int insertfundTransferDetails(FundTransfer fundTransfer,
			int accountId) throws CustomException {
		
		return onlineBankingDao.insertfundTransferDetails(fundTransfer, accountId);
	}
	
	@Override
	public boolean isUserNameExisting(int userId) throws CustomException {
		
		return onlineBankingDao.isUserNameExisting(userId);
	}

	@Override
	public String getPassword(int userId ) throws CustomException {
		
		return onlineBankingDao.getPassword(userId);
	}

	@Override
	public int createNewAccountCustomerTable(Customer customer)	throws CustomException {
		return onlineBankingDao.createNewAccountCustomerTable(customer);
	}

	@Override
	public int createNewAccountUserTable(UserTable user) throws CustomException {
		return onlineBankingDao.createNewAccountUserTable(user);
	}

	@Override
	public int createNewAccountAccountTable(AccountMaster account) throws CustomException {
		return onlineBankingDao.createNewAccountAccountTable(account);
	}

	@Override
	public UserTable getUserDetails(int userId) throws CustomException {
		
		return onlineBankingDao.getUserDetails(userId);
	}

	@Override
	public Customer getCustomerDetails(int accountId) throws CustomException {
		
		return onlineBankingDao.getCustomerDetails(accountId);
	}

	@Override
	public String getSecretAnswer(int accountId) throws CustomException {
		
		return onlineBankingDao.getSecretAnswer(accountId) ;
	}

	@Override
	public String getSecretQuestion(int accountId) throws CustomException {
		
		return onlineBankingDao.getSecretQuestion(accountId);
	}

	@Override
	public ArrayList<PayeeTable> getAllPayee(int accountId)
			throws CustomException {
		// TODO Auto-generated method stub
		return onlineBankingDao.getAllPayee(accountId);
	}

	@Override
	public int insertPayee(PayeeTable payeeTable) throws CustomException {
		// TODO Auto-generated method stub
		return onlineBankingDao.insertPayee(payeeTable);
	}

	@Override
	public double getAccountBalance(int accountId) throws CustomException {
		// TODO Auto-generated method stub
		return onlineBankingDao.getAccountBalance(accountId);
	}

	@Override
	public int updateBalanceAmount(int accountId, double accountBalance)
			throws CustomException {
		// TODO Auto-generated method stub
		return onlineBankingDao.updateBalanceAmount(accountId, accountBalance);
	}

	@Override
	public int insertTransactionDetails(Transactions transactions)
			throws CustomException {
		// TODO Auto-generated method stub
		return onlineBankingDao.insertTransactionDetails(transactions);
	}

	@Override
	public int generateOTP() {
		double randomNumFrac=Math.random();
		int random5Digits=0;
		do{
		 random5Digits=(int) (randomNumFrac*1000000);
		
		System.out.println(random5Digits);
		}while(random5Digits<10000);
		return random5Digits;

	}


	@Override
	public ArrayList<ServiceTracker> trackAllServiceRequests(int accountId)	throws CustomException {
		return onlineBankingDao.trackAllServiceRequests(accountId);
	}
	

	

}