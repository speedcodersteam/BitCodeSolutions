/**
 * <h1> Text </h1>
 * Shalika has an idea to create a computer program to distinguish a few specific words 
 * in a given sentence. Shalika gives you the following information about this. 
 * After giving the number of characters to start S and the number to end E, the relevant part 
 * should be printed. If the number of characters in the middle of a word starts or ends, 
 * that word must also be applied to the output.  
 * 
 * Question creadit goes to: 
 * BitCode V 3.0 
 * BITSA
 * Department of Information Systems, Faculty of Management,
 * Rajarata University of Sri Lanka
 *
 * Solution by:
 * @author  Dilshan M. Karunarathne
 * @version 1.0
 * @since   2022-01-31
 * 
 * https://github.com/dilshankarunarathne
 * http://karunarathne.me/
 * http://dilshan.cf/
 * https://twitter.com/karunarathne_wd
 * https://fb.com/dilshankarunarathn
 */

package me.karunarathne.BitCode;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Solution for Text problem.
 * Recommended to use Java 17 for this code.
 */
public class Text {

    private static ArrayList <Integer> starts;
    private static String paragraph ;

    /**
     * main method, used as a test stub for the program.
     * Call sliceText with true to get a user-friendly interface. Or false to optimize 
     * testing and output checking.
     * 
     * @param args  console arguments, not used in this module
     * @throws Exception propagated exceptions from called methods
     */
    public static void main(String[] args) throws Exception {
        sliceText (true) ;
    }

    /**
     * The method that handles calls to all the other functions, and this also takes care
     * of taking inputs. 
     * Used a try-with-resources block for the java.util.Scanner object. 
     * Throws any exception that's propagated from calling methods. 
     * 
     * @param enablePrompt If true, shows helping messages for input-output
     * @throws Exception propagated exceptions from called methods
     */
    private static void sliceText (boolean enablePrompt) throws Exception {
        try (Scanner scanner = new Scanner (System.in)) { 
            if (enablePrompt) System.out.print ("Enter the char range > ") ;
            
            String rangeStr[] = scanner.nextLine().split(" ") ;
            int start = Integer.parseInt(rangeStr[0]) ;
            int end = Integer.parseInt(rangeStr[1]) ;

            if (! checkInputRange (start, end)) {
                System.exit(0);
            }

            if (enablePrompt) System.out.print ("Enter the paragraph > ") ;
            paragraph = scanner.nextLine() ;

            starts = createTextIndex () ;

            printOutput (checkForStart(start), checkForStart (end), enablePrompt) ;
        }
    }

    /**
     * Used to print the sliced String. Use the enablePrompt boolean to switch 
     * between user-helping messages, or input-output testing optimization.
     * 
     * @param start specifies the real starting index of the first word of the slice
     * @param end   specifies the real starting index of the last word of the slice
     * @param enablePrompt  If true, shows helping messages for input-output
     */
    private static void printOutput(int start, int end, boolean enablePrompt) {
        if (enablePrompt) System.out.println ("Sliced text: \n") ;

        System.out.println(paragraph.substring(start, end)) ;
    }

    /**
     * Iterates through the starts list, and checks if it contains the given index. 
     * If there's no match, decreases the checking index and tries again. 
     * Returns the first character's index if it's found. Otherwise throws an exception.
     * 
     * @param start An integer that specifies the starting index of the slice
     * @return realStart   An integer that specifies the first character of the containing word
     * @throws Exception    if the containing word is not found
     */
    private static int checkForStart (int start) throws Exception {
        for (int i=start; i>0; i--) {
            if (starts.contains(i)) {
                return i ;
            } 
        }

        throw new Exception ("starting index was not found") ;
    }

    /**
     * Takes the input String for spaces, and add the next character's index to the
     * starts list, so it would contain the starting indexes of all the words. 
     * If the input String starts with a whitespace, throws an InputMismatchException .
     * 
     * @return starts   A list composed of the starting index of each word
     * @throws InputMismatchException   if the text starts with a space
     */
    private static ArrayList <Integer> createTextIndex() throws InputMismatchException {
        ArrayList <Integer> starts = new ArrayList <Integer> () ;

        if (paragraph.charAt(0) == ' ') {
            throw new InputMismatchException ("donot start the paragraph with a space") ;
        }
        starts.add(0) ;
        for (int i=0; i<paragraph.length(); i++) {
            if (paragraph.charAt(i) == ' ') {
                starts.add(i+1) ;
            }
        }

        return starts ;
    }

    /**
     * Checks the start and end integers to see if they falls within the given constains. 
     * If they are out of bounds, prints the relevent error messages. 
     * 
     * @param start The starting point of the slice
     * @param end   The ending point of the slice
     * @return inRange Boolean true if start-end are within the given constains
     */
    private static boolean checkInputRange (int start, int end) {
        if (start < 0) {
            System.out.println("Error: Start Number");
            return false ;
        }
        if (end < 5) {
            System.out.println("Error: End Number");
            return false ;
        }
        if (start > end) {
            System.out.println("Error: Range");
            return false ;
        }
        return true ;
    }
}