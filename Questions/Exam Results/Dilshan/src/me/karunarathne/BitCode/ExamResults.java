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

public class ExamResults {
    public static void main(String[] args) {
        
    }

    private static void takeInput () {
        try (Scanner scanner = new Scanner (System.in)) {
            String subjects [] = scanner.nextLine().split("  ") ;
            int marks [] = Integer.valueOf(scanner.nextLine().split(" ")) ;
        }
    }
}