package com.postman.test.selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.postman.test.util.Config;
import com.postman.test.web.Browser;

/**
 * This class setups the before and after suites for the tests
 * @author Sean Trego
 *
 */
public class BaseTest {
	
	@BeforeSuite(alwaysRun = true)
	public void suiteRun() {
		Config.setConfig();
		Browser.invokeBrowser(System.getProperty("browser"));
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		Browser.quit();
	}

}
