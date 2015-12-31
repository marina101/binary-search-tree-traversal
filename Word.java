/**
 * This program sets up a word object that keeps track of a word 
 * and the number of times the word appears in a collection.
 * @author Marina Chirchikova
 *
 */
public class Word implements Comparable<Word>{
	private String word;
	private int wordCount;
	
	/**
	 * Constructor
	 * @param word
	 */
	public Word(String w){
		word = w;
		wordCount = 1;
	}
	
	/**
	 * Getter method
	 * @return word
	 */
	public String getWord(){
		return word;
	}
	
	/**
	 * Getter method
	 * @return wordcount
	 */
	public int getCount(){
		return wordCount;
	}
	
	/**
	 * increments wordcount by 1
	 */
	public void increment(){
		wordCount += 1;
	}
	
	/**
	 * Returns string of word object
	 */
	public String toString(){
		return (word + " " + wordCount);
	}
	
	/**
	 * Compares word to another word object, returns true if they 
	 * have same word string
	 */
	public boolean equals(Object obj){
		Word temp = (Word)obj;
		return (this.word).equals(temp.word);
	}
	
	/**
	 * Compares lexicographic value of one word with another, returns -1
	 * if first word is smaller than second, 0 if they are equal, and 1
	 * if the first word is bigger than the second
	 */
	public int compareTo(Word w){
		if (word.equals(w))
			return 0;
		else{ if(word.compareTo(w.word) == -1)
				return -1;
			else
				return 1;
		}
	}
			
			
		
	

}//end of class
