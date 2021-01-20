package com.postman.test.selenium;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.postman.test.data.TestData;
import com.postman.test.pom.CreateWorkspace;
import com.postman.test.pom.LoginPage;
import com.postman.test.pom.Workspace;
import com.postman.test.pom.YourWorkspaces;
import com.postman.test.util.JsonParser;

public class SeleniumTest extends BaseTest {
	
	private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
	private final String testDataPath = "src/test/resources/TestData.json";
	
	LoginPage loginPage;
	YourWorkspaces yourWorkspaces;
	CreateWorkspace createWorkspace;
	Workspace workspace;
	TestData testData;
	SoftAssert softAssert = new SoftAssert();
	
	
	@BeforeMethod(enabled=true, alwaysRun=true)
	public void logIn() {
		LOGGER.info("Logging into Postman.");
		loginPage = new LoginPage();
		testData = (TestData) JsonParser.readData(testDataPath, TestData.class);
		LOGGER.info("Here is the test data: " + testData.toString());
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
		softAssert.assertEquals(yourWorkspaces.getYourWorkspacesPageTitle(), testData.getYourWorkspacesTitle(),
				"The Your Workspaces Title was not populated correctly.");
		createWorkspace = yourWorkspaces.clickCreateNewWorkspaceFromDropdown();
		LOGGER.info("Enter New Workspace Name: " + testData.getNewWorkspaceName());
		createWorkspace.enterName(testData.getNewWorkspaceName());
		LOGGER.info("Enter New Workspace Summary: " + testData.getNewWorkspaceSummary());
		createWorkspace.enterSummary(testData.getNewWorkspaceSummary());
		LOGGER.info("Enter New Workspace Visability: " + testData.getNewWorkspaceVisability());
		createWorkspace.selectVisability(testData.getNewWorkspaceVisability());
		LOGGER.info("Click Create Workspace.");
		createWorkspace.clickCreateWorkspaceButton();
		LOGGER.info("And I log out of the application.");
		createWorkspace.signOut();
		softAssert.assertAll();
		LOGGER.info("End of test.");
	}
	
	@Test(enabled=true, dependsOnMethods = {"testCreateNewPersonalWorkspace"}, priority=2)
	public void testReturnWorkspaceList() {
		LOGGER.info("Start of Return Workspace List Test.");
		LOGGER.info("And I review my workspace list from Workspace.");
		yourWorkspaces.clickWorkspaceDropdown();
		yourWorkspaces.getWorkspaceList().stream().forEach(System.out::println);
		softAssert.assertTrue(yourWorkspaces.verifyTextInList(yourWorkspaces.getWorkspaceList(), testData.getNewWorkspaceName()),
						"The new workspace name " + testData.getNewWorkspaceName() + " was not found in the Workspace dropdown list");
		LOGGER.info("And I click View all of my workspaces.");
		yourWorkspaces.clickViewAllWorkspaces();
		LOGGER.info("And I review my workspace list from Your Workspace.");
		yourWorkspaces.getExtWorkspaceList().stream().forEach(System.out::println);
		softAssert.assertTrue(yourWorkspaces.verifyTextInList(yourWorkspaces.getExtWorkspaceList(), testData.getNewWorkspaceName()),
						"The new workspace name " + testData.getNewWorkspaceName() + " was not found in the Your Workspace list");
		LOGGER.info("And I log out of the application.");
		yourWorkspaces.signOut();
		softAssert.assertAll();
		LOGGER.info("End of test.");
	}
	
	@Test(enabled=true, dependsOnMethods = {"testCreateNewPersonalWorkspace"}, priority=3)
	public void testUpdateWorkspace() {
		LOGGER.info("Start of Updating Workspace Test.");
		LOGGER.info("And I select my newly created workspace from the dropdown list.");
		workspace = yourWorkspaces.selectWorkspaceByName(testData.getNewWorkspaceName());
		LOGGER.info("And I enter the updated workspace name: " + testData.getUpdateWorkspaceName());
		workspace.updateWorkspaceName(testData.getUpdateWorkspaceName());
		LOGGER.info("And I enter the updated workspace summary: " + testData.getUpdateWorkspaceSummary());
		workspace.updateWorkspaceSummary(testData.getUpdateWorkspaceSummary());
		LOGGER.info("And I enter the updated workspace description: " + testData.getUpdateWorkspaceDescription());
		workspace.updateWorkspaceDescription(testData.getUpdateWorkspaceDescription());
		LOGGER.info("And I log out of the application.");
		workspace.signOut();
		LOGGER.info("End of test.");
	}
	
	@Test(enabled=true, dependsOnMethods = {"testCreateNewPersonalWorkspace"}, priority=4)
	public void testDeleteWorkspace() {
		LOGGER.info("Start of Deleting Workspace Test.");
		LOGGER.info("And I delete the workspace.");
		yourWorkspaces.deleteWorkspaceByName(testData.getUpdateWorkspaceName());
		yourWorkspaces.clickPopupDeleteButton();
		LOGGER.info("And I log out of the application.");
		yourWorkspaces.signOut();
		LOGGER.info("End of test.");
	}

}
