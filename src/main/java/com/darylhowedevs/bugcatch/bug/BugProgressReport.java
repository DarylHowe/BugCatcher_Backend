package com.darylhowedevs.bugcatch.bug;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.darylhowedevs.bugcatch.staff.Employee;

public class BugProgressReport {

	@Id
	private String progressReportID;
	private static int progressReportIDStatic = -1;
	private String dateCreated;
	private String reportDescription;
	private Employee reportAuthor;

	public BugProgressReport(String reportDescription, Employee reportAuthor) {
		progressReportIDStatic++;
		this.progressReportID = Integer.toString(progressReportIDStatic);
		this.reportDescription = reportDescription;
		this.reportAuthor = reportAuthor;
		dateCreated = new Date().toString();
	}

	public String getProgressReportID() {
		return progressReportID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public Employee getReportAuthor() {
		return reportAuthor;
	}

	public void setReportAuthor(Employee reportAuthor) {
		this.reportAuthor = reportAuthor;
	}

}
