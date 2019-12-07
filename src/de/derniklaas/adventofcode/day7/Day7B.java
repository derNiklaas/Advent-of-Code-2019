package de.derniklaas.adventofcode.day7;

public class Day7B {
    //private static String input = "3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5";
    private static String input = "3,8,1001,8,10,8,105,1,0,0,21,34,51,64,73,98,179,260,341,422,99999,3,9,102,4,9,9,1001,9,4,9,4,9,99,3,9,1001,9,4,9,1002,9,3,9,1001,9,5,9,4,9,99,3,9,101,5,9,9,102,5,9,9,4,9,99,3,9,101,5,9,9,4,9,99,3,9,1002,9,5,9,1001,9,3,9,102,2,9,9,101,5,9,9,1002,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99";

    // private static String input = "3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10";

    private static int min = 5, max = 10;

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
        int number = 0;
        int max = 0;
        IntcodeParser parser = new IntcodeParser(input, a, 0);
        number = parser.parseCode();
        IntcodeParser parser2 = new IntcodeParser(input, b, number);
        number = parser2.parseCode();
        IntcodeParser parser3 = new IntcodeParser(input, c, number);
        number = parser3.parseCode();
        IntcodeParser parser4 = new IntcodeParser(input, d, number);
        number = parser4.parseCode();
        IntcodeParser parser5 = new IntcodeParser(input, e, number);
        number = parser5.parseCode();
        parser.changeSecondInput(number);
        while (!parser5.hasStopped()) {
            number = parser.parseCode();
            parser2.changeSecondInput(number);
            number = parser2.parseCode();
            parser3.changeSecondInput(number);
            number = parser3.parseCode();
            parser4.changeSecondInput(number);
            number = parser4.parseCode();
            parser5.changeSecondInput(number);
            number = parser5.parseCode();
            parser.changeSecondInput(number);
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
