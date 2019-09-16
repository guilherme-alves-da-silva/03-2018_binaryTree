package binaryTreeRecursion.foo10;

public class Main{
	private static void print(Tree tree, int n){
		System.out.println(" main"+n+":");
		Out.printTree(tree.getRoot());
		System.out.println();
	}

	public static void main(String[] args){
		Tree t=new Tree(new Node(10));
		print(t, 0);
/*
		//test sequence 1
		t.insert(new Node(7));
		print(t, 1);

		t.insert(new Node(9));
		print(t, 2);

		t.insert(new Node(8));
		print(t, 3);

		t.remove1(7);
		print(t, 4);

		t.remove1(10);
		print(t, 5);

		t.insert(new Node(15));
		t.insert(new Node(12));
		t.insert(new Node(16));
		print(t, 6);

		//test sequence 2
		t.insert(new Node(8));
		print(t, 1);

		t.remove0(8);
		print(t, 2);

		t.remove0(10);
		print(t, 3);

		t.remove0(10);
		print(t, 4);

		t.insert(new Node(15));
		print(t, 5);

		t.insert(new Node(12));
		t.insert(new Node(16));
		t.insert(new Node(14));
		print(t, 6);
*/
		//test sequence 3
		t.insert(new Node(8));
		t.insert(new Node(15));
		t.insert(new Node(12));
		t.insert(new Node(14));
		t.insert(new Node(5));
		t.insert(new Node(17));
		t.insert(new Node(13));
		t.insert(new Node(18));
		t.insert(new Node(19));
		t.insert(new Node(16));
		print(t, 1);
		t.remove2(15);
		print(t, 2);

		System.out.println(t.getRoot().getValue()+", "+t.getRoot().getParent());
	}
}

//must change the "changeReferences()" method to set the parent of the node toKeep to the parent of the node that's being removed.
