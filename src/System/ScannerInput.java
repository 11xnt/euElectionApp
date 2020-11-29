package System;

import java.util.Scanner;

public class ScannerInput {
    public static int readNextInt(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        } while (true);
    }

    public static String readNextString(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try {
                System.out.print(prompt);
                return scanner.nextLine();
            } catch (NumberFormatException e) {
                System.err.println("\tEnter a String please.");
            }
        } while (true);
    }

    public static double readNextDouble(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try{
                System.out.print(prompt);
                return Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

}