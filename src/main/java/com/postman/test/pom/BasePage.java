package com.postman.test.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.postman.test.web.Browser;

public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage() {
		this.driver=Browser.getDriverInstance();
		this.wait=new WebDriverWait(driver, Browser.getWaitTime());
	}
	
	protected void clickButton(By by) {
		
		waitUntilElementClickable(by);
		driver.findElement(by).click();
		driver.manage().timeouts().pageLoadTimeout(Browser.getWaitTime(), TimeUnit.SECONDS);
	}
	
	protected void enterText(By by, String value) {
		waitUntilElementPresent(by);
		driver.findElement(by).sendKeys(value);
	}
	
	protected void enterText(By by, Keys keys) {
		waitUntilElementPresent(by);
		driver.findElement(by).sendKeys(keys);
	}
	
	protected void clearTextField(By by) {
		waitUntilElementPresent(by);
		driver.findElement(by).clear();
	}
	
	protected String getText(By by) {
		waitUntilElementPresent(by);
		return driver.findElement(by).getText();
	}
	
	protected WebElement getElement(By by) {
		driver.manage().timeouts().implicitlyWait(Browser.getWaitTime(), TimeUnit.SECONDS);
		waitUntilElementPresent(by);
		return driver.findElement(by);
	}
	
	protected List<WebElement> getElements(By by){
		waitUntilElementsPresent(by);
		return driver.findElements(by);
	}
	
	protected WebElement waitForElementByText(By by, String text) {
		waitUntilTextPresent(by, text);
		return driver.findElement(by);
	}
	
	protected Actions createActions(By by) {
		WebElement e = getElement(by);
		return new Actions(driver).moveToElement(e);
	}
	
	protected void hold(Integer time) {
		try {
			Thread.sleep(time * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void waitUntilElementPresent(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	private void waitUntilElementClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	private void waitUntilElementsPresent(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
	
	private void waitUntilTextPresent(By by, String text) {
		wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
	}
	
}
