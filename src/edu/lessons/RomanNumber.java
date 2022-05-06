package edu.lessons;

import java.util.Scanner;

public class RomanNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите римское число:");
        String rome = in.nextLine();
        System.out.println("Arabian number " + romanToInt(rome));

    }

    public static int romanToInt(String s) {
        String[] roman = s.split("");
        int numberRoman = 0;
        String prev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            String symbol = roman[i];
            int plus = RomanSymbol.valueOf(symbol).getNumber();
            if (!prev.equals("") && RomanSymbol.valueOf(prev).getNumber() > RomanSymbol.valueOf(symbol).getNumber()) {
                numberRoman = numberRoman - plus;
            } else {
                numberRoman = numberRoman + plus;
            }
            prev = symbol;

        }
        return numberRoman;
    }
}

    enum RomanSymbol {

        I(1), V(5), X(10), L(50), C(100), D(500), M(1000), Z(0);

        private int number;

        RomanSymbol(int number) {

            this.number = number;
        }

        public int getNumber() {

            return number;
        }

    }