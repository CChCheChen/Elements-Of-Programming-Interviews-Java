package scenario.b.FinalsCram7Days;

import java.util.NoSuchElementException;

/*
9.8 IMPLEMENT A CIRCULAR QUEUE

A queue can be implemented using an array and two additional fields, 
the beginning and the end indices. 

This structure is sometimes referred to as a circular queue. 

Both enqueue and dequeue have 0(1) time complexity. 

If the array is fixed, there is a maximum number of entries that can be stored. 
If the array is dynamically resized, the total time for m combined enqueue and dequeue operations is 0(m).

Implement a queue API using an array for storing elements. 
Your API should include:
a constructor function, which takes as argument the initial capacity of the queue,
enqueue and dequeue functions, and 
a function which returns the number of elements stored. 

Implement dynamic resizing to support storing an arbitrarily large number of elements.

Hint: Track the head and tail. How can you differentiate a full queue from an empty one?

P145(P158)

 */
public class Q_09_08_Circular_Queue {

	public int headIndex = 0, tailIndex = 0, elementNum = 0;
	private int scaleFactor = 2;//when no more capacity, double the size of current size
	private int[] elements;
	
	public Q_09_08_Circular_Queue(int capacity) {
		elements = new int[capacity];
	}
	
	public void enqueue(int x) {//add element at tail
		System.out.println("Enqueue " + x);
		System.out.println("Before: elementNum=" + elementNum);
		
		if(elementNum == elements.length) {//double the size
			
			int[] temp = new int[elements.length * scaleFactor];

			for(int i=0; i<elementNum; i++) {
				temp[i] = elements[i+headIndex];
				//System.out.println("temp[" + i +"]=" + temp[i]);
			}
			
			elements = null;
			elements = temp;
			
			headIndex = 0;
			tailIndex = elementNum;
		}
		
		elements[tailIndex] = x;
		tailIndex++;
		
		elementNum++;
		System.out.println("After: elementNum=" + elementNum);
	}
	
    public int dequeue() {//remove element from head
    	System.out.println("Dequeue ");
    	
    	if(elementNum != 0) {
    		elementNum--;
    		int head = elements[headIndex];

            //re-format elements, shift all elements to left by one, this keeps head unchanged
    		for(int i=0; i<elements.length-1; i++) {
    			elements[i] = elements[i+1];
    		}
    		elements[elements.length-1] = 0;
    		tailIndex--;
    		
    		return head;
    	}else {
    		throw new NoSuchElementException("Queue is empty!");
    	}
	}
	
    public int elementNumber() {
    	return elementNum;
    }
    
    public void print() {
    	for(int i : elements)
    		System.out.print(i + " ");
    }
}
