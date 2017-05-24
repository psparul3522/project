package com.capgemini.appl.daos;

import java.util.ArrayList;






import com.capgemini.appl.entities.AccountMaster;
import com.capgemini.appl.entities.Customer;
import com.capgemini.appl.entities.FundTransfer;
import com.capgemini.appl.entities.PayeeTable;
import com.capgemini.appl.entities.ServiceTracker;
import com.capgemini.appl.entities.Transactions;
import com.capgemini.appl.entities.UserTable;
import com.capgemini.appl.exceptions.CustomException;

public interface OnlineBankingDao {
	
	int updateAddress(int accountId, String address) throws CustomException;   //done
	int updateMobileNumber(int accountId, String phoneNo) throws CustomException; //done
	int insertrequestChequeBookDetails(ServiceTracker serviceTracker,int accountId) throws CustomException;	//done
	ServiceTracker trackServiceRequest(int serviceId) throws CustomException; //todo
	ArrayList<ServiceTracker> trackAllServiceRequests(int accountId) throws CustomException;
	
	int insertfundTransferDetails(FundTransfer fundTransfer,int accountId) throws CustomException;	//todo	
	int changePassword(int accountId, String loginPassword) throws CustomException; //done
	
	//insert new account
	int createNewAccountCustomerTable(Customer customer) throws CustomException; //done
	int createNewAccountUserTable(UserTable user) throws CustomException; //done
	int createNewAccountAccountTable(AccountMaster account) throws CustomException; //done
	
	
	ArrayList<Transactions> getTransactions() throws CustomException;//todo
	ArrayList<Transactions> getMiniStatement(int accountId) throws CustomException;//todo
	boolean isUserNameExisting(int userId) throws CustomException; 
	String getPassword(int userId) throws CustomException;
	UserTable getUserDetails(int userId) throws CustomException;
	Customer getCustomerDetails(int accountId) throws CustomException;
	
	String getSecretAnswer(int accountId) throws CustomException;
	String getSecretQuestion(int accountId) throws CustomException;
	
	ArrayList<PayeeTable>getAllPayee(int accountId) throws CustomException;
	int insertPayee(PayeeTable payeeTable) throws CustomException;
	double getAccountBalance(int accountId) throws CustomException;
	//fund transfer
		
		int updateBalanceAmount(int accountId,double accountBalance)throws CustomException;
		int insertTransactionDetails(Transactions transactions) throws CustomException;
		
	}

	
