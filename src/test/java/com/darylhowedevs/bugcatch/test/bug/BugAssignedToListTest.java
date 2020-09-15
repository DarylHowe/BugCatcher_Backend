package com.darylhowedevs.bugcatch.test.bug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.darylhowedevs.bugcatch.bug.BugAssignedToList;
import com.darylhowedevs.bugcatch.staff.Employee;

public class BugAssignedToListTest {

	private BugAssignedToList employeeList;


	@BeforeEach
	void init() {
		employeeList = new BugAssignedToList();
	}

	@Test
	@DisplayName("Should return employee by if ID exists.")
	// This must be disabled as ID's are static.
	@Disabled
	void testEmployeeIsCorrectlyReturned() {

		Employee e1 = new Employee("Daryl", "Howe");
		Employee e2 = new Employee("Mike", "Sully");
		
		employeeList.addNewEmployee(e1);
		employeeList.addNewEmployee(e2);


		Employee actual = employeeList.getEmployeeByID("0");

		assertEquals(e1, actual, "This method should check the correct employee is returned.");
	}

	@Test
	@DisplayName("Should return null if empoloyee ID does not exist.")
	void testNullIsReturnedIfEmpoloyeeDoesNotExist() {

		Employee e1 = new Employee("Daryl", "Howe");
		Employee e2 = new Employee("Mike", "Sully");

		employeeList.addNewEmployee(e1);
		employeeList.addNewEmployee(e2);

		Employee actual = employeeList.getEmployeeByID("3");

		assertEquals(null, actual, "This method should return null.");

	}

}
