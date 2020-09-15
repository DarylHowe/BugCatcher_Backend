package com.darylhowedevs.bugcatch.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darylhowedevs.bugcatch.project.Project;
import com.darylhowedevs.bugcatch.repository.ProjectRepository;
import com.darylhowedevs.bugcatch.service.ProjectService;
import com.darylhowedevs.bugcatch.staff.Employee;
import com.darylhowedevs.bugcatch.staff.EmployeeList;

@CrossOrigin("*")
@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectService projectService;

	// http://localhost:8080/project/testAPI
	@GetMapping("/testAPI")
	public String testAPI() {
		return "Hello, World";
	}
	
	// http://localhost:8080/project/createnewproject/{title}/{description}
	@PostMapping("/createnewproject/{title}/{description}")
	public Project createNewProject(@PathVariable String title, @PathVariable String description) {
		return projectService.createNewProject(title, description);
	}
	
	// Handle if project ID is not found. 
	// Double ask on frontend if they really want to delete. 
	// http://localhost:8080/project/deleteproject/{projectID}
	@DeleteMapping("/deleteproject/{projectID}")
	public List<Project> deleteProjectByID(@PathVariable String projectID) {
		projectRepository.deleteById(projectID);
		return projectRepository.findAll();
	}
	

	// http://localhost:8080/project/allprojects
	@GetMapping("/allprojects")
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	// http://localhost:8080/project/{projectID}
	@GetMapping("/{projectID}")
	public Optional<Project> getProjectById(@PathVariable String projectID) {
		return projectRepository.findById(projectID);
	}

	// http://localhost:8080/project/{projectID}/updatetitle/{title}
	@PutMapping("/{projectID}/updatetitle/{title}")
	public Project updateTitle(@PathVariable String projectID, @PathVariable String title) {
		return projectService.updateTitle(projectID, title);
	}
	
	// On front end make sure to convert description to avoid '/' etc
	// http://localhost:8080/project/{projectID}/updatedescription/{description}
	@PutMapping("/{projectID}/updatedescription/{description}")
	public Project updateDescription(@PathVariable String projectID, @PathVariable String description) {
		return projectService.updateDescription(projectID, description);
	}
	
	// http://localhost:8080/project/{projectID}/addemployee
	@PostMapping("/{projectID}/addemployee")
	public EmployeeList addEmployeeToProject(@PathVariable String projectID, @RequestBody Employee employee) {
		return projectService.addEmployeeToProject(projectID, employee);
	}

}
