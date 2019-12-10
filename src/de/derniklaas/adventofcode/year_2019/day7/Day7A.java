package de.derniklaas.adventofcode.year_2019.day7;

public class Day7A {

    //private static String input = "3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0";
    private static String input = "3,8,1001,8,10,8,105,1,0,0,21,34,51,64,73,98,179,260,341,422,99999,3,9,102,4,9,9,1001,9,4,9,4,9,99,3,9,1001,9,4,9,1002,9,3,9,1001,9,5,9,4,9,99,3,9,101,5,9,9,102,5,9,9,4,9,99,3,9,101,5,9,9,4,9,99,3,9,1002,9,5,9,1001,9,3,9,102,2,9,9,101,5,9,9,1002,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99";

    private static int min = 0, max = 5;

    public static void main(String[] args) {
        int maxOutput = 0;
        for (int a = min; a < max; a++) {
            for (int b = min; b < max; b++) {
                for (int c = min; c < max; c++) {
                    for (int d = min; d < max; d++) {
                        for (int e = min; e < max; e++) {
                            if (validInput(a, b, c, d, e)) {
                                int temp = getMax(a, b, c, d, e);
                                if (temp > maxOutput) {
                                    maxOutput = temp;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Max: " + maxOutput);
    }

    private static boolean validInput(int a, int b, int c, int d, int e) {
        if (a == b || a == c || a == d || a == e || b == c || b == d || b == e || c == d || c == e || d == e)
            return false;
        return true;
    }

    private static int getMax(int a, int b, int c, int d, int e) {
        IntcodeParser parser = new IntcodeParser(input, a, 0);
        int number = 0;
        number = parser.parseCode();
        parser = new IntcodeParser(input, b, number);
        number = parser.parseCode();
        parser = new IntcodeParser(input, c, number);
        number = parser.parseCode();
        parser = new IntcodeParser(input, d, number);
        number = parser.parseCode();
        parser = new IntcodeParser(input, e, number);
        return parser.parseCode();
    }
}
