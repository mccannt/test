package com.postman.test.pom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

public class YourWorkspaces extends HomeTabPage {

	private By lsWorkspaces = By.cssSelector("body > div.app-root > div > div > main > div > ol");
	private By btnNewWorkspace = By.xpath("//a/div[contains(text(),'New workspace')]");
	
	public CreateWorkspace clickNewWorkspace() {
		clickButton(btnNewWorkspace);
		return new CreateWorkspace();
	}
	
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
	
}
