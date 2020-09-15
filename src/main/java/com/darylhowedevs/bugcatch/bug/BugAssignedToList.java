package com.darylhowedevs.bugcatch.bug;

import java.util.ArrayList;
import java.util.List;

import com.darylhowedevs.bugcatch.staff.Employee;

public class BugAssignedToList {

	private List<Employee> employeeList;

	public BugAssignedToList() {
		employeeList = new ArrayList();
	}

	public Employee getEmployeeByID(String employeeID) {
		
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmployeeID().equalsIgnoreCase(employeeID)) {
				return employeeList.get(i);
			}
		}
		return null;
	}

	public String removeEmployeeByID(String employeeID) {

		String message = "An employee with the ID " + employeeID
				+ " could not be found and therefore was not unassigned.";

		for (int i = 0; i < employeeList.size(); i++) {

			if (employeeList.get(i).getEmployeeID().equalsIgnoreCase(employeeID)) {
				employeeList.remove(i);
				message = "An employee with the ID " + employeeID + " was unassigned for this bug.";
				break;
			}
		}
		return message;
	}

	public void addNewEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
