package com.postman.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	private static Properties props = new Properties();
	
	/**
	 * @author Sean Trego
	 * Method used to set the config.properties path for the properties of the test framework.
	 */
	public static void setConfig() {
		
		try(InputStream input = new FileInputStream(System.getProperty("user.dir").concat("//src//main//resources//config.properties"))){
			props.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		}	
	}
	
	/**
	 * @author Sean Trego
	 * Method used to return the value of the key given for a specific property of the config.properties file.
	 * @param key
	 * @return
	 */
	public static String getConfigValue(String key) {
		return props.getProperty(key);
	}
}
