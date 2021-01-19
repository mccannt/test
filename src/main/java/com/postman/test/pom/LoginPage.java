package com.postman.test.pom;

import org.openqa.selenium.By;

import com.postman.test.util.Config;

public class LoginPage extends HomeTabPage {
	
	//By elements
	private By iEmailOrUsername = By.id("username");
	private By iPassword = By.id("password");
	private By btnSignIn = By.id("sign-in-btn");
	
	//Methods
	/**
	 * @author Sean Trego
	 * This method enters the email or username from the config.properties file to the Login Page
	 */
	public void enterEmailOrUsername() {
		enterText(iEmailOrUsername, Config.getConfigValue("username"));
	}
	
	/**
	 * @author Sean Trego
	 * This method enters the password from the config.properties file to the Login Page
	 * NOTE: Since this is a test project, i would normally keep this out of the GIT repo and hide somewhere locally or use something
	 * like CyberArk to hold the password.
	 */
	public void enterPassword() {
		enterText(iPassword, Config.getConfigValue("password"));
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the sign in button.
	 * @return YourWorkspaces instance
	 */
	public YourWorkspaces clickSignIn() {
		clickButton(btnSignIn);
		hold(5);
		return new YourWorkspaces();
	}

}
