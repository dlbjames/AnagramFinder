/* Darryl James
 * TCSS 143 - Spring 2019
 * Instructor: David Schuessler
 * Programming Assignment 8
 */

import java.util.*;

/**
 * An object class consisting of a List of
 * word objects and their canonical forms.
 * @author Darryl James dljames@uw.edu
 * @version 2 June 2019
 */
public class Anagrams {

    /** Used to hold the list of words. */
    private LinkedList<Word> myList;
    /** Used to hold the number of items in the list. */
    private int myCounter;

    /**
     * Takes the sorted anagram family and adds the elements
     * into the myList field which is then sorted, while
     * counting the number of words within the list.
     * @param theWords - The list of words
     */
    public Anagrams (List<Word> theWords) {
        myCounter = 0;
        myList = new LinkedList<Word>();
        ListIterator<Word> itr = theWords.listIterator();
        while(itr.hasNext()) {
            myList.add(itr.next());
            myCounter++;
        }
        Collections.sort(myList, new SortList());
    }

    /**
     * Returns the number of words in the list.
     * @return the number of words in the list.
     */
    public int getCount() {
        return myCounter;
    }

    /**
     * Get the canonical version of the list of families.
     * @return the canonical version of the list of families.
     */
    public String getCanonical(){
        String res = "";
        if(!myList.isEmpty()) {
            res = myList.get(0).getCanonical();
        }
        return res;
    }
    /**
     * Returns the list of word objects
     * in their original forms.
     * @return the list of words
     */
    public String toString() {
        return myList.toString();
    }
}
