package Game;

public class TreeNode {

	private String text;
	private TreeNode rightNode;
	private TreeNode leftNode;

	public TreeNode(String text) {
		this.text = text;
		this.rightNode = null;
		this.leftNode = null;
	}

	public void setLeftChild(TreeNode node) {
	        this.leftNode = node;
	    }
	    
	    public void setRightChild(TreeNode node) {
	        this.rightNode = node;
	    }
	    
	    public TreeNode getLeftChild() {
	        return leftNode;
	    }
	    
	    public TreeNode getRightChild() {
	        return rightNode;
	    }
	    
	    public String getText() {
	        return text;
	    }
}
