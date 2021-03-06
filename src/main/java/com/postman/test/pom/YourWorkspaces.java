package com.postman.test.pom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

public class YourWorkspaces extends HomeTabPage {

	//By elements
	private By lsWorkspaces = By.cssSelector("body > div.app-root > div > div > main > div > ol");
	private By btnNewWorkspace = By.xpath("//a/div[contains(text(),'New workspace')]");
	private By yourWorkspacesTitle = By.xpath("//div/h2[@class='workspaces-page-container-header-title']");
	
	//Methods
	/**
	 * @author Sean Trego
	 * Method is used to click the create new workspace button
	 * @return CreateWorkspace instance.
	 */
	public CreateWorkspace clickNewWorkspace() {
		clickButton(btnNewWorkspace);
		return new CreateWorkspace();
	}
	
	/**
	 * @author Sean Trego
	 * Method is used to return the list of workspaces on the yourworkspaces page.
	 * @return list of workspaces
	 */
	public List<String> getExtWorkspaceList(){	
		return Arrays.asList(getElement(lsWorkspaces)
				.getText()
				.split("\n"))
				.stream()
				.filter(x -> !x.equals("Recently Visited"))
				.filter(x -> !x.equals("More Workspaces"))
				.filter(x -> !x.equals("This is your personal, private workspace to play around in. "
						+ "Only you can see the collections and APIs you create here - unless you share them with your team."))
				.collect(Collectors.toList());
	}
	
	/**
	 * @author Sean Trego
	 * Method finds the Your Workspaces title and returns the string
	 * @return
	 */
	public String getYourWorkspacesPageTitle() {
		return getText(yourWorkspacesTitle);
	}
	
}
