package de.derniklaas.adventofcode.day4;

public class Day4A {

    private static String input = "183564-657474";

    public static void main(String[] args) {
        int min = Integer.parseInt(input.split("-")[0]);
        int max = Integer.parseInt(input.split("-")[1]);

        int password = 0;
        for (int i = min; i < max; i++) {
            String digit = i + "";

            boolean doubles = false, decrease = false;
            char[] chars = digit.toCharArray();
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] < chars[j - 1]) {
                    decrease = true;
                }
                if (chars[j] == chars[j - 1]) {
                    doubles = true;
                }
            }
            if (doubles && !decrease) {
                password++;
            }
        }
        System.out.println("Amount of passwords: " + password);
    }
}
