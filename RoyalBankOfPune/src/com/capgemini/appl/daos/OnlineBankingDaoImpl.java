package com.capgemini.appl.daos;

import java.sql.Connection;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

















import java.util.Collections;

import com.capgemini.appl.entities.AccountMaster;
import com.capgemini.appl.entities.Customer;
import com.capgemini.appl.entities.FundTransfer;
import com.capgemini.appl.entities.PayeeTable;
import com.capgemini.appl.entities.ServiceTracker;
import com.capgemini.appl.entities.Transactions;
import com.capgemini.appl.entities.UserTable;
import com.capgemini.appl.exceptions.CustomException;
import com.capgemini.appl.util.DbUtilJndi;

public class OnlineBankingDaoImpl implements OnlineBankingDao {
	
private DbUtilJndi utility;

private int accountId;

	public OnlineBankingDaoImpl() throws CustomException{
		utility = new DbUtilJndi();
	}

	@Override
	public int updateAddress(int accountId, String address) throws CustomException {
		String qry= "UPDATE CUSTOMER_DETAILS SET ADDRESS= ? WHERE ACCOUNT_ID= ?";
		Connection connect= null;
		PreparedStatement stmt= null;

		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			
			stmt.setString(1, address);
			stmt.setInt(2, accountId);

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				//myLogger.error("Record not inserted");
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("Data Base connection closing error in joinNewEmp", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public int updateMobileNumber(int accountId, String phoneNo) throws CustomException {
		String qry= "UPDATE CUSTOMER_DETAILS SET MOBILE_NO= ? WHERE ACCOUNT_ID= ?";
		Connection connect= null;
		PreparedStatement stmt= null;

		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			
			stmt.setString(1, phoneNo);
			stmt.setInt(2, accountId);

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				//myLogger.error("Record not inserted");
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("Data Base connection closing error in joinNewEmp", e);
				throw new CustomException(e);
			}
		}
	}

	

	@Override
	public ServiceTracker trackServiceRequest(int serviceId) throws CustomException {
		String qry = "SELECT SERVICE_ID, SERVICE_DESCRIPTION, ACCOUNT_ID, SERVICE_RAISE_DATE, SERVICE_STATUS FROM SERVICE_TRACKER WHERE SERVICE_ID= ?";  //? is a place holder, these are interactive query  "+empNo" it is sql injection
		Connection connect= null;
		PreparedStatement stmt= null;
		ResultSet rs= null;

		try {
			connect= utility.getConnectionFromPool();
			//myLogger.info("Connection Established");
			stmt= connect.prepareStatement(qry);
			//myLogger.info("Statement created");
			stmt.setInt(1, serviceId);

			rs= stmt.executeQuery();
			//myLogger.info("Executing query");

			if(rs.next()){
				String serviceDesc= rs.getString("SERVICE_DESCRIPTION");
				int accId= rs.getInt("ACCOUNT_ID");
				Date serviceRaiseDate= rs.getDate("SERVICE_RAISE_DATE");
				String serviceStatus= rs.getString("SERVICE_STATUS");
				ServiceTracker serviceTracker= new ServiceTracker(serviceId, serviceDesc, accId, serviceRaiseDate,serviceStatus );
				return serviceTracker;
			} else{
				throw new CustomException();
			}
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.fatal("Data Base network issue");
				throw new CustomException(e);
			}
		}
	}
	
	@Override
	public int insertfundTransferDetails(FundTransfer fundTransfer,int accountId)  throws CustomException{
		String qry="INSERT INTO FUND_TRANSFER (FUNDTRANSFER_ID,PAYEE_ACCOUNTID,DATE_OF_TRANSFER,TRANSFER_AMOUNT) VALUES(FUNDTRANSFER_SEQ.NEXTVAL,?,?,?) WHERE ACCOUNT_ID=?"; //verify sequence name from data source
		Connection connect=null;
		PreparedStatement stmt=null;
		//myLogger.info("createNewAccount(AccountMaster accountMaster)");

		try {
			connect=utility.getConnectionFromPool();

			stmt=connect.prepareStatement(qry);
			//myLogger.info("query executed");



			stmt.setLong(1, fundTransfer.getPayeeAccountId());
			Date transferDate= new Date(fundTransfer.getDateOfTransfer().getTime());
			stmt.setDate(2,transferDate); //date is declared as string in entity
			stmt.setDouble(3, fundTransfer.getTransferAmount());
			
			
			

			int recAffected=stmt.executeUpdate();


			
			//myLogger.info((recAffected==1)?"firm record inserted":"firm record insert failed)");
			return recAffected;

			

		} catch (SQLException e) {
			//myLogger.error("JDBC for firm record insertion failed",e);
			throw new CustomException(e);
		} finally{
			try {
				if(stmt!=null)
				{
					stmt.close();
				}
				if(connect!=null)
				{
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException("not able to close",e);
			}
		}//finally
	}
	@Override
	public int changePassword(int accountId, String loginPassword) throws CustomException{
		String qry= "UPDATE USER_DETAILS SET LOGIN_PASSWORD= ? WHERE ACCOUNT_ID= ?";
		Connection connect= null;
		PreparedStatement stmt= null;

		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			
			stmt.setString(1, loginPassword);
			stmt.setInt(2, accountId);

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				//myLogger.error("Record not inserted");
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("Data Base connection closing error in joinNewEmp", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public ArrayList<Transactions> getTransactions() throws CustomException {
		
		String qry = "SELECT TRANSACTION_ID, TRAN_DESCRIPTION, DATEOFTRANSACTION, TRANSACTIONTYPE, TRANAMOUNT, ACCOUNT_ID FROM TRANSACTION_DETAILS";
		Connection connect= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		try {
			connect= utility.getConnectionFromPool();
			//myLogger.info("Connection Established");
			stmt= connect.createStatement();
			//myLogger.info("Statement created");
			rs= stmt.executeQuery(qry);
			//myLogger.info("Executing query");
			ArrayList<Transactions> transactionList = new ArrayList<>();

			while(rs.next()){
				int tranId= rs.getInt("TRANSACTION_ID");
				String tranDesc= rs.getString("TRAN_DESCRIPTION");
				java.util.Date transactionDate= rs.getTimestamp("DATEOFTRANSACTION");
				String tranType= rs.getString("TRANSACTIONTYPE");
				double tranAmt= rs.getDouble("TRANAMOUNT");
				int accountId= rs.getInt("ACCOUNT_ID");
				
				Transactions transactions= new Transactions(tranId, tranDesc, transactionDate, tranType, tranAmt, accountId);
				transactionList.add(transactions);
				
			}	
		
				return transactionList;
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.fatal("Data Base network issue");
				throw new CustomException(e);
			}
		}
		
	}

	@Override
	public ArrayList<Transactions> getMiniStatement(int accountId) throws CustomException {
		String qry = "SELECT TRANSACTION_ID, TRAN_DESCRIPTION, DATEOFTRANSACTION, TRANSACTIONTYPE, TRANAMOUNT FROM TRANSACTION_DETAILS WHERE ACCOUNT_ID= ?";
		Connection connect= null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		
		try {
			connect= utility.getConnectionFromPool();
			//myLogger.info("Connection Established");
			stmt= connect.prepareStatement(qry);
			//myLogger.info("Statement created");
			
			stmt.setInt(1, accountId);
			
			rs= stmt.executeQuery();
			//myLogger.info("Executing query");
			ArrayList<Transactions> transactionList = new ArrayList<>();

			while(rs.next()){
				int tranId= rs.getInt("TRANSACTION_ID");
				String tranDesc= rs.getString("TRAN_DESCRIPTION");
				Date transactionDate= rs.getDate("DATEOFTRANSACTION");
				java.util.Date utilTransactionDate= new Date(transactionDate.getTime());
				String tranType= rs.getString("TRANSACTIONTYPE");
				double tranAmt= rs.getDouble("TRANAMOUNT");
				
				
				Transactions transactions= new Transactions( tranId, tranDesc, utilTransactionDate, tranType, tranAmt);
				transactionList.add(transactions);
			}	
		
				return transactionList;
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.fatal("Data Base network issue");
				throw new CustomException(e);
			}
		}
		
	}

	@Override
	public int insertrequestChequeBookDetails(ServiceTracker serviceTracker,int accountId)
			throws CustomException {
		int nextServiceId= generatServiceId();
		serviceTracker.setServiceId(nextServiceId);
		String qry="INSERT INTO SERVICE_TRACKER (SERVICE_ID, SERVICE_DESCRIPTION, ACCOUNT_ID, SERVICE_RAISE_DATE, SERVICE_STATUS) VALUES (?,?,?,?,?)";
		Connection connect=null;
		PreparedStatement stmt=null;

		try {
			connect=utility.getConnectionFromPool();

			stmt=connect.prepareStatement(qry);
			
			stmt.setInt(1, serviceTracker.getServiceId());
			stmt.setString(2, serviceTracker.getServiceDescription());
			stmt.setInt(3, accountId);
			Date sqlServiceRaiseDate= new Date(serviceTracker.getServiceRaisedDate().getTime());
			stmt.setDate(4, sqlServiceRaiseDate);
			stmt.setString(5, serviceTracker.getServiceStatus());
			
			int recAffected=stmt.executeUpdate();

			return recAffected;

		} catch (SQLException e) {
			//myLogger.error("JDBC for firm record insertion failed",e);
			e.printStackTrace();
			throw new CustomException(e);
		} finally{
			try {
				if(stmt!=null)
				{
					stmt.close();
				}
				if(connect!=null)
				{
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException("not able to close",e);
			}
		}
		
		/*String qry="INSERT INTO SERVICE_TRACKER (SERVICE_ID,SERVICE_DESCRIPTION,SERVICE_RAISED_DATE,SERVICE_STATUS) VALUES(SERVICE_SEQ.NEXTVAL,?,?,?) WHERE ACCOUNT_ID=?"; //verify sequence name from data source
		Connection connect=null;
		PreparedStatement stmt=null;
		//myLogger.info("createNewAccount(AccountMaster accountMaster)");

		try {
			connect=utility.getConnectionFromPool();

			stmt=connect.prepareStatement(qry);
			//myLogger.info("query executed");



			stmt.setString(1, serviceTracker.getServiceDescription());
			Date sqlServiceRaiseDtae= new Date(serviceTracker.getServiceRaisedDate().getTime());
			stmt.setDate(2, sqlServiceRaiseDtae);
			stmt.setString(3, serviceTracker.getServiceStatus());
			stmt.setInt(4, accountId);
			
			

			int recAffected=stmt.executeUpdate();


			
			//myLogger.info((recAffected==1)?"firm record inserted":"firm record insert failed)");
			return recAffected;

			

		} catch (SQLException e) {
			//myLogger.error("JDBC for firm record insertion failed",e);
			throw new CustomException(e);
		} finally{
			try {
				if(stmt!=null)
				{
					stmt.close();
				}
				if(connect!=null)
				{
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException("not able to close",e);
			}
		}//finally
*/	}

	@Override
	public boolean isUserNameExisting(int userId) throws CustomException {
		String qry="SELECT USER_ID FROM USER_DETAILS WHERE USER_ID=?";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//myLogger.info("Executing isUserNameExisting(String userName)");
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,userId);
			rs=stmt.executeQuery();
		
			return (rs.next())?true:false;
			
		}
		catch (SQLException e) {
			//myLogger.error("JDBC for user name validation failed", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("JDBC for user name validation failed", e);
				throw new CustomException(e);
			}
		}

	}

	
	@Override
	public String getPassword(int userId)throws CustomException {
		String qry="SELECT LOGIN_PASSWORD FROM USER_DETAILS WHERE USER_ID=?";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//myLogger.info("Executing isUserNameExisting(String userName)");
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,userId);
			rs=stmt.executeQuery();
		
			if(rs.next()){
				String loginPassword = rs.getString("LOGIN_PASSWORD");
				
				return loginPassword;
				
			} 
			else {
				throw new CustomException();
			}
			
		}
		catch (SQLException e) {
			//myLogger.error("JDBC for user name validation failed", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("JDBC for user name validation failed", e);
				throw new CustomException(e);
			}
		}

	}

	@Override
	public int createNewAccountCustomerTable(Customer customer)	throws CustomException {
		String qry= "INSERT INTO CUSTOMER_DETAILS (ACCOUNT_ID, CUSTOMER_NAME, EMAIL, ADDRESS, PANCARD, MOBILE_NO) VALUES (?, ?, ?, ?, ?, ?)";
		Connection connect= null;
		PreparedStatement stmt= null;
		
		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			stmt.setInt(1, accountId);
			stmt.setString(2, customer.getCustomerName());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getAddress());
			stmt.setString(5, customer.getPancard());
			stmt.setString(6, customer.getMobileNo());

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException(e);
			}
		}

	}

	@Override
	public int createNewAccountUserTable(UserTable user) throws CustomException {
		int nextUserId= generatUserId();
		user.setUserId(nextUserId);
		String qry= "INSERT INTO USER_DETAILS (ACCOUNT_ID, USER_ID, LOGIN_PASSWORD, SECRET_QUESTION, SECRET_ANSWER, TRANSACTION_PASSWORD, LOCK_STATUS) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection connect= null;
		PreparedStatement stmt= null;
		
		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			stmt.setInt(1, accountId);
			stmt.setInt(2, user.getUserId());
			stmt.setString(3, user.getLoginPassword());
			stmt.setString(4, user.getSecretQuestion());
			stmt.setString(5, user.getSecretAnswer());
			stmt.setString(6, user.getTransactionPassword());
			stmt.setString(7, user.getLockStatus());

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException(e);
			}
		}

	}

	@Override
	public int createNewAccountAccountTable(AccountMaster account) throws CustomException {
		accountId= generatAccountId();
		String qry= "INSERT INTO ACCOUNTS_MASTER (ACCOUNT_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE, OPEN_DATE) VALUES (?, ?, ?, ?)";
		Connection connect= null;
		PreparedStatement stmt= null;
		
		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			stmt.setInt(1, accountId);
			stmt.setString(2, account.getAccountType());
			stmt.setDouble(3, account.getAccountBalance());
			Date sqlAccOpenDate= new Date(account.getOpenDate().getTime());
			stmt.setDate(4, sqlAccOpenDate);

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException(e);
			}
		}

	}
	
	public int generatAccountId() throws CustomException{
		String qry = "select accountId_seq.nextval from dual";
		Connection connect= null; 
		Statement stmt= null;
		ResultSet rs= null;

		try {
			connect= utility.getConnectionFromPool();
			stmt= connect.createStatement();
		

			rs= stmt.executeQuery(qry);

			if(rs.next()){
				int accountId=rs.getInt(1);
				return accountId;
			}else{
				throw new CustomException();
			}
		} catch (SQLException e) {
			throw new CustomException(e);
		}finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException(e);
			}
		}
		
	}
	
	public int generatUserId() throws CustomException{
		String qry = "select userId_seq.nextval from dual";
		Connection connect= null; 
		Statement stmt= null;
		ResultSet rs= null;

		try {
			connect= utility.getConnectionFromPool();
			stmt= connect.createStatement();
		

			rs= stmt.executeQuery(qry);

			if(rs.next()){
				int userId=rs.getInt(1);
				return userId;
			}else{
				throw new CustomException();
			}
		} catch (SQLException e) {
			throw new CustomException(e);
		}finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException(e);
			}
		}
		
	}
	
	public int generatServiceId() throws CustomException{
		String qry = "select SERVICE_SEQ.NEXTVAL from dual";
		Connection connect= null; 
		Statement stmt= null;
		ResultSet rs= null;

		try {
			connect= utility.getConnectionFromPool();
			stmt= connect.createStatement();
		

			rs= stmt.executeQuery(qry);

			if(rs.next()){
				int serviceId=rs.getInt(1);
				return serviceId;
			}else{
				throw new CustomException();
			}
		} catch (SQLException e) {
			throw new CustomException(e);
		}finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException(e);
			}
		}
		
	}
	

	@Override
	public UserTable getUserDetails(int userId)  throws CustomException{
		
String qry="SELECT ACCOUNT_ID, LOGIN_PASSWORD,SECRET_QUESTION,SECRET_ANSWER, TRANSACTION_PASSWORD, LOCK_STATUS FROM USER_DETAILS WHERE  USER_ID=?";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,userId );
			rs=stmt.executeQuery();
		
			if(rs.next()){
				int account_id=rs.getInt("ACCOUNT_ID");
				String password = rs.getString("LOGIN_PASSWORD");
				String secretQuestion = rs.getString("SECRET_QUESTION");
				String secretAnswer = rs.getString("SECRET_ANSWER");
				String lockStatus1=rs.getNString("LOCK_STATUS");
				String transactionPassword = rs.getString("TRANSACTION_PASSWORD");
				
				UserTable userTable=new UserTable(account_id,userId,password,secretQuestion, secretAnswer, transactionPassword, lockStatus1);
				//myLogger.info("Mobile:"+mobile);
				
				
				return userTable;
			}
			
			else{
				//myLogger.error("Missing Mobile details"); //needs to be mentioned before throw 
				throw new CustomException();
				}
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public Customer getCustomerDetails(int accountId) throws CustomException {
String qry="SELECT ACCOUNT_ID,CUSTOMER_NAME,EMAIL,ADDRESS,PANCARD,MOBILE_NO FROM CUSTOMER_DETAILS WHERE  ACCOUNT_ID=?";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,accountId );
			rs=stmt.executeQuery();
		
			if(rs.next()){
				int account_id=rs.getInt("ACCOUNT_ID");
				String customerName = rs.getString("CUSTOMER_NAME");
				String email = rs.getString("EMAIL");
				String address = rs.getString("ADDRESS");
				String pancard=rs.getNString("PANCARD");
				String mobileNo = rs.getString("MOBILE_NO");
				
				Customer customer=new Customer(account_id,customerName,email,address,pancard,mobileNo);
				//myLogger.info("Mobile:"+mobile);
				
				
				return customer;
			}
			
			else{
				//myLogger.error("Missing Mobile details"); //needs to be mentioned before throw 
				throw new CustomException();
				}
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public String getSecretAnswer(int accountId) throws CustomException {
		
String qry="SELECT SECRET_ANSWER FROM USER_DETAILS WHERE ACCOUNT_ID=?";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,accountId );
			rs=stmt.executeQuery();
		
			if(rs.next()){
				
				String secretAnswer = rs.getString("SECRET_ANSWER");
				
				
				
				
				return secretAnswer;
			}
			
			else{
				//myLogger.error("Missing Mobile details"); //needs to be mentioned before throw 
				throw new CustomException();
				}
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public String getSecretQuestion(int accountId) throws CustomException {
String qry="SELECT SECRET_QUESTION FROM USER_DETAILS WHERE ACCOUNT_ID=?";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,accountId );
			rs=stmt.executeQuery();
		
			if(rs.next()){
				
				String secretQuestion = rs.getString("SECRET_QUESTION");
				
				
				
				
				return secretQuestion;
			}
			
			else{
				//myLogger.error("Missing Mobile details"); //needs to be mentioned before throw 
				throw new CustomException();
				}
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public ArrayList<PayeeTable> getAllPayee(int accountId)
			throws CustomException {
		String qry="SELECT ACCOUNT_ID,PAYEE_ACCOUNT_ID,NICK_NAME FROM PAYEE WHERE ACCOUNT_ID=?";//interactive queries

		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,accountId);
			
			rs=stmt.executeQuery();
			//myLogger.info("qry executed");
			ArrayList<PayeeTable> PayeeTableList=new ArrayList<>();

			while(rs.next()){
				int payeeId=rs.getInt("PAYEE_ACCOUNT_ID");
				String nickName=rs.getString("NICK_NAME");
				PayeeTable payeeTable= new PayeeTable(accountId,payeeId,nickName);
				PayeeTableList.add(payeeTable);
				
				for (PayeeTable p : PayeeTableList) {
					System.out.println(p);
				}
				//myLogger.info("Mobile:"+mobile);
				
			}
			return PayeeTableList;
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}

	}

	@Override
	public int insertPayee(PayeeTable payeeTable) throws CustomException {
String qry="INSERT INTO PAYEE (ACCOUNT_ID,PAYEE_ACCOUNT_ID,NICK_NAME) VALUES (?,?,?)";//interactive queries
		
		Connection connect=null;
		PreparedStatement stmt = null;
		
		try {
			connect=utility.getConnectionFromPool();//CONECTION IS OBTAINED
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,payeeTable.getAccountId() );
			stmt.setInt(2,payeeTable.getPayeeAccountId());
			stmt.setString(3,payeeTable.getNickName());
			
			
			int recAffected =stmt.executeUpdate();
		
			if(recAffected==0){
				throw new CustomException("Record not inserted");
				}
			else{
				return recAffected;
			}
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public double getAccountBalance(int accountId) throws CustomException {
		String qry="SELECT ACCOUNT_BALANCE FROM ACCOUNTS_MASTER WHERE ACCOUNT_ID=?";//interactive queries


		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connect=utility.getConnectionFromPool();
			
			stmt=connect.prepareStatement(qry);
			stmt.setInt(1,accountId );
			rs=stmt.executeQuery();
		
			if(rs.next()){
				
				double accountBalance = rs.getDouble("ACCOUNT_BALANCE");
				
				
				//myLogger.info("Mobile:"+mobile);
				
				
				return accountBalance;
			}
			
			else{
				//myLogger.error("Missing Mobile details"); //needs to be mentioned before throw 
				throw new CustomException();
				}
		}
		catch (SQLException e) {
			//myLogger.error("exception sql", e);
			throw new CustomException(e);
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connect!=null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("closing failed", e);
				throw new CustomException(e);
			}
		}
	
	}

	@Override
	public int updateBalanceAmount(int accountId, double accountBalance)
			throws CustomException {
		String qry= "UPDATE ACCOUNTS_MASTER SET ACCOUNT_BALANCE= ? WHERE ACCOUNT_ID= ?";
		Connection connect= null;
		PreparedStatement stmt= null;

		try {
			connect= utility.getConnectionFromPool();

			stmt= connect.prepareStatement(qry);
			
			stmt.setDouble(1, accountBalance);
			stmt.setInt(2, accountId);

			int recAffected= stmt.executeUpdate();

			if(recAffected==0){
				//myLogger.error("Record not inserted");
				throw new CustomException("Record Not Inserted");
			} else{
				return recAffected;
			}
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.error("Data Base connection closing error in joinNewEmp", e);
				throw new CustomException(e);
			}
		}
	}

	@Override
	public int insertTransactionDetails(Transactions transactions)
			throws CustomException {
		String qry="INSERT INTO TRANSACTION_DETAILS (TRANSACTION_ID,TRAN_DESCRIPTION,DATEOFTRANSACTION,TRANSACTIONTYPE,TRANAMOUNT,ACCOUNT_ID) VALUES(TRANID_SEQ.NEXTVAL,?,?,?,?,?)"; //verify sequence name from data source
		Connection connect=null;
		PreparedStatement stmt=null;
		//myLogger.info("createNewAccount(AccountMaster accountMaster)");

		try {
			connect=utility.getConnectionFromPool();

			stmt=connect.prepareStatement(qry);
			//myLogger.info("query executed");



			stmt.setString(1,transactions.getTranDescription());
			Date sqlTransDate= new Date(transactions.getDateOfTransaction().getTime());
			stmt.setDate(2,sqlTransDate);
			stmt.setString(3,transactions.getTransactionType());
			stmt.setDouble(4,transactions.getTranAmount());
			stmt.setInt(5,transactions.getAccountId());
			
			
			

			int recAffected=stmt.executeUpdate();


			
			//myLogger.info((recAffected==1)?"firm record inserted":"firm record insert failed)");
			return recAffected;

			

		} catch (SQLException e) {
			//myLogger.error("JDBC for firm record insertion failed",e);
			throw new CustomException(e);
		} finally{
			try {
				if(stmt!=null)
				{
					stmt.close();
				}
				if(connect!=null)
				{
					connect.close();
				}
			} catch (SQLException e) {
				throw new CustomException("not able to close",e);
			}
		}//finally
	}
	
	
	@Override
	public ArrayList<ServiceTracker> trackAllServiceRequests(int accountId)	throws CustomException {
		String qry = "SELECT SERVICE_ID, SERVICE_DESCRIPTION, ACCOUNT_ID, SERVICE_RAISE_DATE, SERVICE_STATUS FROM SERVICE_TRACKER WHERE ACCOUNT_ID= ?";  //? is a place holder, these are interactive query  "+empNo" it is sql injection
		Connection connect= null;
		PreparedStatement stmt= null;
		ResultSet rs= null;

		try {
			connect= utility.getConnectionFromPool();
			
			stmt= connect.prepareStatement(qry);
			
			stmt.setInt(1, accountId);

			rs= stmt.executeQuery();
			ArrayList<ServiceTracker> serviceList= new ArrayList<>();

			while(rs.next()){
				String serviceDesc= rs.getString("SERVICE_DESCRIPTION");
				int serviceId= rs.getInt("SERVICE_ID");
				Date serviceRaiseDate= rs.getDate("SERVICE_RAISE_DATE");
				String serviceStatus= rs.getString("SERVICE_STATUS");
				ServiceTracker serviceTracker= new ServiceTracker(serviceId, serviceDesc, accountId, serviceRaiseDate, serviceStatus);
				serviceList.add(serviceTracker);
				}
				return serviceList;
		} catch (SQLException e) {
			//myLogger.fatal("Contact admin for network issues");
			throw new CustomException(e);
		} finally{
			try {
				if(rs !=null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				//myLogger.fatal("Data Base network issue");
				throw new CustomException(e);
			}
		}
	}
	

		
}