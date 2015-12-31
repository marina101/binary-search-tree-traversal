import java.io.FileInputStream;
import java.io.*;
import java.util.*;
/**
 * This program reads in a textfile and creates a word collectio that keeps
 * track of how many times a word appears in the text.
 * @author Marina Chirchikova
 *
 */
public class WordCollection {
	private BST<String, Word> wordTree;
	Scanner inputStream = null;
	
	/**
	 * Constructor, starts a new WordCollection, reads a testfile, extracts
	 * all words (and removes punctuation), coverts the word to lower case, and 
	 * stores the word in a BST structure
	 * @param accepts a text file
	 * @throws FileNotFoundException if file is not found
	 */
	public WordCollection(String filename) throws FileNotFoundException{		
		try{
		inputStream = new Scanner(new FileInputStream(filename));
		wordTree = new BST<String, Word>();
		while(inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			String[] words = line.split("[�?’,!;. ]");
			for(int i = 0; i<words.length; i ++){ //for all the words in the line
				if(!(words[i]).equals("")){ //if not blank string
					String s = words[i].toLowerCase();
					Word already = wordTree.find(s);
					if (already != null)
						already.increment();
					else 
					{
						Word w = new Word(s);
						wordTree.insert(s, w);					
					}
				}
			}
		}
		
		}//try
		finally{
			inputStream.close();
		}
	}//end constructor
	
	/**
	 * Prints BST traversal in level order
	 */
	public void printLevelOrder(){
		wordTree.printLevelOrder();
	}
	
	/**
	 * prints BST preorder traversal
	 */
	public void printPreorder(){
		wordTree.nonRecursivePreorderTraverse();
	}
	/**
	 * prints BST in inorder traversal
	 */
	public void printInorder(){
		wordTree.nonRecursiveInorderTraverse();
	}
	
	/**
	 * Prints BST in postorder traversal
	 */
	public void printPostorder(){
		wordTree.nonRecursivePostorderTraverse();
	}
	
	/**
	 * Draws BST rotated 90 degrees counter clockwise
	 */
	public void draw(){
		wordTree.draw();
	}

}//end class

