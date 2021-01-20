package com.postman.test.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is clickable, then clicks the element.
	 * Added in a pageload implicit wait due to performace of page
	 * @param by
	 */
	protected void clickButton(By by) {
		waitUntilElementPresent(by);
		waitUntilElementClickable(by);
		driver.findElement(by).click();
		driver.manage().timeouts().pageLoadTimeout(Browser.getWaitTime(), TimeUnit.SECONDS);
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is present, then sends text to that element, i.e. Hello World.
	 * @param by
	 * @param value
	 */
	protected void enterText(By by, String value) {
		waitUntilElementPresent(by);
		driver.findElement(by).sendKeys(value);
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is present, then sends keys to the element, i.e. Keys.RETURN.
	 * @param by
	 * @param keys
	 */
	protected void enterText(By by, Keys keys) {
		waitUntilElementPresent(by);
		driver.findElement(by).sendKeys(keys);
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is present, then clears the text field of element.
	 * @param by
	 */
	protected void clearTextField(By by) {
		waitUntilElementPresent(by);
		driver.findElement(by).clear();
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is present, then returns the text of that element.
	 * @param by
	 * @return
	 */
	protected String getText(By by) {
		waitUntilElementPresent(by);
		return driver.findElement(by).getText();
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is present, then finds the WebElement and returns it.
	 * @param by
	 * @return
	 */
	protected WebElement getElement(By by) {
		driver.manage().timeouts().implicitlyWait(Browser.getWaitTime(), TimeUnit.SECONDS);
		waitUntilElementPresent(by);
		return driver.findElement(by);
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element is present, then finds a list of child WebElements and return them.
	 * @param by
	 * @return
	 */
	protected List<WebElement> getElements(By by){
		waitUntilElementsPresent(by);
		return driver.findElements(by);
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits till the element has text present, then returns that WebElement.
	 * @param by
	 * @param text
	 * @return
	 */
	protected WebElement waitForElementByText(By by, String text) {
		waitUntilTextPresent(by, text);
		return driver.findElement(by);
	}
	
	/**
	 * @author Sean Trego
	 * Method that creates an Actions class from a by, then returns the action instance.
	 * @param by
	 * @return
	 */
	protected Actions createActions(By by) {
		WebElement e = getElement(by);
		return new Actions(driver).moveToElement(e);
	}
	
	/**
	 * @author Sean Trego
	 * Method that takes in an integer amount seconds and does a thread.sleep.
	 * @param time
	 */
	protected void hold(Integer time) {
		try {
			Thread.sleep(time * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Sean Trego
	 * Method allows for the automation to wait until the page loads and is in a complete read state
	 */
	protected void waitUntilPageLoads() {
		ExpectedCondition<Boolean> isPageLoaded = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait.until(isPageLoaded);
	}
	
	/**
	 * @author Sean Trego
	 * Method takes a list of string and verifies that specific text is located
	 * @param list
	 * @param text
	 * @return Boolean
	 */
	public Boolean verifyTextInList(List<String> list, String text) {
		return list.stream().anyMatch(x -> x.equals(text));
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits until the element is present.
	 * @param by
	 */
	private void waitUntilElementPresent(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits until the element is clickable.
	 * @param by
	 */
	private void waitUntilElementClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits until the element is present.
	 * @param by
	 */
	private void waitUntilElementsPresent(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
	
	/**
	 * @author Sean Trego
	 * Method that waits until text is present with a specific element.
	 * @param by
	 * @param text
	 */
	private void waitUntilTextPresent(By by, String text) {
		wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
	}
	
}
