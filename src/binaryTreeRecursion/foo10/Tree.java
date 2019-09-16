package binaryTreeRecursion.foo10;

public class Tree{
	private Node root;

	public Tree(Node root){
		this.setRoot(root);
	}
	public Node getRoot(){
		return this.root;
	}
	private void setRoot(Node root){
		this.root=root;
		this.root.setParent(null);
	}

	public boolean insert(Node n){
		return insert(this.getRoot(), n);
	}
	private boolean insert(Node current, Node n){ //without balance
		if(current.getValue()==null){
			setRoot(n);
			return true;
		}
		else if(n.getValue()<current.getValue()){
			if(current.getLeft().getValue()==null){
				current.setLeft(n);
				return true;
			}
			return insert(current.getLeft(), n);
		}
		else if(n.getValue()>current.getValue()){
			if(current.getRight().getValue()==null){
				current.setRight(n);
				return true;
			}
			return insert(current.getRight(), n);
		}
		else{
			System.out.println("Value "+n.getValue()+" already in the tree.");
			return false;
		}
	}

	private void bottomUpInsert(Node current){
		if(current.getLeft().getValue()==null&&current.getRight().getValue()==null){
			changeReferences(current, new Node());
			insert(new Node(current.getValue()));
		}
		else{
			if(current.getLeft().getValue()!=null&&current.getRight().getValue()!=null){
				bottomUpInsert(current.getLeft());
				bottomUpInsert(current.getRight());
			}
			else if(current.getLeft().getValue()!=null){
				bottomUpInsert(current.getLeft());
			}
			else if(current.getRight().getValue()!=null){
				bottomUpInsert(current.getRight());
			}
			bottomUpInsert(current);
		}
	}

	public Node remove2(int n){
		return remove2(getRoot(), n);
	}
	private Node remove2(Node current, int n){
		if(current.getValue()==null){
			System.out.println("The tree is empty.");
			return null;
		}
		else if(current.getValue()==n){
			if(current.getLeft().getValue()!=null&&current.getRight().getValue()!=null){
				changeReferences(current, current.getLeft());
				bottomUpInsert(current.getRight());
			}
			else if(current.getLeft().getValue()!=null&&current.getRight().getValue()==null){
				changeReferences(current, current.getLeft());
			}
			else if(current.getRight().getValue()!=null&&current.getLeft().getValue()==null){
				changeReferences(current, current.getRight());
			}
			current.setValue(null);
			return current;
		}
		else if(n<current.getValue()&&current.getLeft().getValue()!=null){
			return remove2(current.getLeft(), n);
		}
		else if(n>current.getValue()&&current.getRight().getValue()!=null){
			return remove2(current.getRight(), n);
		}
		else{
			System.out.println("Node "+n+" not found.");
			return null;
		}
	}

	private void changeReferences(Node toRemove, Node toKeep){
		if(toRemove.getParent()==null){ //3
			setRoot(toKeep);
		}
		else if(toRemove.getParent().getLeft()==toRemove){
			toRemove.getParent().setLeft(toKeep);
		}
		else if(toRemove.getParent().getRight()==toRemove){
			toRemove.getParent().setRight(toKeep);
		}
	}

	public Node remove1(int n){
		return remove1(getRoot(), n);
	}
	private Node remove1(Node current, int n){ //remove with 1 child
		System.out.println(current.getValue()+" at "+current+" - "+n);
		if(current.getValue()==null){ //4
			System.out.println("The tree is empty.");
			return null;
		}
		else if(current.getValue()==n){
			if(current.getLeft().getValue()!=null&&current.getRight().getValue()!=null){
				System.out.println("Node "+n+" cannot be removed.");
				return null;
			}
			else if(current.getLeft().getValue()!=null&&current.getRight().getValue()==null){
				changeReferences(current, current.getLeft());
			}
			else if(current.getRight().getValue()!=null&&current.getLeft().getValue()==null){
				changeReferences(current, current.getRight());
			}
			current.setValue(null);
			return current;
		}
		else if(n<current.getValue()&&current.getLeft().getValue()!=null){
			return remove1(current.getLeft(), n);
		}
		else if(n>current.getValue()&&current.getRight().getValue()!=null){
			return remove1(current.getRight(), n);
		}
		else{
			System.out.println("Node "+n+" not found.");
			return null;
		}
	}

	public Node remove0(int n){
		return remove0(getRoot(), n);
	}
	private Node remove0(Node current, int n){ //remove without child //2
		System.out.println(current.getValue()+" at "+current+" - "+n);
		if(current.getValue()==null){ //4
			System.out.println("The tree is empty.");
			return null;
		}
		else if(current.getValue()==n){
			if(current.getRight().getValue()==null&&current.getLeft().getValue()==null){
				current.setValue(null);
				return current;
			}
			System.out.println("Node "+n+" cannot be removed.");
			return null;
		}
		else if(n<current.getValue()&&current.getLeft().getValue()!=null){
			return remove0(current.getLeft(), n);
		}
		else if(n>current.getValue()&&current.getRight().getValue()!=null){
			return remove0(current.getRight(), n);
		}
		else{
			System.out.println("Node "+n+" not found.");
			return null;
		}
	}
}

//2: the method is not setting the reference to a removed node to null, meaning that it's parent will still reference to it, but it wont be an active node because it's value will be set to null. the method is working fine, this is just a note.
//3: only root has a null parent.
//4: the only way to be true is if a null was passed to the method outside of the recursion, meaning the method itself doesnt get into a node with a null value.
