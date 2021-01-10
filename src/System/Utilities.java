package System;

public class Utilities {


    static boolean onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+"));
    }

    static boolean onlyContainsFullName(String text) {
        return (text.matches("[a-zA-Z]+\\s+[a-zA-Z]+"));
    }
    static boolean onlyContainsLetters(String text) {
        return (text.matches("[a-zA-Z]+"));
    }

    static String max30Chars(String string){
        return (string.length()<=30) ? string : string.substring(0,30);
    }

    static boolean validEmail(String email){
        return (email.contains("@") && email.contains("."));
    }

    static boolean validIntRange(int start, int end, int value){
        return ((value >= start) && (value <= end));
    }

    static boolean validIntNonNegative(int number)
    {
        return (number >=0);
    }
}
