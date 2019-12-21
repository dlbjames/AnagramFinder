/* Darryl James
 * TCSS 143 - Spring 2019
 * Instructor: David Schuessler
 * Programming Assignment 8
 */

import java.util.*;
import java.io.*;

/**
 * Prints the 5 largest anagram families
 * and those with a length of 8.
 * @author Darryl James dljames@uw.edu
 * @version 2 June 2019
 */
public class Driver9 {

    /**
     * Driver method of the program.
     * @param theArgs, command-line argument
     */
    public static void main(String[] theArgs) {
        Scanner input = null;
        PrintStream output = null;
        //Keeps track of the time to run//
        long start = System.currentTimeMillis();

        try {
            input = new Scanner(new File("words.txt"));
            output = new PrintStream(new File("out9.txt"));
        } catch (Exception theE){
            throw new IllegalArgumentException("Can not open " + theE);
        }

        LinkedList<Word> words = new LinkedList<>();
        while(input.hasNext()) {
            words.add(new Word(input.next()));
        }
        Collections.sort(words);

        LinkedList<Anagrams> anagrams = new LinkedList<Anagrams>();
        LinkedList<Word> wordList = new LinkedList<Word>();
        ListIterator<Word> itr = words.listIterator();
        while(itr.hasNext()) {
            Word aWord = itr.next();
            wordList.add(aWord);
            if (itr.hasNext()) {
                getAnagrams(wordList, itr, aWord);
            }
            Collections.sort(wordList, new SortList());
            anagrams.add(new Anagrams(wordList));
            wordList.clear();
        }
        Collections.sort(anagrams, new CompareAnagrams());

        LargestFive(anagrams, output);
        LengthEight(anagrams, output);
        output.println("The Last Family: ");
        output.println("Size: " + anagrams.get(
                                  anagrams.size() - 1).getCount());
        output.println("Canonical: " + anagrams.get(
                                       anagrams.size() - 1)
                                       .getCanonical());
        output.println(anagrams.get(anagrams.size() - 1));

        //Keeps track of the time to run//
        long end = System.currentTimeMillis();
        System.out.println("Time to run: " + (end - start));

        input.close();
        output.close();
    }

    /**
     * Gets the Anagram family for a word and adds it to a list.
     * @param theWords - The family of anagrams for a word.
     * @param theItr - A list iterator for the anagrams.
     * @param theLast - The previous word to be accessed.
     */
    private static void getAnagrams(List<Word> theWords,
                                   ListIterator<Word> theItr,
                                   Word theLast) {
        Word aWord = theItr.next();
        if (theLast.compareTo(aWord) == 0) {
            theWords.add(aWord);
            if (theItr.hasNext()) {
                getAnagrams(theWords, theItr, aWord);
            }
        } else {
            theItr.previous();
        }
    }

    /**
     * Prints the largest 5 families from the
     * input file to the output file.
     * @param theList - The list of anagram families.
     * @param theOutput - The output file.
     */
    private static void LargestFive(List<Anagrams> theList,
                                   PrintStream theOutput) {
        theOutput.println("The 5 largest families: ");
        for (int i = 0; i < 5; i++) {
            theOutput.println("Canonical: " +
                              theList.get(i).getCanonical());
            theOutput.println("Size: " + theList.get(i).getCount());
            theOutput.println(theList.get(i));
            theOutput.println();
        }
        theOutput.println();
    }

    /**
     * Prints all families that have a length of 8.
     * @param theList - The List of anagram families.
     * @param theOutput - The output file.
     */
    private static void LengthEight(List<Anagrams> theList,
                                   PrintStream theOutput) {
        theOutput.println("Families of length 8: ");
        for(Anagrams el: theList) {
            if (el.getCount() == 8) {
                theOutput.println("Canonical: " + el.getCanonical());
                theOutput.println(el);
                theOutput.println();
            }
        }
        theOutput.println();
    }
}