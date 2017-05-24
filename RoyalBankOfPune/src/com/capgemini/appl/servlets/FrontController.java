package com.capgemini.appl.servlets;

import java.io.IOException;





import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.appl.entities.AccountMaster;
import com.capgemini.appl.entities.Customer;
import com.capgemini.appl.entities.PayeeTable;
import com.capgemini.appl.entities.ServiceTracker;
import com.capgemini.appl.entities.Transactions;
import com.capgemini.appl.entities.UserTable;
import com.capgemini.appl.exceptions.CustomException;
import com.capgemini.appl.services.OnlineBankingServices;
import com.capgemini.appl.services.OnlineBankingServicesImpl;
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;



@WebServlet({ "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OnlineBankingServices services;
	RequestDispatcher dispatch=null;
	String jspName=null;
	HttpSession session=null;
	HttpSession sessionAdmin= null;
	HttpSession sessionForgotPassword= null;
	HttpSession sessionAttemptCounter= null;
	

	@Override
	public void init() throws ServletException {

		super.init();
		try {
			services = new OnlineBankingServicesImpl();
			super.log("Acquired core dependency");
		} catch (CustomException e) {
			super.log("failed in Acquiring core dependency",e);
			jspName="/Errors.jsp";
		}
	}


	
	protected void  processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String command= request.getServletPath();
		System.out.println(command);

		switch(command){

		case "/mainMenu.do": {

			jspName="/HomePage.jsp";
			break;
		}
		case "/authenticate.do":{//three attemp still pending
			try {


				sessionAttemptCounter=request.getSession();
				Integer attemptCounter=1;
				sessionAttemptCounter.setAttribute("attemptCounter", attemptCounter);
				
				String struserId=request.getParameter("uname");

				int userId=Integer.parseInt(struserId);

				String password=request.getParameter("psw");

				

				boolean count=services.isUserNameExisting(userId);

				if(count==true){
					UserTable userTable=services.getUserDetails(userId);
					String passwordFromTable= services.getPassword(userId);

							if(password.equals(passwordFromTable)){
								session=request.getSession();
								session.setAttribute("userTable", userTable);

								Customer customer=services.getCustomerDetails(userTable.getAccountId());

								session.setAttribute("customer", customer);

								double accountBalance=services.getAccountBalance(userTable.getAccountId());

								request.setAttribute("accountBalance", accountBalance);
								
								jspName= "/AfterLogin.jsp";  

							}else{
							String message1="Invalid Password";
							request.setAttribute("message1", message1);
							jspName="/InvalidCredentials.jsp";

					/*String message="wrong user name or pasword";

					request.setAttribute("message", message);*/
					/*attemptCounter++;
					if(attemptCounter<=3){
						
						

						request.setAttribute("message1", message1);
						jspName="/InvalidCredentials.jsp";
					    }else{
						
						      sessionAttemptCounter.invalidate();
						      jspName="/forgotPassword.jsp";
					    }
					*/


				} }else {
					String message1="Username does not Exist";
					request.setAttribute("message1", message1);
					jspName="/InvalidCredentials.jsp";

				}
				

			} catch (CustomException e) {

				request.setAttribute("message", "problems in DB for authentication"+command);
				jspName="/Errors.jsp";
			}
			break;
		}

		case "/getBalance.do": {

			try {
				UserTable userTable= (UserTable) session.getAttribute("userTable");
				double balanceAmount= services.getAccountBalance(userTable.getAccountId());
				request.setAttribute("balanceAmount", balanceAmount);
				
				jspName="/getBalance.jsp";
			} catch (CustomException e) {
				
				e.printStackTrace();
			}
			break;
		}
		case "/chequeLayout.do": {

			jspName="/chequeLayout.jsp";
			break;
		}
		
		case "/requestCheck.do": {
			try {
				
				//String serviceDesc=request.getParameter("serviceDesc");
				
				Date today=new Date();
				
				String serviceDesc="New ChequeBook Request";
				String serviceStatus="IN PROCESS";
				UserTable userTable= (UserTable) session.getAttribute("userTable");
				
				int accountId=userTable.getAccountId();
				

				ServiceTracker serviceTracker=new ServiceTracker(serviceDesc,accountId,today,serviceStatus);
				
				int count=services.insertrequestChequeBookDetails(serviceTracker, accountId);
				
				if(count==0){
					request.setAttribute("message", "problems in insertion");
					jspName="/Errors.jsp";
				}else{
					System.out.println("8");
					request.setAttribute("message", "Chequebook Requested Successfully");
					jspName="/success.jsp"; 
				}

			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		case "/changeAddress.do": {

			Customer customer= (Customer) session.getAttribute("customer");
			String address= customer.getAddress();
			session.setAttribute("address", address);
			
			jspName="/addresschange.jsp";
			break;
		}

		case "/addressChanged.do": {
			try {
				
				String address1=request.getParameter("address1");
				UserTable userTable= (UserTable) session.getAttribute("userTable");

				int accountId=userTable.getAccountId();

				int count = services.updateAddress(accountId, address1);

				if(count==0){
					request.setAttribute("message", "problems in updation");
					jspName="/Errors.jsp";
				}else{

					request.setAttribute("message", "Address Successfully Updated");
					jspName="/success.jsp";
				}

			}

			catch (NumberFormatException e) {
				super.log("failed in Acquiring core dependency",e);
				request.setAttribute("message", "problems in conversion of salary");
				jspName="/Errors.jsp";
			} catch (CustomException e) {
				super.log("failed in Acquiring core dependency",e);
				request.setAttribute("message", "problems in insert for given customer");
				jspName="/Errors.jsp";
			}





			break;
		}

		case "/changePassword.do": {

			jspName="/ChangePassword.jsp";
			break;
		}
		case "/nowChangePassword.do": {
			try {
				
				String oldPassword=request.getParameter("oldPassword");
				String newPassword=request.getParameter("newPassword");
				UserTable userTable= (UserTable) session.getAttribute("userTable");
				

				if(oldPassword.equals(userTable.getLoginPassword()))
				{
					int count=services.changePassword(userTable.getAccountId(), newPassword);
						if(count==0)
						{
							request.setAttribute("message", "problems in updation");
							jspName="/Errors.jsp"; //todo
						} else {
							request.setAttribute("message", "password changed");
							jspName="/success.jsp";
						}
				} else {
					request.setAttribute("message", "old password does not match");
					jspName="/ChangePassword.jsp";
				
				}
				
			}

			catch (NumberFormatException e) {
				super.log("failed in Acquiring core dependency",e);
				request.setAttribute("message", "problems in conversion of salary");
				jspName="/Errors.jsp";
			} catch (CustomException e) {
				super.log("failed in Acquiring core dependency",e);
				request.setAttribute("message", "problems in insert for given customer");
				jspName="/Errors.jsp";
			}





			break;
		}


		case "/changeMobileNo.do": {

			jspName="/changeMobileNo.jsp";
			break;
		}
		
		case "/numberChanged.do": {
			try {
				//get parameters from EntryForm.jsp
				String oldMobileNo=request.getParameter("oldMobileNo");
				String newMobileNo=request.getParameter("newMobileNo");
		
				//validation for JDBC
				//populate values in User object
				//Customer customer = new Customer(address1);

				//Customer customer = new Customer(customer.getAccountId(),newMobileNo);
				
				Customer customer= (Customer) session.getAttribute("customer");
				if(oldMobileNo.equals(customer.getMobileNo()))
						{
					      int count=services.updateMobileNumber(customer.getAccountId(), newMobileNo);

					       if(count==0){
						     request.setAttribute("message", "mobile number cant be updated");
						     jspName="/changeMobileNo.jsp";
					       }else{
						      request.setAttribute("message", "Mobile number successfully changed");
						      jspName="/success.jsp";
					       }
						} else {
						
						request.setAttribute("message", "(Old mobile number does not match)");
						jspName="/changeMobileNo.jsp";
					}

				}
			
			catch (NumberFormatException e) {
				super.log("failed in Acquiring core dependency",e);
				request.setAttribute("message", "problems in conversion of salary");
				jspName="/Errors.jsp";
			} catch (CustomException e) {
				super.log("failed in Acquiring core dependency",e);
				request.setAttribute("message", "problems in insert for given customer");
				jspName="/Errors.jsp";
			}



			
			
			break;
		}

		/*case "/trackService.do": {

			jspName="/trackServiceLayout.jsp";
			break;
		}*/
		case "/trackService.do": {
			try {
				UserTable userTable= (UserTable) session.getAttribute("userTable");
				
				int accountId= userTable.getAccountId();
				
				System.out.println(accountId);
				
				ArrayList<ServiceTracker> serviceList= services.trackAllServiceRequests(accountId);
				
				for(ServiceTracker service : serviceList){
					System.out.println(service);
				}
				
				session.setAttribute("serviceList", serviceList);
				jspName="/trackServiceLayout.jsp";
			} catch (CustomException e) {
				e.printStackTrace();
			}
			
			break;
		}
		
		case "/getServiceDetails.do":{
			System.out.println("in get service details .do");
				try {
					String strServiceId= request.getParameter("serviceId");
					
					System.out.println(strServiceId);
					
					int serviceId= Integer.parseInt(strServiceId);
					
					System.out.println(serviceId);
					
					ServiceTracker serviceTracker= services.trackServiceRequest(serviceId);
				
					System.out.println(serviceTracker);
					
					session.setAttribute("serviceTracker", serviceTracker);
					
					jspName="/showServiceDetails.jsp";
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (CustomException e) {
					e.printStackTrace();
				}
			
			break;
		}


		case "/forgotPassword.do": {

			jspName="/forgotPassword.jsp";//todo
			break;
		}

		case "/showOTPforPassword.do": {
			

			String strAccountId= request.getParameter("accountId");
			int accountId=Integer.parseInt(strAccountId);
			sessionForgotPassword=request.getSession();
			sessionForgotPassword.setAttribute("accountId", accountId);
			
			
			
			
					int otp=services.generateOTP();
					//String secretQuestion= services.getSecretQuestion(accountId);
					
					sessionForgotPassword.setAttribute("otp", otp);
					request.setAttribute("otp", otp);
				
				
			
			jspName="/AcceptOTPforPassword.jsp";
			break;
		}
		
		case "/generateNewPassword.do": {

			
				try {
					int accountId=(int) sessionForgotPassword.getAttribute("accountId");
					String strotp=request.getParameter("otp");
					int otp= Integer.parseInt(strotp);
					int sessionOTP=(int) sessionForgotPassword.getAttribute("otp");
					if(otp==sessionOTP){
						int count=services.changePassword(accountId, "NEWpass11");
						request.setAttribute("message", "new password in NEWpass11");
						   jspName="/HomePage.jsp";
					} else {
						request.setAttribute("message", "secret answer does not match try again");
						jspName="/HomePage.jsp";
					}
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (CustomException e) {
					
					e.printStackTrace();
				}
				
				//String secretAnswer= services.getSecretAnswer(accountId);
				//String enteredSecretAnswer=request.getParameter("secretAnswer");
				/*if(secretAnswer.equals(enteredSecretAnswer))
				{
					int count=services.changePassword(accountId, "NEWpass11");
					   if(count==0){
						//error
					   }else{
						   request.setAttribute("message", "new password in NEWpass11");
						   jspName="/HomePage.jsp";
					   }
				} else{
					request.setAttribute("message", "secret answer does not match try again");
					jspName="/HomePage.jsp";
				}*/
			
			
			
			break;
		}
		
		case "/adminLogin.do": {

			jspName="/AdminLogin.jsp";
			break;
		}
		
		case "/authenticateAdmin.do": {
			String userName= request.getParameter("userName");
			String password= request.getParameter("password");

			if((userName.equals("admin")&&password.equals("admin"))){
				sessionAdmin= request.getSession(true);
				jspName="/AdminPage.jsp";
			}else {
				System.out.println("wrong credentials");
				jspName="/ErrorLogin.jsp";
			}
			
			break;
		}
		
		case "/adminCreateAccount.do":{
			
			jspName="/CreateNewAccount.jsp";
			break;
		}
		
		case "/adminGetTrans.do":{
			
			jspName="/adminGetTransaction.jsp";
			break;
		}
		
		case "/getAllTransactionAdmin.do":{
			
			try {
				ArrayList<Transactions> transactionList=services.getTransactions();
				request.setAttribute("transactionList", transactionList);
			} catch (CustomException e) {
				
				e.printStackTrace();
			}
			
			jspName="/getAllTransactionAdminList.jsp";
			break;
		}
		
		case "/logoutAdmin.do": {
			sessionAdmin.invalidate();
			
			jspName="/HomePage.jsp";
			break;
		}
		
		case "/registerNewaccount.do": {
			
			try {
				System.out.println("1");
				String accHolderName= request.getParameter("name");
				String address= request.getParameter("address");
				String mobileNo= request.getParameter("mob");
				String email= request.getParameter("mail");
				String pancard= request.getParameter("pancard");
				String accType= request.getParameter("accType");
				String password= request.getParameter("password");
				String secretQuestion= request.getParameter("secretQuestion");
				String secretAnswer= request.getParameter("secretAnswer");
				String transactionPassword= request.getParameter("transactionPassword");
				String strBalance= request.getParameter("balance");
				System.out.println("2");
				double balance= Double.parseDouble(strBalance);
				Date today= new Date();
				System.out.println("3");
				AccountMaster master= new AccountMaster(accType, balance, today);
				Customer customer= new Customer(accHolderName, email, address, pancard, mobileNo);
				UserTable user= new UserTable(password, secretQuestion, secretAnswer, transactionPassword, "N");
				System.out.println("4");
				System.out.println(master);
				System.out.println(customer);
				System.out.println(user);
				
				int count1= services.createNewAccountAccountTable(master);
				int count2= services.createNewAccountCustomerTable(customer);
				int count3= services.createNewAccountUserTable(user);
				
				if(count1==1&&count2==1&&count3==1){
					request.setAttribute("message", "Successfully Registered");
					jspName="/success.jsp"; //todo
					
				}else{
					jspName=""; //todo
					System.out.println("error insert");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (CustomException e) {
				e.printStackTrace();
			}
			
			break;
		}
		
		case "/fundTransfer.do": {
			jspName="/fundTransfer.jsp";
			break;
		}
		
		case "/fundTransferFromOwnAcct.do": {
			//System.out.println("1");
			UserTable userTable= (UserTable) session.getAttribute("userTable");
			//System.out.println("2");
			int accountId=userTable.getAccountId();
			//System.out.println(accountId);
			//System.out.println("3");
			try {
				//System.out.println("4");
				ArrayList<PayeeTable> payeeTableList= services.getAllPayee(accountId);
				//System.out.println("5");
				
				request.setAttribute("payeeTableList", payeeTableList);
				for (PayeeTable payeeTable : payeeTableList) {
					System.out.println(payeeTable);
				}
				//System.out.println("6");
				jspName="/ViewPayeeList.jsp";
			} catch (CustomException e) {
				e.printStackTrace();
				request.setAttribute("message", "problems in fetching list of payee");
				jspName="/Errors.jsp";
			}
			//System.out.println("7");
			//jspName="/fundTransfer.jsp";
			break;
		}
		case "/fundTransferOperation.do": {
			String strPayeeAcctId=request.getParameter("PayeeAccountId");
			int payeeAcctId=Integer.parseInt(strPayeeAcctId);
			session.setAttribute("payeeAcctId", payeeAcctId);
			
			jspName="/fundTransferOperation.jsp";
			break;
		}
		case "/fundTransferActivation.do": {
			try {
				System.out.println("8");
				String transPass=request.getParameter("transPass");
				System.out.println("9");
				String strAmount=request.getParameter("enterAmount");
				System.out.println("10");
				double amount=Double.parseDouble(strAmount);
				System.out.println("11");
				//String strPayeeAcctId=request.getParameter("PayeeAccountId");
				
				//session.setAttribute("strPayeeAcctId", strPayeeAcctId);
				
				//System.out.println(strPayeeAcctId);
				//int payeeAcctId=Integer.parseInt(strPayeeAcctId);
				System.out.println("13");
				UserTable userTable= (UserTable) session.getAttribute("userTable");
				System.out.println("14");
				String transactionPassword=userTable.getTransactionPassword();
				int payeeAcctId=(int) session.getAttribute("payeeAcctId");
				System.out.println(userTable);
				System.out.println(payeeAcctId);
				System.out.println(transactionPassword);
				System.out.println(transPass);
				
				if(transPass.equals(transactionPassword)){

					System.out.println("16");
					double accountBalanceSender=services.getAccountBalance(userTable.getAccountId());
					System.out.println("17");
					double accountBalanceReciever=services.getAccountBalance(payeeAcctId);
					System.out.println("18");
					
					      if(accountBalanceSender>=amount){
					    	  System.out.println("19");
					    	  int count1=services.updateBalanceAmount(userTable.getAccountId(), accountBalanceSender-amount);
					    	  System.out.println("20");
					    	  int count2=services.updateBalanceAmount(payeeAcctId, accountBalanceReciever+amount);
					    	  System.out.println("21");
						     //to do updation in transaction
					    	  		if(count1==1 && count2==1){

										String tranDesc= "Funds Transfer";
					    	  			Date today= new Date();
					    	  			String tranTypeSender= "Debited";
					    	  			String tranTypeReciever= "Credited";
					    	  			int senderAccId= userTable.getAccountId();
					    	  			
					    	  			
					    	  			
					    	  			Transactions transactionSender=new Transactions(tranDesc, today, tranTypeSender, amount, senderAccId);
					    	  			int count3=services.insertTransactionDetails(transactionSender);
					    	  			Transactions transactionreciever= new Transactions(tranDesc, today, tranTypeReciever, amount, payeeAcctId);
					    	  			int count4= services.insertTransactionDetails(transactionreciever);
					    	  			if(count3==1&&count4==1){
					    	  				
					    	  				request.setAttribute("message", "Fund Successfully Transfered");
					    	  				jspName="/success.jsp";
					    	  				
					    	  				
					    	  				
					    	  				
					    	  			}else{
					    	  				jspName="/errors.jsp";
					    	  			}

					      				request.setAttribute("message", "insufficient balance");
					      				jspName="/Errors.jsp";
					      				}
					      }
						}else{
					System.out.println("22");
					String message="wrong user name or pasword";
					System.out.println("23");
					request.setAttribute("message", message);
					jspName="/Login.jsp";


				}
				request.setAttribute("message", "Fund Successfully Transfered");
  				jspName="/success.jsp";
				
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (CustomException e) {
				
				e.printStackTrace();
			}
			break;
		}
		
		case "/addPayee.do": {

			jspName="/addPayee.jsp";
			break;
		}
		
		case "/nowAddPayee.do": {

			try {
				
				
				PayeeTable payeeTable= (PayeeTable) session.getAttribute("payeeTable");
				int count=services.insertPayee(payeeTable);
				if(count==0){
					jspName="/error.jsp";//todo
					
				} else{
					request.setAttribute("message", "Payee Added Successfully");//todo
					jspName="/success.jsp";
					
				}
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (CustomException e) {
				
				e.printStackTrace();
			}
			break;
		}

		case "/showOTP.do": {


			String strPayeeAccountId=request.getParameter("payeeAccountId");
			int payeeAccountId=Integer.parseInt(strPayeeAccountId);
			String nickName=request.getParameter("nickName");
			UserTable userTable= (UserTable) session.getAttribute("userTable");
			PayeeTable payeeTable= new PayeeTable(userTable.getAccountId(),payeeAccountId,nickName);
			session.setAttribute("payeeTable", payeeTable);
			
			int otp = services.generateOTP();
			session=request.getSession(true);
			session.setAttribute("otp", otp);
			jspName="/showOTP.jsp";

			break;
		}

		case "/getotpEntryPage.do": {
			jspName="/acceptOTP.jsp";

			break;
		}
		
		case "/miniStatement.do": {

			try {
				UserTable userTable= (UserTable) session.getAttribute("userTable");
				int accountId= userTable.getAccountId();
				
				double accountBalance=services.getAccountBalance(userTable.getAccountId());

				request.setAttribute("accountBalance", accountBalance);
				
				System.out.println(accountId);
				ArrayList<Transactions> transactionList=services.getMiniStatement(accountId);
				for(Transactions transactions : transactionList){
					System.out.println(transactions);
				}
				System.out.println("1");
				int arrayListSize= transactionList.size();
				System.out.println(arrayListSize);
				
				if(arrayListSize<5){
					request.setAttribute("transactionList", transactionList);
					jspName="/MiniStatement1.jsp"; //todo
				} else{
				ArrayList<Transactions> newList= new ArrayList<Transactions>();
				System.out.println(newList);
				for(int i=arrayListSize;i>arrayListSize-5;i--){
					newList.add(transactionList.get(i-1));
				}
					request.setAttribute("newList", newList);
					
					
					jspName="/MiniStatement.jsp";
				}
				
			} catch (CustomException e) {
				
				e.printStackTrace();
			}
			
			break;
		}
		
		case "/logout.do": {
			session.invalidate();
			jspName="/Logout.jsp";

			break;
		}
	
		default :{
			request.setAttribute("message", "problems in URL"+command);
			jspName="/Errors.jsp";
		}
		}

		dispatch=request.getRequestDispatcher(jspName);
		dispatch.forward(request, response);


	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
}