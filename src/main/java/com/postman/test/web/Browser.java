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
	
	public static WebDriver getDriverInstance() {
		return driverMap.get(Thread.currentThread().getId());
	}
	
	public static int getWaitTime() {
		return waitTime;
	}
	
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
	
	public static void close() {
		getDriverInstance().close();
	}
	
	public static void quit() {
		try {
			getDriverInstance().quit();
		} catch(NullPointerException ne) {
			
		}
		
	}
}
