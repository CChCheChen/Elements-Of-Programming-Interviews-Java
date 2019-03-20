package scenario.b.FinalsCram7Days;

import commonDataStructures.BinarySearchTreeImp;
import commonDataStructures.TreeNode;

/*
15.4 COMPUTE THE LCA IN A BST

Since a BST is a specialized binary tree, 
the notion of lowest common ancestor(LCA), as expressed in Problem 10.4 on Page 157, holds for BSTs too.

In general, computing the LCA of two nodes in a BST is no easier than computing the LCA in a binary tree, 
since structurally a binary tree can be viewed as a BST where all the keys are equal. 

However, when the keys are distinct, it is possible to improve on the LCA algorithms for binary trees.
Design an algorithm that takes as input a BST and two nodes, and returns the LCA of the two nodes. 

For example, for the BST in Figure 15.1 on Page 255, and nodes C and G, your algorithm should return B. 
Assume all keys are distinct. 

Nodes do not have references to their parents.
Hint: Take advantage of the BST property.

P261(P274)

 */
public class Q_15_04_Compute_LCA_In_BST {

	public static void main(String[] args) {
		
		BinarySearchTreeImp bst = new BinarySearchTreeImp();
		
		bst.insertNode(19);
		bst.insertNode(7);
		bst.insertNode(43);
		bst.insertNode(3);
		bst.insertNode(11);
		bst.insertNode(23);
		bst.insertNode(47);
		bst.insertNode(2);
		bst.insertNode(5);
		bst.insertNode(17);
		bst.insertNode(37);
		bst.insertNode(53);
		bst.insertNode(13);
		bst.insertNode(29);
		bst.insertNode(41);
		bst.insertNode(31);
		
		System.out.println("BST PreOrder: " + bst.traversalDFSPreOrder());
		
		TreeNode node1 = bst.searchNode(3);
		TreeNode node2 = bst.searchNode(17);
		TreeNode lca = findLCA(bst, node1, node2);//make sure node1.val <= node2.val
		                                          //make sure tree is not null
		
		System.out.println("Lowest Common Ancestor(LCA) is " + lca.val);

	}

	//Time: O(h), h is the bst height
	//SPace:O(1)
	private static TreeNode findLCA(BinarySearchTreeImp bst, TreeNode node1, TreeNode node2) {
		
		if(null == bst || null == bst.root)
			return null;

		TreeNode curr = bst.root;
		
		/*if(node1.val == curr.val || node2.val == curr.val) {
			//one of node1 or node2 is the root, LCA must be the root
			return curr;
		}*/
		
		/*if(node1.val < curr.val && node2.val > curr.val) {
			//node1 in left branch from root and node2 are in right branch from root, LCA must be the root
			return curr;
		}else {*/
		
		while(node2.val < curr.val || node1.val > curr.val)
			//node1 and node2 are in left branch from root
			while(node2.val < curr.val) {//node1 and node2 are in left branch from root
				curr = curr.left;
			}
            
		    while(node1.val > curr.val){//node1 and node2 are in right branch from root
				curr = curr.right;
			}
			
		/*}*/
		
		return curr;
	}

}
