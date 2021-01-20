package com.postman.test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Workspace extends HomeTabPage {
	
	//By elements
	private By btnEditWorkspaceName = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-header > header > div > i");
	private By iEditWorkspaceName = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-header > header > div");
	private By btnEditWorkspaceSummary = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-summary > div > i");
	private By iEditWorkspaceSummary = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-summary > div > div");
	private By btnEditWorkspaceDescription = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-description > div > i");
	private By iEditWorkspaceDescription = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-description > div > div > div > div.inline-editor__text-editor-body.text-editor-wrapper > div > div > div > div.overflow-guard > div.monaco-scrollable-element.editor-scrollable.vs > div.lines-content.monaco-editor-background > div.view-lines");
	private By btnEditWorkspaceDescriptionSave = By.xpath("//div[@class='btn btn-primary btn-small inline-editor__update-button']");
	private By btnCreateARequest = By.xpath("//div[@class='ws-getstarted']/div[@class='create-new-entity-section']/div[@class='create-new-entity']/i");

	
	//Methods
	/**
	 * @author Sean Trego
	 * Method is used to update the workspace name with a value.
	 * @param value
	 */
	public void updateWorkspaceName(String value) {
		switch(System.getProperty("browser")) {
			case "chrome":
				createActions(btnEditWorkspaceName).click().build().perform();
				createActions(iEditWorkspaceName)
					.clickAndHold()
					.sendKeys(Keys.BACK_SPACE)
					.sendKeys(value)
					.sendKeys(Keys.RETURN)
					.build()
					.perform();
				break;
			case "firefox":
				createActions(btnEditWorkspaceName).click().build().perform();
				createActions(iEditWorkspaceName)
					.sendKeys(Keys.DELETE)
					.sendKeys(value)
					.sendKeys(Keys.RETURN)
					.build()
					.perform();
				break;
			default:
				System.out.println("No element setup for this browser: " + System.getProperty("browser"));
		}

	}
	
	/**
	 * @author Sean Trego
	 * Method is used to update the workspace summary with a value.
	 * @param value
	 */
	public void updateWorkspaceSummary(String value) {
		switch(System.getProperty("browser")) {
		case "chrome":
			createActions(btnEditWorkspaceSummary).click().build().perform();
			createActions(iEditWorkspaceSummary)
				.clickAndHold()
				.sendKeys(Keys.BACK_SPACE)
				.sendKeys(value)
				.sendKeys(Keys.RETURN)
				.build()
				.perform();
			break;
		case "firefox":
			createActions(btnEditWorkspaceSummary).click().build().perform();
			createActions(iEditWorkspaceSummary)
				.sendKeys(Keys.DELETE)
				.sendKeys(value)
				.sendKeys(Keys.RETURN)
				.build()
				.perform();
			break;
		default:
			System.out.println("No element setup for this browser: " + System.getProperty("browser"));
		}

	}
	
	/**
	 * @author Sean Trego
	 * Method is used to update the workspace description with a value.
	 * @param value
	 */
	public void updateWorkspaceDescription(String value) {
		switch(System.getProperty("browser")) {
		case "chrome":
			createActions(btnEditWorkspaceDescription).click().build().perform();
			createActions(iEditWorkspaceDescription)
				.clickAndHold()
				.sendKeys(Keys.BACK_SPACE)
				.sendKeys(value)
				.build()
				.perform();
			createActions(btnEditWorkspaceDescriptionSave).click().build().perform();
			break;
		case "firefox":
			createActions(btnEditWorkspaceDescription).click().build().perform();
			createActions(iEditWorkspaceDescription)
				.clickAndHold()
				.sendKeys(Keys.DELETE)
				.sendKeys(value)
				.sendKeys(Keys.RETURN)
				.build()
				.perform();
			clickButton(btnEditWorkspaceDescriptionSave);
			break;
		default:
			System.out.println("No element setup for this browser: " + System.getProperty("browser"));
		}

	}
	
	/**
	 * @author Sean Trego
	 * Method is used to find the Create a request button and return the text
	 * @return String
	 */
	public String getCreateARequestText() {
		hold(3);
		return getText(btnCreateARequest);
	}
	

}
