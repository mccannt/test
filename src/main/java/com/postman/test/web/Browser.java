package com.postman.test.web;

import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.postman.test.util.Config;

public class Browser {

	private static WebDriver driver;
	private static ConcurrentHashMap<Long, WebDriver> driverMap;
	private static int waitTime = Integer.parseInt(Config.getConfigValue("wait.time"));
	
	/**
	 * @author Sean Trego
	 * Method gets a specific driver instance for parallel testing.
	 * @return
	 */
	public static WebDriver getDriverInstance() {
		return driverMap.get(Thread.currentThread().getId());
	}
	
	/**
	 * @author Sean Trego
	 * Method returns the wait time for an element or page load.  Set in the config.properties file.
	 * @return
	 */
	public static int getWaitTime() {
		return waitTime;
	}
	
	/**
	 * @author Sean Trego
	 * Method starts the browser instance. Url, driver path, etc. can be found in the config.properties file.
	 * Method does not have the chrome or firefox options setup currently, but can be added easily.
	 * @param browserType
	 * @return WebDriver instance
	 */
	public static synchronized WebDriver invokeBrowser(String browserType) {
		driverMap = new ConcurrentHashMap<>();
		browserType = browserType.toLowerCase();
		switch(browserType) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").concat(Config.getConfigValue("driver.path")).concat("\\chromedriver.exe"));
				driver = new ChromeDriver();
				driver.get(Config.getConfigValue("url.path"));
				driverMap.put(Thread.currentThread().getId(), driver);				
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir").concat(Config.getConfigValue("driver.path")).concat("\\geckodriver.exe"));
				driver = new FirefoxDriver();
				driver.get(Config.getConfigValue("url.path"));
				driverMap.put(Thread.currentThread().getId(), driver);				
				break;
			default:
				System.out.println("There is no driver setup for: " + browserType);
				driver = null;
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * @author Sean Trego
	 * Method closes a specific instance of the browser but not the driver.
	 */
	public static void close() {
		getDriverInstance().close();
	}
	
	/**
	 * @author Sean Trego
	 * Method closes the browser and driver instance.
	 */
	public static void quit() {
		try {
			getDriverInstance().quit();
		} catch(NullPointerException ne) {
			
		}
		
	}
}
