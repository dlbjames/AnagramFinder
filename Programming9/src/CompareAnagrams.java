/* Darryl James
 * TCSS 143 - Spring 2019
 * Instructor: David Schuessler
 * Programming Assignment 8
 */

import java.util.*;

/**
 * Compares the Anagram families
 * by their size.
 * @author Darryl James dljames@uw.edu
 * @version 2 June 2019
 */
public class CompareAnagrams implements Comparator<Anagrams> {

    /**
     * Compares the objects in the anagram families.
     * @param theCurrent - The current anagram family.
     * @param theOther - The anagram family to be compared.
     * @return which family is larger.
     */
    public int compare(Anagrams theCurrent, Anagrams theOther) {
        return theOther.getCount() - theCurrent.getCount();
    }
}
