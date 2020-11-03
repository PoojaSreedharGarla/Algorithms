package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFSIterative {
	TreeNode root;
	
	DFSIterative() {
		root = null;
	}
	
	public void printPreOrderIterative() {
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode tmpNode = stack.pop();
			
			System.out.print(tmpNode.val + " ");
			
			if (tmpNode.right != null) {
				stack.push(tmpNode.right);
			}
			
			if (tmpNode.left != null) {
				stack.push(tmpNode.left);
			}
		}
	}
	
	public static void main(String[] args) {
		DFSIterative tree = new DFSIterative();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		tree.printPreOrderIterative();
	}
}
