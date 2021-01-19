package com.postman.test.pom;

import org.openqa.selenium.By;

public class CreateWorkspace extends HomeTabPage {
	
	//By elements
	private By iName = By.cssSelector("div:nth-child(2) > div.create-new-workspace__input-group__input > div > input");
	private By iSummary = By.cssSelector("div:nth-child(3) > div.create-new-workspace__input-group__input > div > input");
	private By selVisability = By.cssSelector("div:nth-child(4) > div > div > div.workspace-visibility-v2--container > "
			+ "div:nth-child(1) > div > div > div > i.Icon__IconContainer-sc-577psq-0.ckaLkN.dropdown-caret");
	private By iEnterEmailAddress = By.xpath("//div[contains(text(),'Enter an email address')]");
	private By btnAdd = By.xpath("//div[contains(text(),'Add')]");
	private By btnCancel = By.xpath("//div[contains(text(),'Cancel')]");
	private By btnCreateWorkspace = By.xpath("//div[contains(text(),'Create Workspace')]");
	
	//Methods
	/**
	 * @author Sean Trego
	 * While creating a workspace, this method enters the name.
	 * @param value
	 */
	public void enterName(String value) {
		enterText(iName, value);
	}
	
	/**
	 * @author Sean Trego
	 * While creating a workspace, this method enters the summary.
	 * @param value
	 */
	public void enterSummary(String value) {
		enterText(iSummary, value);
	}
	
	/**
	 * @author Sean Trego
	 * While creating a workspace, this method clicks the visability dropdown and selects a visability by the name value.
	 * @param value
	 */
	public void selectVisability(String value) {
		clickButton(selVisability);
		getElement(selVisability).findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
	}
	
	/**
	 * @author Sean Trego
	 * While creating a workspace, this method enters the email address.
	 * @param value
	 */
	public void enterEmailAddress(String value) {
		enterText(iEnterEmailAddress, value);
	}
	
	/**
	 * @author Sean Trego
	 * While creating a workspace, this method clicks the add button for email address.
	 */
	public void addEmailAddress() {
		clickButton(btnAdd);
	}
	
	public void clickCancelButton() {
		clickButton(btnCancel);
	}
	
	public Workspace clickCreateWorkspaceButton() {
		clickButton(btnCreateWorkspace);
		return new Workspace();
	}

}
