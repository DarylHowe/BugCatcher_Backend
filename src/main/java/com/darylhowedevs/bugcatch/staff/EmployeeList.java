package com.darylhowedevs.bugcatch.staff;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

	private List<Employee> employeeList;

	public EmployeeList() {
		employeeList = new ArrayList<>();
	}

	public List<Employee> addEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return employeeList;
	}

	public List<Employee> removeEmployeeByID(String employeeID) {
		for (int i = 0; i < employeeList.size(); i++) {

			if (employeeList.get(i).getEmployeeID().equalsIgnoreCase(employeeID)) {
				employeeList.remove(i);
				return employeeList;
			}
		}
		return employeeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
