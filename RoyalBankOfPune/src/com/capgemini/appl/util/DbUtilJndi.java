package com.capgemini.appl.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




import com.capgemini.appl.exceptions.CustomException;

//java:/jdbc/RituDs
public class DbUtilJndi {
	
	private DataSource dataSource;
	static Logger myLogger = Logger.getLogger("BusinessRegistration");
	
	//constructor
	public DbUtilJndi() throws CustomException{
		try{
			Context ctx =new InitialContext(); //brings a proxy reference of JNDI
			dataSource=(DataSource)ctx.lookup("java:/jdbc/PratimaDs"); //brings a proxy reference of DataSource
			myLogger.info("Acquired data source");
		} catch (NamingException e) {
			throw new CustomException("something went wrong in datasource creation",e);
			
		
		}
	}
	
	public Connection getConnectionFromPool() throws CustomException{
		try{
			myLogger.info("Request for JDBC connection");
		return dataSource.getConnection();
	}catch (SQLException e){
		throw new CustomException("something went wrong in connection from DataSource",e);
	}

	}
}
