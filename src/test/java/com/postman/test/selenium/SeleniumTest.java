package com.postman.test.selenium;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.postman.test.pom.CreateWorkspace;
import com.postman.test.pom.LoginPage;
import com.postman.test.pom.Workspace;
import com.postman.test.pom.YourWorkspaces;

public class SeleniumTest extends BaseTest {
	
	private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
	private final String newWorkspaceName = "Sean New Workspace";
	private final String newWorkspaceSummary = "Sean New Workspace Summary";
	private final String newWorkspaceVisability = "Personal";
	private final String updateWorkspaceName = "Sean Updated Workspace";
	private final String updateWorkspaceSummary = "Sean Updated Summary";
	private final String updateWorkspaceDescription = "Sean Updated Description";
	
	LoginPage loginPage;
	YourWorkspaces yourWorkspaces;
	CreateWorkspace createWorkspace;
	Workspace workspace;
	
	
	@BeforeMethod(enabled=true, alwaysRun=true)
	public void logIn() {
		LOGGER.info("Logging into Postman.");
		loginPage = new LoginPage();
		LOGGER.info("Entering email or username.");
		loginPage.enterEmailOrUsername();
		LOGGER.info("Entering password.");
		loginPage.enterPassword();
		LOGGER.info("Click sign in.");
		yourWorkspaces = loginPage.clickSignIn();
	}
	
	@Test(enabled=true, priority=1)
	public void testCreateNewPersonalWorkspace() {		
		LOGGER.info("Start of Creating New Personal Workspace Test.");
		LOGGER.info("Click Creating New Personal Workspace");
		createWorkspace = yourWorkspaces.clickCreateNewWorkspaceFromDropdown();
		LOGGER.info("Enter New Workspace Name: " + newWorkspaceName);
		createWorkspace.enterName(newWorkspaceName);
		LOGGER.info("Enter New Workspace Summary: " + newWorkspaceSummary);
		createWorkspace.enterSummary(newWorkspaceSummary);
		LOGGER.info("Enter New Workspace Visability: " + newWorkspaceVisability);
		createWorkspace.selectVisability(newWorkspaceVisability);
		LOGGER.info("Click Create Workspace.");
		createWorkspace.clickCreateWorkspaceButton();
		LOGGER.info("And I log out of the application.");
		createWorkspace.clickAvatar();
		createWorkspace.clickSignOut();
		createWorkspace.approveSignOut();
		LOGGER.info("End of test.");
	}
	
	@Test(enabled=true, dependsOnMethods = {"testCreateNewPersonalWorkspace"})
	public void testReturnWorkspaceList() {
		LOGGER.info("Start of Return Workspace List Test.");
		LOGGER.info("And I review my workspace list from Workspace.");
		yourWorkspaces.clickWorkspaceDropdown();
		yourWorkspaces.getWorkspaceList().stream().forEach(System.out::println);
		LOGGER.info("And I click View all of my workspaces.");
		yourWorkspaces.clickViewAllWorkspaces();
		LOGGER.info("And I review my workspace list from Your Workspace.");
		yourWorkspaces.getExtWorkspaceList().stream().forEach(System.out::println);
		LOGGER.info("And I log out of the application.");
		yourWorkspaces.clickAvatar();
		yourWorkspaces.clickSignOut();
		yourWorkspaces.approveSignOut();
		LOGGER.info("End of test.");
	}
	
	@Test(enabled=true, dependsOnMethods = {"testReturnWorkspaceList"})
	public void testUpdateWorkspace() {
		LOGGER.info("Start of Updating Workspace Test.");
		LOGGER.info("And I select my newly created workspace from the dropdown list.");
		workspace = yourWorkspaces.selectWorkspaceByName(newWorkspaceName);
		LOGGER.info("And I enter the updated workspace name: " + updateWorkspaceName);
		workspace.updateWorkspaceName(updateWorkspaceName);
		LOGGER.info("And I enter the updated workspace summary: " + updateWorkspaceSummary);
		workspace.updateWorkspaceSummary(updateWorkspaceSummary);
		LOGGER.info("And I enter the updated workspace description: " + updateWorkspaceDescription);
		workspace.updateWorkspaceDescription(updateWorkspaceDescription);
		LOGGER.info("And I log out of the application.");
		workspace.clickAvatar();
		workspace.clickSignOut();
		createWorkspace.approveSignOut();
		LOGGER.info("End of test.");
	}
	
	@Test(enabled=true, dependsOnMethods = {"testUpdateWorkspace"})
	public void testDeleteWorkspace() {
		LOGGER.info("Start of Deleting Workspace Test.");
		LOGGER.info("And I delete the workspace.");
		yourWorkspaces.deleteWorkspaceByName(updateWorkspaceName);
		yourWorkspaces.clickPopupDeleteButton();
		LOGGER.info("And I log out of the application.");
		yourWorkspaces.clickAvatar();
		yourWorkspaces.clickSignOut();
		yourWorkspaces.approveSignOut();
		LOGGER.info("End of test.");
	}

}
