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
 * @since   2022-01-30
 * 
 * https://github.com/dilshankarunarathne
 * http://karunarathne.me/
 * http://dilshan.cf/
 * https://twitter.com/karunarathne_wd
 * https://fb.com/dilshankarunarathn
 */

package me.karunarathne;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Text {

    private static ArrayList <Integer> starts;
    private static String paragraph ;
    public static void main(String[] args) throws Exception {
        sliceText (false) ;
    }

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

    private static void printOutput(int start, int end, boolean enablePrompt) {
        if (enablePrompt) System.out.println ("Sliced text: \n") ;

        System.out.println(paragraph.substring(start, end)) ;
    }

    // private static int checkForEnd (int end) throws Exception {
    //     boolean found = false ;
    //     for (int i=end; i<starts.size(); i++) {
    //         if (starts.contains(i)) {
    //             found = true ;
    //             return i ;
    //         }
    //     }
    //     if (found == false) {
    //         return paragraph.length() ;
    //     }

    //     throw new Exception ("ending index was not found") ;
    // }

    private static int checkForStart (int start) throws Exception {
        for (int i=start; i>0; i--) {
            if (starts.contains(i)) {
                return i ;
            } 
        }

        throw new Exception ("starting index was not found") ;
    }

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