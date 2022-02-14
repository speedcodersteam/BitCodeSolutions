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
 * @since   2022-02-14
 * 
 * https://github.com/dilshankarunarathne
 * http://karunarathne.me/
 * http://dilshan.cf/
 * https://twitter.com/DilshanKarunar8
 * https://fb.com/dilshankarunarathn
 */

package me.karunarathne.BitCode ;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ABC {
    private static ArrayList <String> inputs ;
    public static void main(String[] args) {
        try {
            humanResources () ;
        } catch (InputMismatchException e) {
            System.out.println ("Error: Incorrect input format") ;
        } 
    }

    private static void humanResources () throws InputMismatchException {
        inputs = new ArrayList <String> () ;
        try (Scanner scanner = new Scanner (System.in)) {
                while (true) {
                String input = scanner.nextLine() ;
                if (input.equalsIgnoreCase("e")) {
                    break ;
                }
                inputs.add(input) ;
            }
        }
        calculate () ;
    }

    private static void calculate () throws InputMismatchException {
        for (String s: inputs) {
            String easy [] = s.split(" ") ;
            int u = Integer.valueOf(easy [0]) ; int h = Integer.valueOf(easy [1]) ;
            checkInput (u, h) ;
            
            System.out.println (
                (u % h != 0) ? (String.format("%.2f", (Double.valueOf(u) / Double.valueOf(h)))) : (u/h)
            ) ;
        }        
    }

    private static void checkInput(int u, int h) throws InputMismatchException {
        if ((u < 1 || u > 1000) || (h < 2 || h > 8) ){
            throw new InputMismatchException ("incorrect input for u-h") ;
        }
    }
}
