/** 
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

import java.util.Scanner ;

public class BroadcastProgram {

    public static void main(String[] args) {
        
    }

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

            if (! checkScore (inputs [1])) {
                System.out.println("Rejected Score below 10") ;
                return ;
            }
        } 

    }

    private static boolean checkScore(String answer) throws IllegalArgumentException {
        int score = 0 ;

        if (answer.length() != 4) {
            throw new IllegalArgumentException ("incorrect input") ;
        }
        if (answer.charAt(0) == 'y') {score += 8;} ;
        if (answer.charAt(1) == 'y') {score += 6;} ;
        if (answer.charAt(2) == 'y') {score += 2;} ;
        if (answer.charAt(3) == 'y') {score += 4;} ;

        if (score >= 10) {
            return true ;
        }
        return false ;
    }
    
}
