
package me.karunarathne.BitCode ;

import java.util.ArrayList;
import java.util.Scanner;

public class ProSubsidies {
    private static ArrayList <String> info ;
    public static void main(String[] args) {
        doThatThang ();
    }

    private static void doThatThang () {
        info = new ArrayList <String> () ;
        takeInput();

        for (String in: info) {
            calculate (in) ;
        }
    }

    private static void calculate (String answer) {
        if (answer.length() != 5) {
            System.out.println();
            return ;
        } else if (answer.charAt(0) == 'O') {
            System.out.println("No Subsidies");
        }

        int amount = 1000 ;
        for (int i=1; i<5; i++) {
            if (answer.charAt(i) == 'X') {
                amount += 1000 ;
            } else if (answer.charAt(i) == 'O') {
                // dc
            } else {
                System.out.println();
                return ;
            }
        }
        System.out.println("Rs " + amount + ".00");
    }

    private static void takeInput () {
        try (Scanner scanner = new Scanner (System.in)) {
            while (true) {
                String input = scanner.nextLine() ;
                if (input.equalsIgnoreCase("e")) {
                    break ;
                }

                info.add(input) ;
            }
        }
    }
}
