import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

/**
 * This program sets up the Binary Search Tree structure.
 * @author Marina Chirchikova
 *
 * @param <Key> the word in string form
 * @param <E> the Word object of that word, keeps track of the string and the number of times it is in collection
 */
public class BST<Key extends Comparable<? super Key>, E> implements Dictionary<Key, E>{
	BSTNode<Key, E> root; 
	int nodecount;
	
	//constructor
	public BST() { 
		root = null; nodecount = 0; 
	}
	
	/** Reinitialize tree */
	  public void clear() { 
		  root = null; nodecount = 0;
	}
	 
	 
	  
	/** Insert a record into the tree.
	  @param k Key value of the record.
	  @param e The record to insert. */
	  public void insert(Key k, E e) {
	    root = inserthelp(root, k, e);
	    nodecount++;
	  }
	  
	  /** Remove a record from the tree.
	      @param k Key value of record to remove.
	      @return The record removed, null if there is none. */
	  public E remove(Key k) {
	    E temp = findhelp(root, k);   // First find it
	    if (temp != null) {
	      root = removehelp(root, k); // Now remove it
	      nodecount--;
	    }
	    return temp;
	  }
	  
	  /** Remove and return the root node from the dictionary.
	      @return The record removed, null if tree is empty. */
	  public E removeAny() {
	    if (root == null) return null;
	    E temp = root.element();
	    root = removehelp(root, root.key());
	    nodecount--;
	    return temp;
	}
	  
	  /** @return Record with key value k, null if none exist.
	      @param k The key value to find. */
	  public E find(Key k) { 
		  return findhelp(root, k); 
	}
	  
	  /** @return The number of records in the dictionary. */
	  public int size() {
		  return nodecount;
	   }
	
	  /**
	   * Level-order Traversal: prints a breadth-first traversal of BST
	   */
	  
	  public void printLevelOrder(){
		  //queue will keep track children of each node as we go through the levels
		  Queue<BSTNode<Key, E>> q = new LinkedList<BSTNode<Key, E>>();
			
			if(root==null) return;
			q.add(root);
			while(!(q.isEmpty())){
				
				
					BSTNode<Key, E> n = q.remove();
					System.out.println(" " + n.element());
					if(n.left() != null) q.add(n.left());
					if(n.right() != null) q.add(n.right());
				
				}
			}

	  /**
	   * Preorder Traversal: prints a depth-first iterative preorder traversal of BST
	   */
	  public void nonRecursivePreorderTraverse(){
		//uses stack to keep track of children elements
		  Deque<BSTNode<Key, E>> s = new LinkedList<BSTNode<Key, E>>();
		  
		 if(root==null) return;
		 s.push(root);
		 while(!s.isEmpty()){ 
			 BSTNode<Key, E> n = s.pop();
			 
			 printVisit(n.element());
			 if(n.right() != null)
				 s.push(n.right()); 
			 if(n.left() != null)
				 s.push(n.left());
			 
		 
		  }
		  
	  }
	 
	  /**
	   * Inorder Traversal: prints a depth-first iterative inorder traversal of BST
	   */
	  public void nonRecursiveInorderTraverse(){
		  Deque<BSTNode<Key, E>> s = new LinkedList<BSTNode<Key, E>>();
		  BSTNode<Key, E> n = root;
		  boolean done = false;
		  while(!done){
			  //go to the very leftmost child nodes in tree, while using stack to keep track
			  if(n != null){
				s.push(n); 
				n = n.left();
			  }
			  else{
				  if(!s.isEmpty()){
					  n = s.pop();
					  printVisit(n.element());
					  n = n.right();  //now visiting right subtree
				  }
				  else
					  done = true;
			  }
		  }
	  }
	  
	  /**
	   * Postorder Traversal: prints a depth-first iterative post traversal of BST
	   * Uses two stacks to keep track of nodes
	   */
	  public void nonRecursivePostorderTraverse(){
		  Deque<BSTNode<Key, E>> s1 = new LinkedList<BSTNode<Key, E>>();
		  Deque<BSTNode<Key, E>> s2 = new LinkedList<BSTNode<Key, E>>();
		  
		  s1.push(root);
		  BSTNode<Key, E> n;
		  while(!s1.isEmpty()){
			  
			//pop item from first stack and push it to second stack
			  n = s1.pop();
			  s2.push(n);
			  //push the left and right children of item to first stack
			  if(n.left() != null)
				  s1.push(n.left());
			  if(n.right() != null)
				  s1.push(n.right());
		  }
		  //print contents of second stack
		  while(!s2.isEmpty()){
			  n=s2.pop();
			  printVisit(n.element());
		  }
	  
	  }
	  
	  /**
	   * Uses recursion to draw the BST rotated 90 degrees counter clockwise
	   */
	  public void draw(){
		  drawHelp(root, 0);
	  }
	  
	
	  private void drawHelp(BSTNode<Key,E> rt, int d){

		  if (rt == null){
			  return;
		  }
		  drawHelp(rt.right(), d+1);		  
		  for(int i = 0; i < d; i++){
			  System.out.print("   |");
		  }
		  printVisit(rt.element());
		  drawHelp(rt.left(), d+1);
		  
		  
		  
	  }
	  
	  
	  
	  //prints the value of root element
	  public String toString(){
		  return root.element().toString();
	  }
	  
	  //private methods
	  
	  //returns the current subtree, modified to contain the new item
	  private BSTNode<Key,E> inserthelp(BSTNode<Key,E> rt, Key k, E e) {
		  if (rt == null) return new BSTNode<Key,E>(k, e);
		  if (rt.key().compareTo(k) > 0)
			  rt.setLeft(inserthelp(rt.left(), k, e));
		  else 
			  rt.setRight(inserthelp(rt.right(), k, e));
		  
		  return rt;
	  }
	  
	  private BSTNode<Key,E> deletemin(BSTNode<Key,E> rt) {
		  if (rt.left() == null) return rt.right();
		  rt.setLeft(deletemin(rt.left()));
		  return rt;
		}
	  
	  private BSTNode<Key,E> getmin(BSTNode<Key,E> rt) {
		  if (rt.left() == null) return rt;
		  return getmin(rt.left());
		}
	  
	  //returns the tree with node removed
	  private BSTNode<Key,E> removehelp(BSTNode<Key,E> rt,Key k) {
		  if (rt == null) return null;
		  if (rt.key().compareTo(k) > 0)
		    rt.setLeft(removehelp(rt.left(), k));
		  else if (rt.key().compareTo(k) < 0)
		    rt.setRight(removehelp(rt.right(), k));
		  else { // Found it
		    if (rt.left() == null) return rt.right();
		    else if (rt.right() == null) return rt.left();
		    else { // Two children
		      BSTNode<Key,E> temp = getmin(rt.right());
		      rt.setElement(temp.element());
		      rt.setKey(temp.key());
		      rt.setRight(deletemin(rt.right()));
		    }
		    }
		return rt;
		}
	  

	  private E findhelp(BSTNode<Key,E> rt, Key k) {
		  if (rt == null) return null;
		  if (rt.key().compareTo(k) > 0)
			  return findhelp(rt.left(), k);
		  else if (rt.key().compareTo(k) == 0) return rt.element();
		  else return findhelp(rt.right(), k);
}
	  
	  private void printhelp(BSTNode<Key,E> rt) {
		    if (rt == null) return;
		    printhelp(rt.left());
		    printVisit(rt.element());
		    printhelp(rt.right());
		}
	  
	  private void printVisit(E it){
		  
		  System.out.println(" " + it);
	  }
	  
	 
	  
}//end of class
