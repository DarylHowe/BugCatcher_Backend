package com.darylhowedevs.bugcatch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darylhowedevs.bugcatch.bug.Bug;
import com.darylhowedevs.bugcatch.bug.BugProgressReport;
import com.darylhowedevs.bugcatch.bug.bugqueue.BugPriorityQueue;
import com.darylhowedevs.bugcatch.repository.ProjectRepository;
import com.darylhowedevs.bugcatch.service.BugService;
import com.darylhowedevs.bugcatch.staff.Employee;

@RestController
@RequestMapping("/bug/{projectID}")
@CrossOrigin("*")
public class BugController {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private BugService bugService;

	// http://localhost:8080/bug/testAPI/fill/testapi
	@GetMapping("/testapi")
	public String testAPI() {
		return "Hello, World";
	}

	// Handle so if a bug or project is not found...
	// http://localhost:8080/bug/{projectID}/{bugID}
	@GetMapping("/{bugID}")
	public Bug getBugByID(@PathVariable String projectID, @PathVariable String bugID) {

		return bugService.getBugByID(projectID, bugID);
	}

	// Handle
	// http://localhost:8080/bug/{projectID}/createnewbug/{title}/{description}/{priority}
	@PostMapping("/createnewbug/{title}/{description}/{priority}")
	public BugPriorityQueue createNewBug(@PathVariable String projectID, @PathVariable String title,
			@PathVariable String description, @PathVariable String priority) {
		return bugService.createNewBug(projectID, title, description, priority);
	}

	// http://localhost:8080/bug/{projectID}/createnewbug
	@PostMapping("/createnewbug")
	public Bug createNewBug(@PathVariable String projectID, @RequestBody Bug newBug) {
		return bugService.createNewBug(projectID, newBug);
	}

	// Hangle so that is 'solved' 'unsolved' or 'inprogress' in not included..
	// http://localhost:8080/bug/{projectID}/{bugID}/setstatus/{status}
	@PutMapping("/{bugID}/setstatus/{status}")
	public Bug setBugStatus(@PathVariable String projectID, @PathVariable String bugID, @PathVariable String status) {
		return bugService.setBugStatus(projectID, bugID, status);
	}
	
	// http://localhost:8080/bug/{projectID}/{bugID}/setpriority/{priority}
	@PutMapping("/{bugID}/setpriority/{priority}")
	public Bug setBugPriority(@PathVariable String projectID, @PathVariable String bugID, @PathVariable String priority) {
		return bugService.setBugPriority(projectID, bugID, priority);
	}

	// http://localhost:8080/bug/{projectID}/updatebug/
	@PutMapping("/updatebug")
	public Bug updateBugDetails(@PathVariable String projectID, @RequestBody Bug updatedBug) {
		return bugService.updateBugDetails(projectID, updatedBug);
	}

	// http://localhost:8080/bug/{projectID}/all
	@GetMapping("/all")
	public BugPriorityQueue getAllBugs(@PathVariable String projectID) {
		return bugService.getAllBugs(projectID);
	}

	// http://localhost:8080/bug/{projectID}/getbystatus/{status}
	@GetMapping("/getbystatus/{status}")
	public List<Bug> getByStatus(@PathVariable String projectID, @PathVariable String status) {
		return bugService.getByStatus(projectID, status);
	}

	// http://localhost:8080/bug/{projectID}/getbypriority/{priority}
	@GetMapping("/getbypriority/{priority}")
	public List<Bug> getByPriority(@PathVariable String projectID, @PathVariable String priority) {
		return bugService.getByPriority(projectID, priority);
	}
	
	
	// http://localhost:8080/bug/{projectID}/{bugID}/assigntoemployee
	@PostMapping("/{bugID}/assigntoemployee")
	public List<Employee> assignBugToEmployee(@PathVariable String projectID, @PathVariable String bugID,
			@RequestBody Employee employee) {
		return bugService.assignBugToEmployee(projectID, bugID, employee);
	}
	
	// http://localhost:8080/bug/{projectID}/{bugID}/createprogressreport
	@PostMapping("/{bugID}/createprogressreport")
	public List<BugProgressReport> createProgressReport(@PathVariable String projectID, @PathVariable String bugID,
			@RequestBody BugProgressReport progressReport) {
		return bugService.createProgressReport(projectID, bugID, progressReport);
	}
	

}
