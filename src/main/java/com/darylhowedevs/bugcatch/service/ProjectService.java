package com.darylhowedevs.bugcatch.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.darylhowedevs.bugcatch.project.Project;
import com.darylhowedevs.bugcatch.staff.Employee;
import com.darylhowedevs.bugcatch.staff.EmployeeList;

@Service
public class ProjectService {

	private final MongoTemplate mongoTemplate;

	public ProjectService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public Project createNewProject(String title, String description) {
		Project project = new Project(title, description);
		mongoTemplate.insert(project);
		return project;
	}
	

	public Project updateTitle(String projectID, String title) {
		Project project = mongoTemplate.findById(projectID, Project.class);
		project.setTitle(title);
		mongoTemplate.save(project);
		return project;
	}

	public Project updateDescription(String projectID, String description) {
		Project project = mongoTemplate.findById(projectID, Project.class);
		project.setDescription(description);
		mongoTemplate.save(project);
		return project;
	}
	
	public EmployeeList addEmployeeToProject(String projectID, Employee employee) {
		Project project = mongoTemplate.findById(projectID, Project.class);
		project.getEmployeeList().addEmployee(employee);
		mongoTemplate.save(project);
		return project.getEmployeeList();
	}

}
