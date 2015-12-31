import java.io.*;
/**
 * This is the driver program - it creates a word collection object,
 * gives it a text file, and then prints the traversals of the resulting
 * BST in inorder, levelorder, preorder, and postorder formats. It then
 * also prints a picture of that BST rotated 90 degrees counter clockwise.
 * @author Marina Chirchikova
 *
 */
public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		WordCollection wordCollection = new WordCollection("seuss.txt");
		
		System.out.println("---------------prinInorder()------------");
		wordCollection.printInorder();
		
		System.out.println("---------------printLevelOrder()------------");
		wordCollection.printLevelOrder();
		
		System.out.println("---------------printPreorder()------------");
		wordCollection.printPreorder();
		
		System.out.println("---------------printPostorder()-------------");
		wordCollection.printPostorder();
		
		System.out.println("---------------draw()-------------");
		wordCollection.draw();
		
	}

}
