package commonDataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeImp {
	public TreeNode root;
    
	public BinaryTreeImp() {
		this.root = null;
	}
	
	public void insertNode(int val) {
		TreeNode node = new TreeNode(val);
		Queue<TreeNode> queue = new LinkedList<>();

		if(null == root) {
			root = node;
			return;
		}else {
			TreeNode curr = root;
			queue.add(curr);
			
			while(!queue.isEmpty()) {
				curr = queue.poll();
				
				if(curr.left == null) {
					curr.left = node;
					break;
				}
				queue.add(curr.left);
				
				if(curr.right == null) {
					curr.right = node;
					break;
				}
				queue.add(curr.right);	
			}

		}
	}
	
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
	
}
