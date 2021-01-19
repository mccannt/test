package com.postman.test.pom;

import org.openqa.selenium.By;

import com.postman.test.util.Config;

public class LoginPage extends HomeTabPage {
		
	private By iEmailOrUsername = By.id("username");
	private By iPassword = By.id("password");
	private By btnSignIn = By.id("sign-in-btn");
	
	public void enterEmailOrUsername() {
		enterText(iEmailOrUsername, Config.getConfigValue("username"));
	}
	
	public void enterPassword() {
		enterText(iPassword, Config.getConfigValue("password"));
	}
	
	public YourWorkspaces clickSignIn() {
		clickButton(btnSignIn);
		hold(5);
		return new YourWorkspaces();
	}

}
