package com.postman.test.pom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

public class HomeTabPage extends BasePage {

	//By elements
	private By homeTab = By.xpath("//a/div[contains(text(),'Home')]");
	private By workspacesTab = By.xpath("//div/div[@class='workspace-switcher__name']");
	private By reportsTab = By.xpath("//a/div[contains(text(),'Reports')]");
	private By exploreTab = By.xpath("//a/div[contains(text(),'Explore')]");
	private By iSearchPostman = By.xpath("//div/div[contains(text(),'Search Postman')]");
	private By btnSettings = By.xpath("//i[@class='Icon__IconContainer-sc-577psq-0 kmcxQX settings-button-icon']");
	private By btnUpgrade = By.cssSelector("body > div.app-root > div > div > div.requester-header > "
			+ "div.requester-header__section-right > div.team-info-dropdown-upgrade > "
			+ "div > div > div > div.btn.btn-secondary.team-button.requester-header__team-info__button");
	private By btnCreateNewWorkspaceFromDropdown = By.xpath("//div[@class='btn btn-tertiary workspace-switcher__action workspace-switcher__action--create']");
	private By btnViewAllWorkspaces = By.xpath("//div[@class='workspace-switcher__footer']");
	private By lsWorkspaces = By.xpath("//div[@class='workspace-switcher__list__group__list']");
	private By btnWorkspacesDelete = By.xpath("//div[@class='dropdown-menu-item dropdown-menu-item--delete']");
	private By btnModalDelete = By.xpath("//div[@class='btn btn-primary is-focused delete-confirmation-modal-delete-button']");
	private By btnAvator = By.cssSelector("body > div.app-root > div > div > div.requester-header > div.requester-header__section-right > div.requester-header__user-info > div > div > div > div > div > span");
	private By btnSignOut = By.cssSelector("#dropdown-root > div > div > div.dropdown-menu-item.dropdown-menu-item--logout > div");
	private By btnApproveSignOut = By.xpath("//div[@class='modal user-signout-modal']/div[3]/div[2]");
	private By lsWorkspaceList = By.cssSelector("body > div.app-root > div > div > div.requester-header > div.requester-header__section-left > div > div > div.workspace-switcher__selector > div.workspace-switcher__list");

	//Methods
	/**
	 * @author Sean Trego
	 * This method clicks the workspace dropdown in the tab area.
	 */
	public void clickWorkspaceDropdown() {
		clickButton(workspacesTab);
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the workspaces tab dropdown and clicks create new workspace button.
	 * @return CreateWorkspace instance
	 */
	public CreateWorkspace clickCreateNewWorkspaceFromDropdown() {
		clickButton(workspacesTab);
		clickButton(btnCreateNewWorkspaceFromDropdown);
		return new CreateWorkspace();
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the upgrade button in the tab area.
	 */
	public void clickUpgradeButton() {
		clickButton(btnUpgrade);
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks view all workspaces button on the workspaces tab.
	 * @return YourWorkspaces instance
	 */
	public YourWorkspaces clickViewAllWorkspaces() {
		clickButton(btnViewAllWorkspaces);
		return new YourWorkspaces();
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the workspaces tab, then selects the specific workspace by name.
	 * @param name
	 * @return Workspace instance
	 */
	public Workspace selectWorkspaceByName(String name) {
		clickButton(workspacesTab);
		getElement(By.xpath("//div[@class='workspace-switcher__list__group__list-item__name'][contains(text(),'" + name + "')]")).click();
		return new Workspace();
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the workspaces tab, then selects the elipses by the workspace you want to delete by name.
	 * @param name
	 */
	public void deleteWorkspaceByName(String name) {
		clickButton(workspacesTab);
		createActions(By.xpath("//div[@class='workspace-switcher__list__group__list-item__name'][contains(text(),'" + name + "')]")).build().perform();
		getElement(By.xpath("//div[@class='workspace-switcher__list__group__list-item__name'][contains(text(),'" + name + "')]"))
			.findElement(By.xpath("following-sibling::div/div[@class='dropdown-button']")).click();
		getElement(btnWorkspacesDelete).click();
	}
	
	/**
	 * @author Sean Trego
	 * This method will return the list of all the workspaces on the workspace tab and will filter out any unwanted text.
	 * @return list of strings of workspaces
	 */
	public List<String> getWorkspaceList(){
		hold(3);
		return Arrays.asList(getElement(lsWorkspaceList)
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
	 * This method clicks the pop up delete button.
	 */
	public void clickPopupDeleteButton() {
		clickButton(btnModalDelete);
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the avatar in the tab area.
	 */
	public void clickAvatar() {
		clickButton(btnAvator);
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the sign out button on the avatar dropdown.
	 */
	public void clickSignOut() {
		clickButton(btnSignOut);
	}
	
	/**
	 * @author Sean Trego
	 * This method clicks the are you sure you want to sign out button on the pop up.
	 */
	public void approveSignOut() {
		clickButton(btnApproveSignOut);
	}
	
	/**
	 * @author Sean Trego
	 * This method strings together the signout methods for the app.
	 */
	public void signOut() {
		clickButton(btnAvator);
		clickButton(btnSignOut);
		clickButton(btnApproveSignOut);
	}
	
	/**
	 * @author Sean Trego
	 * This method allows to pick a specific workspace by name in the workspace dropdown.
	 * @param value
	 * @return Workspace instance.
	 */
	public Workspace selectWorkspace(String value) {
		getElement(lsWorkspaceList).findElement(By.xpath("//p[@title='" + value + "']")).click();
		return new Workspace();
	}
	
}
