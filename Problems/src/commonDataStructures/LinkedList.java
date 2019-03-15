package commonDataStructures;

public class LinkedList {

	public ListNode head;
	
	public LinkedList(){
		this.head = null;
	}
	
	public void addNode(int val) {
		ListNode node = new ListNode(val);
		
		if(head == null) {
			head = node;
			return;
		}

		ListNode curr = head;
		while(null != curr.next) {
			curr = curr.next;
		}
		curr.next = node;
		return;
	}
	
	public void print() {
		if(null == head)
			return;
		
		ListNode curr = head;
		while(null != curr) {
			System.out.print("-->" + curr.val);
			curr = curr.next;
		}
	}
	
}
