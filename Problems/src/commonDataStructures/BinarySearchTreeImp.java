package commonDataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImp {
	public TreeNode root;

	public BinarySearchTreeImp() {
		this.root = null;
	}

	public void insertNode(int val) {
		TreeNode node = new TreeNode(val);

		if(null == root) {
			root = node;
			return;
		}else {
			TreeNode curr = root;
			while(null != curr) {
				if(val < curr.val) {//insert into left branch
					if(curr.left == null) {
						curr.left = node;
						return;
					}
					curr = curr.left;
				}else {
					if(curr.right == null) {
						curr.right = node;
						return;
					}
					curr = curr.right;
				}
			}
		}
	}

	//use Binary Search
	public TreeNode searchNode(int val) {
		if(null == root) 
			return null;

		TreeNode curr = root;
		while(null != curr) {
			if(val < curr.val)
				curr = curr.left;
			else if(val > curr.val)
				curr = curr.right;
			else//val = curr.val
				return curr;
		}

		return null;
	}

	public void deleteNode(int val) {

	}

	//Breadth First Search
	public List<Integer> traversalBFS(){
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(null == root)
        	return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
        	curr = queue.poll();
        	result.add(curr.val);
        	
        	if(null != curr.left)
        		queue.add(curr.left);
        	
        	if(null != curr.right)
        		queue.add(curr.right);
        }
        
        return result;
	}

	public List<Integer> traversalBFSRecursive(Queue<TreeNode> queue, List<Integer> list){
		if(queue.isEmpty())
			return list;
    
		TreeNode curr = queue.poll();
		list.add(curr.val);
		
		if(null != curr.left)
			queue.add(curr.left);
		
		if(null != curr.right)
			queue.add(curr.right);
		
		return traversalBFSRecursive(queue, list);
	}

	//Depth First Search
	public List<Integer> traversalDFSPreOrder(){//N-L-R
        List<Integer> list = new ArrayList<>();
        return traversalDFSPreOrderHelper(list, root);
	}

	private List<Integer> traversalDFSPreOrderHelper(List<Integer> list, TreeNode node) {
        if(null == node)
        	return list;
        
        list.add(node.val);
        traversalDFSPreOrderHelper(list, node.left);
        traversalDFSPreOrderHelper(list, node.right);

		return list;
	}

	public List<Integer> traversalDFSInOrder(){//L-N-R
		List<Integer> list = new ArrayList<>();
        return traversalDFSInOrderHelper(list, root);
	}

	private List<Integer> traversalDFSInOrderHelper(List<Integer> list, TreeNode node) {
		if(null == node)
        	return list;
		
        traversalDFSPreOrderHelper(list, node.left);
        list.add(node.val);
        traversalDFSPreOrderHelper(list, node.right);

		return list;
	}

	public List<Integer> traversalDFSPostOrder(){//L-R-N
		List<Integer> list = new ArrayList<>();
        return traversalDFSPostOrderHelper(list, root);
	}

	private List<Integer> traversalDFSPostOrderHelper(List<Integer> list, TreeNode node) {
		if(null == node)
        	return list;
		
        traversalDFSPreOrderHelper(list, node.left);  
        traversalDFSPreOrderHelper(list, node.right);
        list.add(node.val);
      
		return list;
	}

}
