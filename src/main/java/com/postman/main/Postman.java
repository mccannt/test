package com.postman.main;

import java.io.IOException;

public class Postman {

/**
 * @author Sean Trego
 * main method that calls to the create the testNG.xml from command line params
 * @param args
 * @throws IOException
 * @throws InterruptedException
 */
public static void main(String[] args) throws IOException, InterruptedException {
		
		XmlWriter.createXmlFile();
		
	}
}
