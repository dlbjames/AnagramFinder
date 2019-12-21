/* Darryl James
 * TCSS 143 - Spring 2019
 * Instructor: David Schuessler
 * Programming Assignment 8
 */

import java.util.*;

/**
 * Implements comparable to compare the words in the string of
 * characters in alphabetical order using merge sort.
 * @author Darryl James dljames@uw.edu
 * @version 2 June 2019
 */
public class Word implements Comparable<Word> {

    /** Used to hold original word. */
    private String myWord;
    /** Used to hold the canonical version of the word.*/
    private String myCanonical;

    /**
     * The Word constructor holds the original word
     * and the canonical version in their respective
     * variables.
     * @param theWord - The original word to be used.
     */
    public Word (String theWord) {
        myWord = theWord;
        char[] characters = theWord.toCharArray();
        canonical(characters);
        myCanonical = new String(characters);
    }

    /**
     * Gets the orignal word.
     * @return the original word.
     */
    public String getWord(){
        return myWord;
    }

    /**
     * Gets the canonical version of the word.
     * @return the canonical version of the word.
     */
    public String getCanonical() {
        return myCanonical;
    }

    /**
     * Turns the original word into the canonical version
     * ordered alphabetically.
     * @param theChar - Array of characters from the original word.
     */
    private  void canonical(char[] theChar) {
        if (theChar.length > 1) {
            char[] leftSide = Arrays.copyOfRange(theChar,
                                       0,
                                         theChar.length / 2);
            char[] rightSide = Arrays.copyOfRange(theChar,
                                        theChar.length / 2,
                                              theChar.length);
            canonical(leftSide);
            canonical(rightSide);
            merge(theChar, leftSide, rightSide);
        }

    }

    /**
     * Uses the merge sort algorithm to put the two
     * halves of the char array into sorted order.
     * @param theResult - The array of the right and left halves.
     * @param theLeft - The left half of the array.
     * @param theRight - The right half of the array.
     */
    private final void merge(char[] theResult,
                             char[] theLeft,
                             char[] theRight) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < theResult.length; i++) {
            if(i2 >= theRight.length || (i1 < theLeft.length &&
                theLeft[i1] <= theRight[i2])) {
                theResult[i] = theLeft[i1];
                i1++;
            } else {
                theResult[i] = theRight[i2];
                i2++;
            }
        }
    }

    /**
     * Compares two objects together for sorting.
     * @param theOther - The word to be compared.
     * @return Which form should go first.
     */
    public int compareTo(Word theOther) {
        return myCanonical.compareTo(theOther.getCanonical());
    }

    /**
     * Returns the original word.
     * @return the original word.
     */
    public String toString() {
        return myWord;
    }
}
