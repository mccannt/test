package com.postman.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	private static Properties props = new Properties();
	public static void setConfig() {
		
		try(InputStream input = new FileInputStream(System.getProperty("user.dir").concat("//src//main//resources//config.properties"))){
			props.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		}	
	}
	
	public static String getConfigValue(String key) {
		return props.getProperty(key);
	}
}
