package com.postman.test.pom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

public class HomeTabPage extends BasePage {

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

	
	public void clickWorkspaceDropdown() {
		clickButton(workspacesTab);
	}
	
	public CreateWorkspace clickCreateNewWorkspaceFromDropdown() {
		clickButton(workspacesTab);
		clickButton(btnCreateNewWorkspaceFromDropdown);
		return new CreateWorkspace();
	}
	
	public void clickUpgradeButton() {
		clickButton(btnUpgrade);
	}
	
	public YourWorkspaces clickViewAllWorkspaces() {
		clickButton(btnViewAllWorkspaces);
		return new YourWorkspaces();
	}
	
	public Workspace selectWorkspaceByName(String name) {
		clickButton(workspacesTab);
		getElement(By.xpath("//div[@class='workspace-switcher__list__group__list-item__name'][contains(text(),'" + name + "')]")).click();
		return new Workspace();
	}
	
	public void deleteWorkspaceByName(String name) {
		clickButton(workspacesTab);
		createActions(By.xpath("//div[@class='workspace-switcher__list__group__list-item__name'][contains(text(),'" + name + "')]")).build().perform();
		getElement(By.xpath("//div[@class='workspace-switcher__list__group__list-item__name'][contains(text(),'" + name + "')]"))
			.findElement(By.xpath("following-sibling::div/div[@class='dropdown-button']")).click();
		getElement(btnWorkspacesDelete).click();
	}
	
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
	
	public void clickPopupDeleteButton() {
		clickButton(btnModalDelete);
	}
	
	public void clickAvatar() {
		clickButton(btnAvator);
	}
	
	public void clickSignOut() {
		clickButton(btnSignOut);
	}
	
	public void approveSignOut() {
		clickButton(btnApproveSignOut);
	}
	
	public Workspace selectWorkspace(String value) {
		getElement(lsWorkspaceList).findElement(By.xpath("//p[@title='" + value + "']")).click();
		return new Workspace();
	}
	
}
