/** 
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
import java.util.Scanner;

public class ExamResults {
    private static String subjects [] ;
    private static String marks [] ;
    public static void main(String[] args) throws Exception {
        calculateGrade () ;
    }

    private static void calculateGrade () throws Exception {
        try (Scanner scanner = new Scanner (System.in)) {
            subjects = scanner.nextLine().split("  ") ;
            marks = scanner.nextLine().split(" ") ;

            if (subjects.length != marks.length) {
                throw new InputMismatchException ("unexpected numebr of inputs") ;
            }

            printOutput () ;
        }
    }

    private static void printOutput() throws Exception {
        for (int i=0; i<subjects.length; i++) {
            int mark = Integer.valueOf(marks [i]) ;
            
            if (mark > 100 || mark < 0) {
                throw new IllegalArgumentException ("wrong input for marks") ;
            } 

            System.out.print(subjects [i] + " ") ;
            if (mark >= 75) {
                System.out.print ("A") ;
            } else if (mark >= 65) {
                System.out.print ("B") ;
            } else if (mark >= 55) {
                System.out.print ("C") ;
            } else if (mark >= 35) {
                System.out.print ("S") ;
            } else if (mark >= 0) {
                System.out.print ("F") ;
            } 
            System.out.println() ;
        }
    }
}