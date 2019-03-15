package scenario.b.FinalsCram7Days;

import commonDataStructures.LinkedListImp;
import commonDataStructures.ListNode;

/*
8.7 REMOVE THE kTH LAST ELEMENT FROM A LIST

Without knowing the length of a linked list, 
it is not trivial to delete the kth last element in a singly linked list.

Given a singly linked list and an integer k, 
write a program to remove the kth last element from the list. 

Your algorithm cannot use more than a few words of storage, 
regardless of the length of the list. 

In particular, you cannot assume that it is possible to record the length of the list.

Hint: If you know the length of the list, can you find the kth last node using two iterators?

P123(P136)

 */
public class Q_08_07_Remove_kth_Last_Element_From_List {

	public static void main(String[] args) {
		LinkedListImp list = new LinkedListImp();
		list.addNode(1);
		list.addNode(3);
		list.addNode(5);
		list.addNode(7);
		list.print();

		int k = 4;

		System.out.println();

		if(k > list.size())
			System.out.println("k is greater than list size!");
		else {
			if(k == 1)
				System.out.println("Remove the " + k + "st last element from list:");
			else if(k == 2)
				System.out.println("Remove the " + k + "nd last element from list:");
			else if(k == 3)
				System.out.println("Remove the " + k + "rd last element from list:");
			else {
				System.out.println("Remove the " + k + "th last element from list:");
			}
			removeKthLastElement(list, k);
		}
		list.print();
	}

	//Time: O(n), n is list size
	//Space:O(1)
	private static void removeKthLastElement(LinkedListImp list, int k) {
		ListNode p1 = list.head;
		ListNode p2 = list.head.next;

		//Move p2 k-steps ahead of p1
		while(k > 0) {
			if(null != p2) {
				System.out.println("p2.val=" + p2.val);
				p2 = p2.next;
			}else {
				System.out.println("p2=null");
			}
			k--;
		}

		//If p2 already at tail, remove head simply and return
		if(null == p2) {
			list.head = p1.next;
			p1.next = null;
			return;
		}

		//Keep moving p1 and p2 towards the tail of LinkedList
		//Once p2 = null, means p2 is at the tail, and p1 will be the ListNode to be deleted
		while(p2 != null) {
			System.out.println("p1.val=" + p1.val + "p2.val=" + p2.val);
			p1 = p1.next;
			p2 = p2.next;
		}

		//Delete p1
		ListNode next = p1.next;
		p1.next = next.next;

		//TODO:Grabage Collect next
	}

}
