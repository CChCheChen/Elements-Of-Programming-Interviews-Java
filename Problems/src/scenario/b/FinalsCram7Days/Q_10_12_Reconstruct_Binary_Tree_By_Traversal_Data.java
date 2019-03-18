package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
10.12 RECONSTRUCT A BINARY TREE FROM TRAVERSAL DATA
Many different binary trees yield the same sequence of keys in an inorder, preorder, or postorder traversal. 
However, given an inorder traversal and one of any two other traversal orders of a binary tree, 
there exists a unique binary tree that yields those orders, assuming each node holds a distinct key. 

For example, the unique binary tree whose inorder traversal sequence is (F,B,A,E,H,C,D,I,G) 
and whose preorder traversal sequence is (H,B,F,E,A,C,D,G,I)

Given an inorder traversal sequence and a preorder traversal sequence of a binary tree 
write a program to reconstruct the tree. Assume each node has a unique key.

Hint: Focus on the root.

P165(P178)

 */
public class Q_10_12_Reconstruct_Binary_Tree_By_Traversal_Data {
	
	private static int preIndex = 0;

	public static void main(String[] args) {
		char[] in = {'F', 'B', 'A', 'E', 'H', 'C', 'D', 'I', 'G'};
		char[] pre = {'H', 'B', 'F', 'E', 'A', 'C', 'D', 'G', 'I'};
		
		int len = in.length;
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<len; i++)
			map.put(in[i], i);
		
		Node root = reconstructBinaryTree(in, pre, 0, len-1, map);
		
		List<Character> post = new ArrayList<>();
		post = treePrint(root, post);
		System.out.println("Post Order: " + post);

	}

	private static Node reconstructBinaryTree(char[] in, char[] pre, int inStart, int inEnd, Map<Character, Integer> map) {
		
		if(inStart > inEnd)
			return null;
		
		Node node = new Node(pre[preIndex++]);
		
		if(inStart == inEnd) return node;
		
		int inIndex = map.get(node.val);
		
		node.left = inIndex-1<inStart ? null : reconstructBinaryTree(in, pre, inStart, inIndex-1, map);
		node.right = inIndex+1>inEnd ? null : reconstructBinaryTree(in, pre, inIndex+1, inEnd, map);
		
		return node;
	}
	
	private static List<Character> treePrint(Node node, List<Character> post) {
		if(null == node)
			return post;
		
		//Post Order Print
		treePrint(node.left, post);
		treePrint(node.right, post);
		post.add(node.val);
		
		return post;
	}

}

class Node{
	char val;
	Node left;
	Node right;
	
	public Node(char val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
