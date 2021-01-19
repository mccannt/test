package com.postman.test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Workspace extends HomeTabPage {
	
	private By btnEditWorkspaceName = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-header > header > div > i");
	private By iEditWorkspaceName = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-header > header > div");
	private By btnEditWorkspaceSummary = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-summary > div > i");
	private By iEditWorkspaceSummary = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-summary > div > div");
	private By btnEditWorkspaceDescription = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-description > div > i");
	private By iEditWorkspaceDescription = By.cssSelector("body > div.app-root > div > div > div.pane-group.vertical > div:nth-child(1) > div.pane.resizableX.resizableY.requester-contents-pane > div > div > div > div:nth-child(2) > div > div > div > div.requester-tab-contents > div > div > div > div.ws-content-area > div > div.ws-meta > div > div.ws-meta-description > div > div > div > div.inline-editor__text-editor-body.text-editor-wrapper > div > div > div > div.overflow-guard > div.monaco-scrollable-element.editor-scrollable.vs > div.lines-content.monaco-editor-background > div.view-lines");
	private By btnEditWorkspaceDescriptionSave = By.xpath("//div[@class='btn btn-primary btn-small inline-editor__update-button']");
	
	public void updateWorkspaceName(String value) {
		createActions(btnEditWorkspaceName).click().build().perform();
		createActions(iEditWorkspaceName)
			.clickAndHold()
			.sendKeys(Keys.BACK_SPACE)
			.sendKeys(value)
			.sendKeys(Keys.RETURN)
			.build()
			.perform();
	}
	
	public void updateWorkspaceSummary(String value) {
		createActions(btnEditWorkspaceSummary).click().build().perform();
		createActions(iEditWorkspaceSummary)
			.clickAndHold()
			.sendKeys(Keys.BACK_SPACE)
			.sendKeys(value)
			.sendKeys(Keys.RETURN)
			.build()
			.perform();
	}
	
	public void updateWorkspaceDescription(String value) {
		createActions(btnEditWorkspaceDescription).click().build().perform();
		createActions(iEditWorkspaceDescription)
			.clickAndHold()
			.sendKeys(Keys.BACK_SPACE)
			.sendKeys(value)
			.build()
			.perform();
		createActions(btnEditWorkspaceDescriptionSave).click().build().perform();
	}
	

}
