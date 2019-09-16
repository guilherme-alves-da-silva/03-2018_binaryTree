package binaryTreeRecursion.foo10;

public class Node{
	private Integer value; //null means the node is not active
	private Node right;
	private Node left;
	private Node parent; //1

	public Node(){}
	public Node(int value){
		this.value=value;
		this.setLeft(new Node());
		this.setRight(new Node());
	}
	public Integer getValue(){
		return this.value;
	}
	public void setValue(Integer value){
		this.value=value;
	}
	public Node getRight(){
		return this.right;
	}
	public void setRight(Node right){
		this.right=right;
		this.right.setParent(this);
	}
	public Node getLeft(){
		return this.left;
	}
	public void setLeft(Node left){
		this.left=left;
		this.left.setParent(this);
	}
	public Node getParent(){
		return this.parent;
	}
	public void setParent(Node node){
		this.parent=node;
	}
}

//1: not needed for the remove0 method, and the insert works without the parent, if only using the remove0.
