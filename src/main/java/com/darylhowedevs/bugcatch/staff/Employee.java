package com.darylhowedevs.bugcatch.staff;

import org.springframework.data.annotation.Id;

public class Employee {

	@Id
	private String employeeID;
	private static int employeeIDStatic = -1;
	private String firstName;
	private String secondName;
	
	// List<AssignedBug> bugList;

	public Employee(String firstName, String secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
		employeeIDStatic++;
		this.employeeID = Integer.toString(employeeIDStatic);
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}
