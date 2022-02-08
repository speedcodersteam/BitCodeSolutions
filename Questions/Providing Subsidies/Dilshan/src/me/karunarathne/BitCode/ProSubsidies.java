
package me.karunarathne.BitCode ;

import java.util.ArrayList;
import java.util.Scanner;

public class ProSubsidies {
    private static ArrayList <String> info ;
    public static void main(String[] args) {
        
    }

    private static void doThatThang () {
        info = new ArrayList <String> () ;
    }

    private static void takeInput () {
        try (Scanner scanner = new Scanner (System.in)) {
            String input = scanner.nextLine() ;
            if (input.equalsIgnoreCase("e")) {
                return ;
            }

            info.add(input) ;
        }
    }
}
