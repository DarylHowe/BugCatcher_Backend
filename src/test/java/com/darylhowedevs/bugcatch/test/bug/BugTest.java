package com.darylhowedevs.bugcatch.test.bug;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.darylhowedevs.bugcatch.bug.Bug;

class BugTest {

	private Bug bug;

	@BeforeAll
	static void beforeAllMessage() {
		System.out.println("@BeforeAll must use static methods.");
	}

	@AfterAll
	static void afterAllMessage() {
		System.out.println("@AfterAll must also use static methods.");
	}

	// The 'BeforeEach' method is called before each test method is executed.
	@BeforeEach
	void init() {
		bug = new Bug("TestTitle", "TestDescription");
	}

	@AfterEach
	void afterEachMessage() {
		System.out.println("This method gets called after each test method is executed.");
	}

	@Test
	@DisplayName("BugID should auto increment by 1 each time a new bug object is made.")
	@Disabled
	void testBugIDIncrementsForEachBugObject() {

		bug = new Bug("TestTitle", "TestDescription");

		String expected = "0";
		String actual = bug.getBugID();

		assertEquals(expected, actual, "This method should create two bug objects with auto incremented IDs.");

		Bug bug01 = new Bug("TestTitle", "TestDescription");

		String expected01 = "1";
		String actual01 = bug01.getBugID();

		assertEquals(expected01, actual01);
	}

	@Test
	@DisplayName("Date of bug created should match current date.")
	void testBugDateCreatedMatchesCurrentDate() {

		String expected = new Date().toString();
		String actual = bug.getDateCreated();

		assertEquals(expected, actual, "This method should check a bugs dateCreated matches the current date.");
	}

}
