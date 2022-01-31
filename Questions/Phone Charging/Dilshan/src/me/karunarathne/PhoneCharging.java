/**
 * <h1> Phone Charging </h1>
 * Saman hopes to create a simple product that calculates 
 * how long it will take to charge the amount of battery available in any phone. 
 * This is an app that allows you to find out the current battery capacity percentage 
 * of the phone, the number of years the mobile phone has been used 
 * and the time it takes to charge the charger after entering it. 
 * Create the program needed to complete the software.
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

package me.karunarathne ;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Solution for the <b> Phone Charging </b> problem. This is the only class of the 
 * solution package. Only uses static methods.  
 */
public class PhoneCharging {
    public static void main(String[] args) throws Exception {
        System.out.println(
            "\nTime to charge is " +
            getTime (timeToCharge () )
        );
    }

    /**
     * This method is used to convert the given, time-as-minutes into time as 
     * hours-and-minutes. 
     * 
     * @param minutes
     * @return timeInHoursAndMinutes
     */
    public static String getTime (int minutes) {
        if (minutes == 60) {
            return "an hour." ;
        } else if (minutes < 60) {
            return Integer.toString(minutes) + " minutes." ;
        } else {
            return Integer.toString(minutes/60) + " hours and " + 
            Integer.toString(minutes % 60) + " minutes." ;
        }
    }

    /**
     * This method handles taking all the console inputs, and passing them over to 
     * their relevent methods, for checking and parsing. It does some checks by itself. 
     * Uses a try-with-resources block for the java.util.Scanner object. 
     * It calls the calculate method with the parsed inputs, and returns the result 
     * directly to the caller, total time - as minutes.
     * Throws a generic Exception, if any was propagated. 
     * 
     * @return timeInMinutes
     * @throws Exception
     */
    public static int timeToCharge () throws Exception {
        float battery; int years; float voltage;

        try (Scanner scanner = new Scanner (System.in)) {
            System.out.print("\nCurrent battery capacity > ");
            battery = takeBattery (scanner.nextLine()) ;
            if (battery < 0.0 || battery > 100.0) {
                throw new IllegalArgumentException ("battery percentage is out of range") ; 
            }
            
            System.out.print("Years of use > ");
            years = takeYears (scanner.nextLine()) ;
    
            System.out.print("Voltage > ");
            voltage = takeVoltage (scanner.nextLine()) ;
            if (voltage != 1.0 && voltage != 1.5) {
                System.out.println("Voltage : " + voltage);
                throw new IllegalArgumentException ("voltage is out of range") ; 
            }
        } 

        return calculate (battery, years, voltage) ;
    }

    /**
     * The number of hours depends on the 3 methods used.
     * Calling each of those methods, and adding up all the minutes (as integer), 
     * and returning the result. 
     * 
     * @param battery
     * @param years
     * @param voltage
     * @return minutesToCharge
     */
    public static int calculate (float battery, int years, float voltage) {
        return doBattery (battery) + doUsedYears (years) + doVoltage (voltage);
    }

    /**
     * If the voltage V is 1, it is called 1 hour 
     * and if the voltage is 1.5, it is stated as half an hour. 
     * 
     * @param voltage
     * @return minutesForVoltage
     */
    private static int doVoltage(float voltage) {
        if (voltage == 1.0 ) {
            return 60 ;
        } 
        return 30 ;
    }

    /**
     * If the year of use of the phone Y is more than 2 years, 
     * one hour should be entered and if it is less than 30 minutes.
     * 
     * @param years
     * @return minutesForUsedYears
     */
    private static int doUsedYears(int years) {
        if (years > 2) {
            return 60 ;
        }
        return 30 ;
    }

    /**
     * If the current capacity of the battery C is less than 40% 
     * then 2 hours should be added to any phone. 40% -60% names take 1 hours. 
     * 60% -100% is 30 minutes.
     * 
     * @param battery
     * @return minutesForBattery
     */
    private static int doBattery (float battery) {
        if (battery < 40.0) {
            return 120 ;
        } else if (battery < 60.0) {
            return 60 ;
        } else {
            return 30;
        }
    }

    /**
     * Using this method to take the voltage as input. It uses two regular expressions, 
     *      ^(1)\s?(v|V)?\s*$       for 1 V
     *      ^(1.5)\s?(v|V)?\s*$     for 1.5 V
     * Returns the float, and if the input does not match either of regular expressions, 
     * throws an InputMismatchException .
     * 
     * @param voltageString
     * @return voltage
     * @throws InputMismatchException
     */
    public static float takeVoltage (String voltageString) throws InputMismatchException {
        if (voltageString.matches("^(1)\\s?(v|V)?\\s*$")) {   // integer \d{1}\s?(v|V)?\s*$
            return  (float) 1.0 ;
        } else if (voltageString.matches("^(1.5)\\s?(v|V)?\\s*$")) { // float ^\d{1}(.){1}\d{1}\s?(v|V)?\s*$
            return  (float) 1.5 ;
        }

        throw new InputMismatchException ("input does not look like a number of voltage") ;
    }

    /**
     * This method is used to take the number of years (the phone was used) as input. 
     * Supports the word <i>YEARS</i> to be entered in any case (acceptable). 
     * Also can take spaces and without spaces, or just the number as the input. 
     * Uses the regular expression 
     *          ^\d{1}( )?(years|Years|year|Year|YEAR)*\s*$
     * to check all those formats, and picks apart the first character of the input 
     * string, cause that would be the number of years.
     * Returns it as int. If the input doesn't match, throws an 
     * InputMismatchException .
     * 
     * @param usedYears
     * @return years
     * @throws InputMismatchException
     */
    public static int takeYears (String usedYears) throws InputMismatchException {
        if (usedYears.matches("^\\d{1}( )?(years|Years|year|Year|YEAR)*\\s*$")) {
            try {
                return Integer.valueOf(usedYears.charAt(0)) ;
            } catch (StringIndexOutOfBoundsException e) {
                throw new InputMismatchException ("input does not contain a number") ;
            }
        } 

        throw new InputMismatchException ("input does not look like number of years") ;
    }

    /**
     * Checking the taken String input for battery capacity. These three regular 
     * expressions will check the string for 
     * 1% - 9%          ^(\d){1}( )?(%)?(\s)*$
     * 10% - 99%        ^(\d){2}( )?(%)?(\s)*$
     * 100%             ^(100)( )?(%)?(\s)*$
     * They will also alow multiple formats of input, such as
     *      16      16%     16 %
     * Then this method will slice and cast them into float datatype and returns to
     * the caller. If none of the regular expressions match with the input, we 
     * will throw an InputMismatchException .
     * 
     * @param capacity
     * @return capacityAsFloat
     * @throws InputMismatchException
     */
    public static float takeBattery (String capacity) throws InputMismatchException {
        if (capacity.matches("^(\\d){1}( )?(%)?(\\s)*$")) {     // # %
            return  Float.valueOf(capacity.substring(0, 1));
        } else if (capacity.matches("^(\\d){2}( )?(%)?(\\s)*$")) {  // ## %
            return  Float.valueOf(capacity.substring(0, 2));
        } else if (capacity.matches("^(100)( )?(%)?(\\s)*$")) {       // 100 %
            return 100 ;
        }
        
        throw new InputMismatchException ("input does not look like a percentage") ;
    }
}