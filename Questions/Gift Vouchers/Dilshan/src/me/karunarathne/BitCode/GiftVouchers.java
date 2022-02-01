/** 
 * Gift Vouchers
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

import java.util.Scanner;

public class GiftVouchers {
    private static Integer vouchers, total ;
    public static void main(String[] args) {
        promotion () ;
    }

    private static void promotion () {
        vouchers = 0 ; total = 0 ;

        try (Scanner scanner = new Scanner (System.in)) {
            while (true) {
                String rawInput = scanner.nextLine() ;
                if (rawInput.equalsIgnoreCase("e")) {
                    break ;
                }
                
                int price = Integer.valueOf(rawInput) ;
                if (price < 100000 && price > 0) {
                    total += price ;
                    addVouchers (price) ;
                }   
            }
        }

        printOutput () ;
    }

    private static void addVouchers (Integer rawInput) {
        if (rawInput >= 1000) vouchers ++ ;
        
        if (rawInput - 1000 >= 1000) {
            addVouchers (rawInput - 1000) ;
        }
    }

    private static void printOutput () {
        System.out.println ((vouchers > 0) ? "Yes" : "No") ;
        System.out.println (total) ;
        System.out.println (vouchers) ;
    }
}
