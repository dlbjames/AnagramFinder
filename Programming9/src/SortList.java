/* Darryl James
 * TCSS 143 - Spring 2019
 * Instructor: David Schuessler
 * Programming Assignment 8
 */

import java.util.*;

/**
 * Implements Comparator to sort the Word objects
 * in alphabetically descending order.
 * @author Darryl James dljames@uw.edu
 * @version 2 June 2019
 */
public class SortList implements Comparator<Word> {

    /**
     * Compares the Word objects in
     * alphabetically descending order.
     * @param theFirst - The word being compared to
     * @param theSecond - The word being compared with
     * @return which word is greater.
     */
    public int compare(Word theFirst, Word theSecond){
        return theSecond.getWord().compareTo(theFirst.getWord());
    }
}