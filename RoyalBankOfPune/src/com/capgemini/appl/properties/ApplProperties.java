package com.capgemini.appl.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ApplProperties {
	private Properties properties;
	
	public ApplProperties() throws IOException{   
		properties= new Properties();
		InputStream stream = new FileInputStream("resources\\db.properties"); 
		properties.load(stream);
	}

	public String getPropertyValue(String propertyKey){
		return (String)properties.get(propertyKey);
	}	
}
