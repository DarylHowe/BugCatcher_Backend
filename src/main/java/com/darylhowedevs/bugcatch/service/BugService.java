package com.darylhowedevs.bugcatch.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.darylhowedevs.bugcatch.bug.Bug;
import com.darylhowedevs.bugcatch.bug.BugAssignedToList;
import com.darylhowedevs.bugcatch.bug.BugProgressReport;
import com.darylhowedevs.bugcatch.bug.BugProgressReportList;
import com.darylhowedevs.bugcatch.bug.bugqueue.BugPriorityQueue;
import com.darylhowedevs.bugcatch.bug.bugqueue.PriorityQueueElement;
import com.darylhowedevs.bugcatch.project.Project;
import com.darylhowedevs.bugcatch.staff.Employee;
import com.darylhowedevs.bugcatch.staff.EmployeeList;


@Service
public class BugService {

	private final MongoTemplate mongoTemplate;

	public BugService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	private Project getProjectByID(String projectID) {
		return mongoTemplate.findById(projectID, Project.class);
	}

	public Bug getBugByID(String projectID, String bugID) {
		Project project = getProjectByID(projectID);
		return project.getBugQueue().findBugByID(bugID);
	}
	
	public BugPriorityQueue createNewBug(String projectID, String title, String description, String priority) {
		Project project = getProjectByID(projectID);
		Bug bug = new Bug(title, description);
		PriorityQueueElement element = new PriorityQueueElement(priority, bug);
		project.getBugQueue().enqueue(element);
		mongoTemplate.save(project);
		return project.getBugQueue();
	}
	
	public Bug createNewBug(String projectID, Bug newBug) {
		Project project = getProjectByID(projectID);
		Bug bug = new Bug();
		newBug.setBugID(bug.getBugID());
		newBug.setDateCreated(bug.getDateCreated());
		newBug.setStatusUnsolved();
		newBug.setBugAssignedToList(bug.getBugAssignedToList());
		newBug.setBugProgressReportList(bug.getBugProgressReportList());

		project.getBugQueue().updateBugByID(newBug.getBugID(), newBug);
		PriorityQueueElement pqElement = new PriorityQueueElement(newBug.getPriority(), newBug);
		project.getBugQueue().enqueue(pqElement);
		mongoTemplate.save(project);
		return newBug;
	}
	
	public Bug setBugStatus(String projectID, String bugID, String status) {
		Project project = getProjectByID(projectID);
		Bug bug = project.getBugQueue().findBugByID(bugID);
		
		if (status.equalsIgnoreCase("solved")) {
			bug.setStatusSolved();
			
		} else if (status.equalsIgnoreCase("inprogress")) {
			bug.setStatusInProgress();
			
		} else if (status.equalsIgnoreCase("unsolved")) {
			bug.setStatusUnsolved();
		}

		mongoTemplate.save(project);
		return bug;
	}
	
	public Bug updateBugDetails(String projectID, Bug updatedBug) {
		Project project = getProjectByID(projectID);
		project.getBugQueue().updateBugByID(updatedBug.getBugID(), updatedBug);
		mongoTemplate.save(project);
		return updatedBug;
	}
	
	public BugPriorityQueue getAllBugs(String projectID){
		Project project = getProjectByID(projectID);
		return project.getBugQueue();
	}
	
	public List<Bug>getByStatus(String projectID, String status){
		Project project = getProjectByID(projectID);
		return project.getBugQueue().getBugsByStatus(status);
	}
	
	public List<Bug>getByPriority(String projectID, String priority){
		Project project = getProjectByID(projectID);
		return project.getBugQueue().getElementsWithPriority(priority);
	}
	
	public Bug setBugPriority(String projectID, String bugID, String priority) {
		Project project = getProjectByID(projectID);
		project.getBugQueue().updateBugPriority(bugID, priority);
		mongoTemplate.save(project);
		return project.getBugQueue().findBugByID(bugID);
	}
	
	
	public List<Employee> assignBugToEmployee(String projectID, String bugID, Employee employee) {
		Project project = getProjectByID(projectID);
		project.getBugQueue().findBugByID(bugID).getBugAssignedToList().addNewEmployee(employee);
		mongoTemplate.save(project);
		return project.getBugQueue().findBugByID(bugID).getBugAssignedToList().getEmployeeList();
	}
	
	public List<BugProgressReport> createProgressReport(String projectID, String bugID, BugProgressReport progressReport) {
		Project project = getProjectByID(projectID);
		BugProgressReport report = new BugProgressReport(progressReport.getReportDescription(), progressReport.getReportAuthor());
		project.getBugQueue().findBugByID(bugID).getBugProgressReportList().addNewBugReport(report);
		mongoTemplate.save(project);
		return project.getBugQueue().findBugByID(bugID).getBugProgressReportList().getReportsList();
	}

}
