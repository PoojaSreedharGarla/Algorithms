package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {
	TreeNode root;
	
	BFS() {
		root = null;
	}
	
	
	public void printLevelOrder() {
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode tmpNode = queue.poll();
			
			System.out.print(tmpNode.val + " ");
			
			if (tmpNode.left != null) {
				queue.add(tmpNode.left);
			}
			
			if (tmpNode.right != null) {
				queue.add(tmpNode.right);
			}
		}
	}
	
	public static void main (String[] args) {
		BFS tree = new BFS();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(5);
		
		tree.printLevelOrder();
		
	}
	
}

/*
Time complexity: \mathcal{O}(N)O(N) since one has to visit each node.

Space complexity: \mathcal{O}(H)O(H) to keep the recursion stack, where HH is a tree height. The worst-case situation is a skewed tree, when H = NH=N.
*/