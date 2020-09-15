package com.darylhowedevs.bugcatch.bug.bugqueue;

import com.darylhowedevs.bugcatch.bug.Bug;

public class PriorityQueueElement {

	private int priority;
	private Bug bug;
	private String type;

	public PriorityQueueElement() {
		
	}
	
	public PriorityQueueElement(String priority, Bug bug) {
		
		bug.setPriority(priority);
		this.bug = bug;

	
		if (priority.equalsIgnoreCase("Highest")) {
			this.priority = 10;
			this.type = "Highest";
		} else if (priority.equalsIgnoreCase("High")) {
			this.priority = 7;
			this.type = "High";

		} else if (priority.equalsIgnoreCase("Medium")) {
			this.priority = 5;
			this.type = "Medium";

		} else if (priority.equalsIgnoreCase("Low")) {
			this.priority = 3;
			this.type = "Low";

		} else if (priority.equalsIgnoreCase("Lowest")) {
			this.priority = 1;
			this.type = "Lowest";
		}else {
			this.priority = 0;
			this.type = "Invalid priority input.";		
		}
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	@Override
	public String toString() {
		String string = "Piority: " + priority + "\nType: " + type + "\nElement: " + bug.toString();
		return string;
	}

}
