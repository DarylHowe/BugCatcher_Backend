package com.darylhowedevs.bugcatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.darylhowedevs.bugcatch.bug.Bug;
import com.darylhowedevs.bugcatch.bug.BugProgressReport;
import com.darylhowedevs.bugcatch.bug.bugqueue.PriorityQueueElement;
import com.darylhowedevs.bugcatch.project.Project;
import com.darylhowedevs.bugcatch.repository.ProjectRepository;
import com.darylhowedevs.bugcatch.staff.Employee;

@Component
public class DBSeeder implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void run(String... args) throws Exception {
		projectRepository.deleteAll();
		seedProjects();
	}

	private void seedProjects() {
		project01();
		project02();
		project03();
	}
	
	private void project01() {
		Project project = new Project("YouTube", "An online platform to stream video content");
		Employee e1 = new Employee("Daryl", "Howe");
		Employee e2 = new Employee("John", "Snow");

		project.getEmployeeList().addEmployee(e1);
		project.getEmployeeList().addEmployee(e2);

		Bug b1 = new Bug("Video glitching", "All videos are glitching at 4m 48s into playing.");
		PriorityQueueElement pqe1 = new PriorityQueueElement("Highest", b1);

		project.getBugQueue().enqueue(pqe1);
		
		BugProgressReport report = new BugProgressReport("Attempted to fix bug - unable. Will try again next week.", e1);
		project.getBugQueue().findBugByID("0").getBugProgressReportList().addNewBugReport(report);

		projectRepository.save(project);
	}
	
	public void project02() {
		Project project = new Project("Amazon", "An online ECommerce store.");
		Employee e1 = new Employee("Alex", "Wands");
		Employee e2 = new Employee("Alice", "Black");

		project.getEmployeeList().addEmployee(e1);
		project.getEmployeeList().addEmployee(e2);

		Bug b1 = new Bug("Order processing failed.", "Orders are not being processed after 9.32pm.");
		PriorityQueueElement pqe1 = new PriorityQueueElement("Highest", b1);

		project.getBugQueue().enqueue(pqe1);

		projectRepository.save(project);
	}
	
	public void project03() {
		Project project = new Project("Xhail", "An online music production platorm for composers.");
		Employee e1 = new Employee("Eric", "Gorma");
		Employee e2 = new Employee("Sandy", "Luc");

		project.getEmployeeList().addEmployee(e1);
		project.getEmployeeList().addEmployee(e2);

		Bug b1 = new Bug("Audio not playing.", "Audio stops playing every page rest.");
		PriorityQueueElement pqe1 = new PriorityQueueElement("Highest", b1);

		project.getBugQueue().enqueue(pqe1);

		projectRepository.save(project);
	}

}
