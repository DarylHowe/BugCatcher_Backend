package com.darylhowedevs.bugcatch.test.bug;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.darylhowedevs.bugcatch.bug.Bug;
import com.darylhowedevs.bugcatch.bug.bugqueue.BugPriorityQueue;
import com.darylhowedevs.bugcatch.bug.bugqueue.PriorityQueueElement;

public class BugPriorityQueueTest {

	private BugPriorityQueue bugQueue;
	Bug b1;
	Bug b2;
	Bug b3;
	Bug b4;

	@BeforeEach
	void init() {
		bugQueue = new BugPriorityQueue();
		b1 = new Bug("TestTitle", "test Description");
		b2 = new Bug("TestTitle", "test Description");
		b3 = new Bug("TestTitle", "test Description");
		b4 = new Bug("TestTitle", "test Description");

		PriorityQueueElement e1 = new PriorityQueueElement("Highest", b1);
		PriorityQueueElement e2 = new PriorityQueueElement("Medium", b2);
		PriorityQueueElement e3 = new PriorityQueueElement("Low", b3);
		PriorityQueueElement e4 = new PriorityQueueElement("Lowest", b4);

		bugQueue.enqueue(e1);
		bugQueue.enqueue(e2);
		bugQueue.enqueue(e3);
		bugQueue.enqueue(e4);
	}

	@Test
	@DisplayName("Date of bug created should match current date.")
	void testBugDateCreatedMatchesCurrentDate() {

		List<Bug> expected = Arrays.asList(b1);
		//List<Bug> actual = bugQueue.getElementsWithPriority(10);

		//assertEquals(expected, actual, "This method should check a bugs dateCreated matches the current date.");
	}
}
