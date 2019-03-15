package scenario.b.FinalsCram7Days;

public class Q_09_08_Circular_Queue_Test {

	public static void main(String[] args) {
		Q_09_08_Circular_Queue queue = new Q_09_08_Circular_Queue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.print();
		System.out.println("headIndex=" + queue.headIndex + " & tailIndex=" + queue.tailIndex);
		System.out.println();
		
		queue.dequeue();
		queue.print();
		System.out.println("headIndex=" + queue.headIndex + " & tailIndex=" + queue.tailIndex);
		System.out.println();
		
		queue.enqueue(4);
		queue.print();
		System.out.println("headIndex=" + queue.headIndex + " & tailIndex=" + queue.tailIndex);
		System.out.println();
		
		queue.enqueue(5);
		queue.print();
		System.out.println("headIndex=" + queue.headIndex + " & tailIndex=" + queue.tailIndex);
		System.out.println();
		
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.print();
		System.out.println("headIndex=" + queue.headIndex + " & tailIndex=" + queue.tailIndex);
		System.out.println();
		
		queue.dequeue();
		queue.print();
		System.out.println("headIndex=" + queue.headIndex + " & tailIndex=" + queue.tailIndex);
		System.out.println();

	}

}
