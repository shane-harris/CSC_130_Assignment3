package edu.csus.csc130.fall2018.assignment3;

/**
 * Updated by: Shane Harris
 */
public class Node <Key extends Comparable<Key>, Value> {
	Key key; // key
	Value val; // associated value
	Node<Key, Value> left, right; // links to subtrees
	int n; // # nodes in subtree rooted here

	public Node(Key key, Value val, int n) {
		this.key = key;
		this.val = val;
		this.n = n;
	}
	
	/**
	 * @param node root of the sub-tree
	 * @return true if for each node in the sub-tree, n field value matches the number of nodes in its sub-tree, otherwise false
	 */
	public static <Key extends Comparable<Key>, Value> boolean isBinaryTree(Node<Key, Value> node) {
		if(node == null) 
			return true;
		
		if(node.left == null && node.right == null && node.n != 1) 
			return false;

		int L,R;
		if(node.left == null) {L=0;}
		else {L= node.left.n;}
		
		if(node.right == null) {R=0;}
		else {R= node.right.n;}
		
		if(node.n != (R + L + 1)){
		     return false;
		}
		else{
		   return (isBinaryTree(node.left) && isBinaryTree(node.right));
		}
		
		//throw new UnsupportedOperationException("Not implemented yet");	
}
	
	public static <Key extends Comparable<Key>, Value> int nodesN(Node<Key, Value> node) {
		int nodes = 1;
		if(node == null) {
			nodes = 0;
			return nodes;
		}
		if(node.left != null) {
			nodes += nodesN(node.left);
		}
		if(node.right != null) {
			nodes += nodesN(node.right);
		}
		return nodes;
	}
	
}
