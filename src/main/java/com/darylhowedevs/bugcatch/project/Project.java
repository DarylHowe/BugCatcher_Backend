package com.darylhowedevs.bugcatch.project;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.darylhowedevs.bugcatch.bug.bugqueue.BugPriorityQueue;
import com.darylhowedevs.bugcatch.staff.EmployeeList;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document (collection = "Projects")
public class Project {

	@Id
	private String projectID;
	private static int projectIDStatic;
	private String title;
	private String description;
	private String dateCreated;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private BugPriorityQueue bugQueue;
	private EmployeeList employeeList;

	public Project() {
	}

	public Project(String title, String description) {
		this.title = title;
		this.description = description;
		dateCreated = new Date().toString();
		projectID = Integer.toString(projectIDStatic++);
		bugQueue = new BugPriorityQueue();
		employeeList = new EmployeeList();
		timestamp = LocalDateTime.now();

	}

	public String getProjectID() {
		return projectID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public BugPriorityQueue getBugQueue() {
		return bugQueue;
	}

	public void setBugQueue(BugPriorityQueue bugQueue) {
		this.bugQueue = bugQueue;
	}

	public EmployeeList getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(EmployeeList employeeList) {
		this.employeeList = employeeList;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
