package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
14.4 RENDER A CALENDAR

Consider the problem of designing an online calendaring application. 
One component of the design is to render the calendar, i.e., display it visually.

Suppose each day consists of a number of events, 
where an event is specified as a start time and a finish time. 
Individual events for a day are to be rendered as non-overlapping rectangular regions 
whose sides are parallel to the X- and Y-axes.

Let the X-axis correspond to time. 
If an event starts at time b and ends at time e, 
the upper and lower sides of its corresponding rectangle must be at b and e, respectively.

Suppose the Y-coordinates for each day's events must lie between 0 and L (a pre-specified constant), 
and each event's rectangle must have the same "height" (distance between the sides parallel to the X-axis). 

Your task is to compute the maximum height an event rectangle can have. 

Write a program that takes a set of events, 
and determines the maximum number of events that take place concurrently.

Hint: Focus on endpoints.

 */
public class Q_14_04_Find_Nearest_Repeated_Entries_In_Array {

	public static void main(String[] args) {
		List<Event> list = new ArrayList<>();
		list.add(new Event(14, 15));
		list.add(new Event(11, 13));
		list.add(new Event(6, 10));
		list.add(new Event(1, 5));
		list.add(new Event(2, 7));
		list.add(new Event(8, 9));
		list.add(new Event(11, 14));
		list.add(new Event(9, 17));
		list.add(new Event(4, 5));
		
		int maxConcurrentEventCount = maxConcurrentEventCount(list);
		System.out.println("Max Concurrent Event Count is " + maxConcurrentEventCount);

	}

	//Time: O(nlogn), O(logn) for sorting Endpoint list and O(n) for iterating Endpoint list
	//Space:O(n) for storing Endpoint list
	private static int maxConcurrentEventCount(List<Event> list) {
		List<Endpoint> endPoints = new ArrayList<>();
		for(Event e : list) {
			endPoints.add(new Endpoint(e.start, true));
			endPoints.add(new Endpoint(e.end, false));
		}
		
		Collections.sort(endPoints);
		
		int maxConcurrentEventCount = 0;
		int currConcurrentEventCount = 0;
		
		for(Endpoint ep : endPoints) {
			if(ep.isStart) {
				currConcurrentEventCount++;
				maxConcurrentEventCount = Math.max(maxConcurrentEventCount, currConcurrentEventCount);
			}else {
				currConcurrentEventCount--;
			}
		}
		
		return maxConcurrentEventCount;
	}

}

class Event{
	public int start, end;
	
	public Event(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Endpoint implements Comparable<Endpoint>{
	public int time;
	public boolean isStart;
	
	public Endpoint(int time, boolean isStart) {
	    this.time = time;
	    this.isStart = isStart;
	}


	public int compareTo(Endpoint e) {
		if(this.time != e.time) {
			return Integer.compare(this.time, e.time);
		}
		
		int result = Integer.MAX_VALUE;
		if(this.isStart && !e.isStart) {
			result = -1; //this Event should come after Event e
		}else {
			if(!this.isStart && e.isStart)
				result = 1; //this Event should come before Event e
			else
				result = 0;
		}
		
		return result;
	}
	
}