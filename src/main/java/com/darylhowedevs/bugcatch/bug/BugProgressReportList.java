package com.darylhowedevs.bugcatch.bug;

import java.util.ArrayList;
import java.util.List;

public class BugProgressReportList {

	private List<BugProgressReport> reportsList;

	public BugProgressReportList() {
		reportsList = new ArrayList();
	}

	public BugProgressReport getReportByID(String reportID) {
		BugProgressReport report = null;

		for (int i = 0; i < reportsList.size(); i++) {
			if (reportsList.get(i).getProgressReportID().equalsIgnoreCase(reportID)) {
				report = reportsList.get(i);
				break;
			}
		}
		return report;
	}

	public String removeReportByID(String reportID) {

		String message = "A report with the ID " + reportID + " could not be found and therefore not deleted.";

		for (int i = 0; i < reportsList.size(); i++) {
			if (reportsList.get(i).getProgressReportID().equalsIgnoreCase(reportID)) {
				reportsList.remove(i);
				message = "A report with the ID " + reportID + " was deleted.";
				break;
			}
		}
		return message;
	}

	public void addNewBugReport(BugProgressReport bugProgressReport) {
		reportsList.add(bugProgressReport);
	}

	public List<BugProgressReport> getReportsList() {
		return reportsList;
	}

	public void setReportsList(List<BugProgressReport> reportsList) {
		this.reportsList = reportsList;
	}

}
