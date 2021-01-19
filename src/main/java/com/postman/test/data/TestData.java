package com.postman.test.data;

import javax.annotation.Nonnull;

/**
 * TestData method is the POJO class that jackson maps json data to
 * @author Sean Trego
 *
 */
public class TestData {
	
	private static final long serialVersionUID = 1L;
	
	@Nonnull
	private String newWorkspaceName;
	private String newWorkspaceSummary;
	private String newWorkspaceVisability;
	@Nonnull
	private String updateWorkspaceName;
	private String updateWorkspaceSummary;
	private String updateWorkspaceDescription;
	
	public String getNewWorkspaceName() {
		return newWorkspaceName;
	}
	public void setNewWorkspaceName(String newWorkspaceName) {
		this.newWorkspaceName = newWorkspaceName;
	}
	public String getNewWorkspaceSummary() {
		return newWorkspaceSummary;
	}
	public void setNewWorkspaceSummary(String newWorkspaceSummary) {
		this.newWorkspaceSummary = newWorkspaceSummary;
	}
	public String getNewWorkspaceVisability() {
		return newWorkspaceVisability;
	}
	public void setNewWorkspaceVisability(String newWorkspaceVisability) {
		this.newWorkspaceVisability = newWorkspaceVisability;
	}
	public String getUpdateWorkspaceName() {
		return updateWorkspaceName;
	}
	public void setUpdateWorkspaceName(String updateWorkspaceName) {
		this.updateWorkspaceName = updateWorkspaceName;
	}
	public String getUpdateWorkspaceSummary() {
		return updateWorkspaceSummary;
	}
	public void setUpdateWorkspaceSummary(String updateWorkspaceSummary) {
		this.updateWorkspaceSummary = updateWorkspaceSummary;
	}
	public String getUpdateWorkspaceDescription() {
		return updateWorkspaceDescription;
	}
	public void setUpdateWorkspaceDescription(String updateWorkspaceDescription) {
		this.updateWorkspaceDescription = updateWorkspaceDescription;
	}
	
	@Override
	public String toString() {
		return "TestData [newWorkspaceName=" + newWorkspaceName + ", newWorkspaceSummary=" + newWorkspaceSummary
				+ ", newWorkspaceVisability=" + newWorkspaceVisability + ", updateWorkspaceName=" + updateWorkspaceName
				+ ", updateWorkspaceSummary=" + updateWorkspaceSummary + ", updateWorkspaceDescription="
				+ updateWorkspaceDescription + "]";
	}
}
