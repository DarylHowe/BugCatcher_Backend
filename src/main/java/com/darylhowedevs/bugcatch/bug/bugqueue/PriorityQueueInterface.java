package com.darylhowedevs.bugcatch.bug.bugqueue;

import java.util.List;

import com.darylhowedevs.bugcatch.bug.Bug;

public interface PriorityQueueInterface {

	public void enqueue(Object element);

	public Object dequeue();

	public int size();

	public boolean isEmpty();

	public List<Bug> getElementsWithPriority(String priority);

	public Bug findBugByID(String bugID);
	
	public void removeBugByID(String bugID);

}
