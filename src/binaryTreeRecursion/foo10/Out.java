package binaryTreeRecursion.foo10;

public class Out{
	private Out(){}

	public static void printTree(Node node){
		System.out.print(" "+node.getValue()+": "+node.getLeft().getValue()+" - "+
				node.getRight().getValue());
		System.out.println(" | "+node+": "+node.getLeft()+" - "+node.getRight());

		if(node.getLeft().getValue()!=null&&node.getRight().getValue()!=null){
			printTree(node.getLeft());
			printTree(node.getRight());
		}
		else if(node.getLeft().getValue()!=null){
			printTree(node.getLeft());
		}
		else if(node.getRight().getValue()!=null){
			printTree(node.getRight());
		}
	}
}
