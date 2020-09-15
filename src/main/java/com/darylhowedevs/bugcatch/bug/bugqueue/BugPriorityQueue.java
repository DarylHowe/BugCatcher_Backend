package com.darylhowedevs.bugcatch.bug.bugqueue;

import java.util.ArrayList;
import java.util.List;

import com.darylhowedevs.bugcatch.bug.Bug;

public class BugPriorityQueue implements PriorityQueueInterface {

	private List<PriorityQueueElement> priorityQueue;

	public BugPriorityQueue() {
		priorityQueue = new ArrayList<>();
	}

	@Override
	public void enqueue(Object element) {

		int index;
		PriorityQueueElement pqElement = (PriorityQueueElement) element;

		index = findInsertPosition(pqElement.getPriority());

		if (index > size()) {
			priorityQueue.add(pqElement);
		} else {
			priorityQueue.add(index, pqElement);
		}
	}

	private int findInsertPosition(int newPriority) {
		boolean isFound = false;
		int position = 0;
		PriorityQueueElement elem;

		while (position < priorityQueue.size() && !isFound) {

			elem = priorityQueue.get(position);
			if (elem.getPriority() >= newPriority) {
				position = position + 1;
			} else {
				isFound = true;
			}
		}

		return position;
	}

	@Override
	public Object dequeue() {
		return priorityQueue.remove(0);
	}

	@Override
	public int size() {
		return priorityQueue.size();
	}

	@Override
	public boolean isEmpty() {
		return priorityQueue.isEmpty();
	}

	@Override
	public List<Bug> getElementsWithPriority(String priority) {

		List<Bug> list = new ArrayList<>();

		for (int i = 0; i < priorityQueue.size(); i++) {

			if (priorityQueue.get(i).getBug().getPriority().equalsIgnoreCase(priority)) {
				Bug currentBug = priorityQueue.get(i).getBug();
				list.add(currentBug);
			}
		}

		return list;
	}

	public List<Bug> getBugsByStatus(String status) {
		List<Bug> list = new ArrayList<>();
		System.out.println("STATUS:" + status);

		for (int i = 0; i < priorityQueue.size(); i++) {
			Bug currentBug = priorityQueue.get(i).getBug();
			System.out.println("CURRENT BUG STATUS:" + currentBug.getStatus());
			if (currentBug.getStatus().equalsIgnoreCase(status)) {
				list.add(currentBug);
				System.out.println("ADDED!");
			}
		}
		return list;
	}

	@Override
	public Bug findBugByID(String bugID) {
		Bug bug = null;

		for (int i = 0; i < priorityQueue.size(); i++) {

			Bug currentBug = priorityQueue.get(i).getBug();

			if (currentBug.getBugID().equalsIgnoreCase(bugID)) {
				return currentBug;
			}
		}
		return bug;
	}

	public void updateBugByID(String bugID, Bug updatedBug) {
		for (int i = 0; i < priorityQueue.size(); i++) {
			Bug currentBug = priorityQueue.get(i).getBug();
			if (currentBug.getBugID().equalsIgnoreCase(bugID)) {
				priorityQueue.remove(i);

				PriorityQueueElement pqElement = new PriorityQueueElement(updatedBug.getPriority(), updatedBug);
				enqueue(pqElement);
			}
		}
	}
	
	public void updateBugPriority(String bugID, String priority) {
		for (int i = 0; i < priorityQueue.size(); i++) {
			Bug currentBug = priorityQueue.get(i).getBug();
			
			if (currentBug.getBugID().equalsIgnoreCase(bugID)) {
				currentBug.setPriority(priority);
				PriorityQueueElement pqElement = new PriorityQueueElement(currentBug.getPriority(), currentBug);
				priorityQueue.remove(i);
				enqueue(pqElement);
			}
		}
	}

	@Override
	public void removeBugByID(String bugID) {

		for (int i = 0; i < priorityQueue.size(); i++) {

			Bug currentBug = priorityQueue.get(i).getBug();

			if (currentBug.getBugID().equalsIgnoreCase(bugID)) {
				priorityQueue.remove(i);
				break;
			}
		}
	}

	public List<PriorityQueueElement> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(List<PriorityQueueElement> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

}
