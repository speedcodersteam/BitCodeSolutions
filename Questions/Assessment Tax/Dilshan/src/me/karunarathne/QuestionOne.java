/**
 * <h1> Assessment Tax </h1>
 * A person living in a municipal area has paid Rs. 500 per quarter as assessment tax. 
 * If the rate of assessment tax levied by the Municipal Council in each year is A, 
 * What was the annual valuation of his house in those years?
 * 
 * Problem creadit goes to: 
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

package me.karunarathne ;

import java.util.InputMismatchException;
import java.util.Scanner ;

public class QuestionOne {
    
    /**
     * Main method, not using command-line arguments. Should throw exceptions as the user 
     * inputs an un-expected rate. Being generic about the exception. 
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println ( 
            "Annual valuation of the house is Rs: " +
            calculateTax( chekRange() ) 
        );
    }

    /**
     * Using this method to take input using java.util.Scanner
     * And check if the input matches a regular expression, to make sure it's a percentage.
     * Uses substring() method of String class, to slice the percentage character. 
     * If the input is not acceptable, throws an exception.
     * 
     * @exception InputMismatchException
     * @return uncheckedRate
     */
    public static float getNFormatInput () throws InputMismatchException {
        Scanner scanner = new Scanner (System.in);

        System.out.print ("\nEnter the tax rate > ");
        String input = scanner.nextLine();

        scanner.close();

        if (input.matches("\\d+(?:\\.\\d+)?%")) {
            return Float.valueOf(input.substring(0, input.length() - 1));
        } else {
            throw new InputMismatchException ("input does not look like a percentage") ;
        }
        
    }

    /**
     * Using this method to check if the float rate is in the given range.
     * 3% ≤ rate ≤ 10%
     * If not, throws an IllegalArgumentException. Method's throws declaration is generic
     * so it would throw both IllegalArgumentException and InputMismatchException.
     * 
     * @return taxRate
     * @throws Exception
     */
    public static float chekRange () throws Exception {
        float rate = getNFormatInput();

        if (rate <= 10.0 && rate >= 3.0) {
            return rate ;
        }
        throw new IllegalArgumentException ("rate is out of range") ;
    }

    /**
     * Using this method to calculate the annual valuation of the house.
     * Since the amount of tax he pay for three monts is Rs. 500
     * Annual tax amount should be Rs. 500 x 4 = Rs. 2000
     * Throws the exceptions that might have propagated to this method.
     * 
     * @param taxRate
     * @return annualValuation 
     * @throws Exception
     */
    public static float calculateTax (float rate) throws Exception {
        return (100/rate) * 2000 ;
    }
}