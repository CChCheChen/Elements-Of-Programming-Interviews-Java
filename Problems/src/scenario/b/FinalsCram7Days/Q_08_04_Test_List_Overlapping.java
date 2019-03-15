package scenario.b.FinalsCram7Days;

import commonDataStructures.LinkedList;
import commonDataStructures.ListNode;

/*
8.4 TEST FOR OVERLAPPING LISTS --- LISTS ARE CYCLE-FREE

Given two singly linked lists there may be list nodes that are common to both. 
(This may not be a bug¡ªit may be desirable from the perspective of reducing memory footprint, 
as in the fly-weight pattern, or maintaining a canonical form.) 

Write a program that takes two cycle-free singly linked lists, 
and determines if there exists a node that is common to both lists.

Hint: Solve the simple cases first.

P119(P132)

 */
public class Q_08_04_Test_List_Overlapping {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.addNode(1);
		list1.addNode(3);
		list1.addNode(5);
		list1.addNode(7);
		list1.print();

		System.out.println();

		LinkedList list2 = new LinkedList();
		list2.addNode(2);
		list2.addNode(4);
		list2.addNode(6);
		list2.addNode(5);
		list2.addNode(7);
		list2.print();

		System.out.println();

		System.out.println(list1 + " and " + list2 + " have overlapping? " + linkedListOverlap(list1, list2));

	}

	//Time: O(m+n), m & n are lengths of linked lists, the worst case is to scan both of them and find NO overlapping
	//Space:O(1)
	private static boolean linkedListOverlap(LinkedList list1, LinkedList list2) {

		ListNode head1 = list1.head;
		ListNode head2 = list2.head;

		if(null == head1 || null == head2) return false;

		if(head1 == head2) return true;

		ListNode p1 = list1.head;
		ListNode p2 = list2.head;

		while(p1 != p2) {
//			if(null != p1)
//			    System.out.print("p1.val=" + p1.val + " ");
//			if(null != p2)
//			    System.out.print("p2.val=" + p2.val + " ");
//			System.out.println();
			
			p1 = null!=p1 ? p1.next : list2.head;
			p2 = null!=p2 ? p2.next : list1.head;
			
			if(null!=p1 && null!=p2 && p1.val==p2.val)
				break;
		}
		
//		if(null != p1)
//		    System.out.println("p1.val=" + p1.val + " ");
//		if(null != p2)
//		    System.out.println("p2.val=" + p2.val + " ");
		
		return p1!=null;
	}

}

