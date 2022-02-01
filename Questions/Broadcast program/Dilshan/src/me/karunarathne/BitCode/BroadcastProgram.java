/** 
 * <h1> Broadcast Program </h1>
 * The opportunity to apply for the official broadcast of the 2022 Cricket Games is 
 * available on TV channels. You have to bid through the channels and apply for it. 
 * The bid will be given 7 days and the most suitable TV channels will be given 
 * 4 main conditions in addition to the bid limit and separate points will be awarded 
 * for those conditions.
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
 * @since   2022-02-01
 * 
 * https://github.com/dilshankarunarathne
 * http://karunarathne.me/
 * http://dilshan.cf/
 * https://twitter.com/karunarathne_wd
 * https://fb.com/dilshankarunarathn
 */

package me.karunarathne.BitCode ;

import java.util.InputMismatchException;
import java.util.Scanner ;

/**
 * Solution for Broadcast Program problem.
 * Recommended to use Java 17 for this code.
 */
public class BroadcastProgram {

    /**
     * main method, used as a test stub for the program.
     * 
     * @param args not used
     * @throws Exception propagated exceptions from called methods
     */
    public static void main(String[] args) throws Exception {
        checkIfQualifies () ;
    }

    /**
     * Uses a try-with-resources block for the java.util.Scanner object. 
     * Takes input and splits the string to get individual inputs. Checks if the bit is within 
     * the given constraints, and if not, prints the relevent messages. 
     * Finally, calls the checkScore method and get the score, and prints the final output. 
     * 
     * @throws Exception propagated exceptions from called methods
     */
    private static void checkIfQualifies () throws Exception {
        try (Scanner scanner = new Scanner (System.in)) {
            String inputs [] = scanner.nextLine().split(" ") ;
            
            double bid = Double.valueOf(inputs [0]) ;
            if (bid < 2.0) {
                System.out.println("Rejected Bid value is low") ;
                return ;
            } else if (bid > 5.0) {
                throw new IllegalArgumentException ("bid is too high") ;
            }

            int score = checkScore (inputs [1]) ;
            if (score < 10) {
                System.out.println("Rejected Score below 10") ;
                return ;
            }

            System.out.println (score + "\nQualifies");
        } 

    }

    /**
     * This method is used to calculate the score for each channel, by taking the answers 
     * they gave for the set of conditions. The answer String should only contain four characters. 
     * If exceeds, throws an InputMismatchException .
     * 
     * @param answer String containing the answer for each condition
     * @return int score is the calculated score
     * @throws InputMismatchException if the answer string is longer than 4 characters
     */
    private static int checkScore(String answer) throws InputMismatchException {
        int score = 0 ;

        if (answer.length() != 4) {
            throw new InputMismatchException ("incorrect input") ;
        }
        if (answer.charAt(0) == 'y') {score += 8;} ;
        if (answer.charAt(1) == 'y') {score += 6;} ;
        if (answer.charAt(2) == 'y') {score += 2;} ;
        if (answer.charAt(3) == 'y') {score += 4;} ;

        return score ;
    }
    
}
