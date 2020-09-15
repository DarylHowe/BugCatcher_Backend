package com.darylhowedevs.bugcatch.bug;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class Bug {

	@Id
	private String bugID;
	private static int bugIDStatic = -1;
	private String dateCreated;
	private String dateResolved;
	private String title;
	private String bugDescription;
	private String status;
	private String discoveredBy;
	private String solutionDescription;
	private BugProgressReportList bugProgressReportList;
	private BugAssignedToList bugAssignedToList;
	private String priority;
	
	public Bug() {
		bugIDStatic++;
		bugID = Integer.toString(bugIDStatic);
		dateCreated = new Date().toString();
		bugProgressReportList = new BugProgressReportList();
		bugAssignedToList = new BugAssignedToList();
		status = "Unsolved";
	}

	public Bug(String title, String bugDescription) {
		this();
		this.title = title;
		this.bugDescription = bugDescription;
	}

	public String getBugID() {
		return bugID;
	}
	
	public void setBugID(String bugID) {
		this.bugID = bugID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatusInProgress() {
		this.status = "InProgress";
		this.dateResolved = "Not yet solved.";
	}
	
	public void setStatusSolved() {
		this.status = "Solved";
		this.dateResolved = new Date().toString();
	}
	
	public void setStatusUnsolved() {
		this.status = "Unsolved";
		this.dateResolved = "Unresolved.";
	}

	public String getDiscoveredBy() {
		return discoveredBy;
	}

	public void setDiscoveredBy(String discoveredBy) {
		this.discoveredBy = discoveredBy;
	}

	public String getSolutionDescription() {
		return solutionDescription;
	}

	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}

	public BugProgressReportList getBugProgressReportList() {
		return bugProgressReportList;
	}

	public void setBugProgressReportList(BugProgressReportList bugProgressReportList) {
		this.bugProgressReportList = bugProgressReportList;
	}

	public BugAssignedToList getBugAssignedToList() {
		return bugAssignedToList;
	}

	public void setBugAssignedToList(BugAssignedToList bugAssignedToList) {
		this.bugAssignedToList = bugAssignedToList;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	 
	
	

}
