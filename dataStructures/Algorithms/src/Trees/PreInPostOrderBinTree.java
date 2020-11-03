package Trees;


public class PreInPostOrderBinTree {
	
	TreeNode root;
	
	PreInPostOrderBinTree() {
		root = null;
	}
	
	//Root, left, right
	public void preOrder(TreeNode node) {
		if (node == null) return;
		
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//Left, root, right
	public void inOrder(TreeNode node) {
		if (node == null) return;
		
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}
	
	//left, right, root
	public void postOrder(TreeNode node) {
		if (node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
	}
	
	void preOrder() { preOrder(root); }
	void postOrder() { postOrder(root); }
	void inOrder() { inOrder(root); }
	
	public static void main(String[] args) {
		PreInPostOrderBinTree tree = new PreInPostOrderBinTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		System.out.println("Pre Order");
		tree.preOrder();
		System.out.println(" ");
		
		System.out.println("In Order");
		tree.inOrder();
		System.out.println(" ");
		
		System.out.println("Post Order");
		tree.postOrder();
		System.out.println(" ");
		
	}
	
	
	
}
