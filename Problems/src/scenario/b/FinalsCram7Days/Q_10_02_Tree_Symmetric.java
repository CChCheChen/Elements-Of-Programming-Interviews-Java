package scenario.b.FinalsCram7Days;

import commonDataStructures.BinaryTreeImp;
import commonDataStructures.TreeNode;

/*
10.2 TEST IF A BINARY TREE IS SYMMETRIC

A binary tree is symmetric if you can draw a vertical line through the root and then the left subtree is the mirror image of the right subtree. 
 
Write a program that checks whether a binary tree is symmetric.

Hint: The definition of symmetry is recursive.

 */
public class Q_10_02_Tree_Symmetric {
	public static void main(String[] args) {
		BinaryTreeImp tree = new BinaryTreeImp();
		tree.insertNode(314);
		tree.insertNode(6);
		tree.insertNode(6);
		tree.insertNode(2);
		tree.insertNode(3);
		tree.insertNode(3);
		tree.insertNode(2);

		System.out.println("Tree: " + tree.traversalBFS());
		
		System.out.println("Tree Symmetric? " + treeSymmetric(tree.root));
	}
	
	//Time: O(n), n is tree node number
	//Space:O(1)
	public static boolean treeSymmetric(TreeNode root) {
		return root==null || treeSymmetricHelper(root.left, root.right);
	}

	private static boolean treeSymmetricHelper(TreeNode left, TreeNode right) {

		if(null == left && null == right) {
			return true;
		}else if(null != left && null != right){
			
			return left.val == right.val &&
				   treeSymmetricHelper(left.left, right.right) &&
				   treeSymmetricHelper(left.right, right.left);
			
		}else {
			return false;
		}
	}
}
