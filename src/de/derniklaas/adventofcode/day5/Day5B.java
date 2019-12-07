package de.derniklaas.adventofcode.day5;

import java.util.Scanner;

public class Day5B {

    private static String input = "3,225,1,225,6,6,1100,1,238,225,104,0,1002,43,69,224,101,-483,224,224,4,224,1002,223,8,223,1001,224,5,224,1,224,223,223,1101,67,60,225,1102,5,59,225,1101,7,16,225,1102,49,72,225,101,93,39,224,101,-98,224,224,4,224,102,8,223,223,1001,224,6,224,1,224,223,223,1102,35,82,225,2,166,36,224,101,-4260,224,224,4,224,102,8,223,223,101,5,224,224,1,223,224,223,102,66,48,224,1001,224,-4752,224,4,224,102,8,223,223,1001,224,2,224,1,223,224,223,1001,73,20,224,1001,224,-55,224,4,224,102,8,223,223,101,7,224,224,1,223,224,223,1102,18,41,224,1001,224,-738,224,4,224,102,8,223,223,101,6,224,224,1,224,223,223,1101,68,71,225,1102,5,66,225,1101,27,5,225,1101,54,63,224,1001,224,-117,224,4,224,102,8,223,223,1001,224,2,224,1,223,224,223,1,170,174,224,101,-71,224,224,4,224,1002,223,8,223,1001,224,4,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1007,226,226,224,1002,223,2,223,1006,224,329,1001,223,1,223,1007,226,677,224,102,2,223,223,1006,224,344,1001,223,1,223,108,677,677,224,102,2,223,223,1005,224,359,1001,223,1,223,1007,677,677,224,1002,223,2,223,1006,224,374,101,1,223,223,8,677,226,224,1002,223,2,223,1006,224,389,101,1,223,223,7,226,226,224,1002,223,2,223,1005,224,404,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,419,1001,223,1,223,8,226,677,224,1002,223,2,223,1005,224,434,101,1,223,223,1008,226,677,224,102,2,223,223,1006,224,449,1001,223,1,223,7,226,677,224,1002,223,2,223,1006,224,464,1001,223,1,223,108,677,226,224,102,2,223,223,1005,224,479,101,1,223,223,108,226,226,224,1002,223,2,223,1006,224,494,101,1,223,223,8,226,226,224,1002,223,2,223,1005,224,509,1001,223,1,223,1107,677,226,224,102,2,223,223,1005,224,524,1001,223,1,223,1107,226,226,224,102,2,223,223,1005,224,539,1001,223,1,223,1108,677,677,224,1002,223,2,223,1006,224,554,101,1,223,223,107,226,677,224,102,2,223,223,1005,224,569,1001,223,1,223,1108,226,677,224,1002,223,2,223,1005,224,584,1001,223,1,223,1107,226,677,224,1002,223,2,223,1005,224,599,1001,223,1,223,1008,226,226,224,1002,223,2,223,1005,224,614,101,1,223,223,107,226,226,224,102,2,223,223,1006,224,629,1001,223,1,223,1008,677,677,224,1002,223,2,223,1006,224,644,101,1,223,223,107,677,677,224,1002,223,2,223,1005,224,659,101,1,223,223,1108,677,226,224,1002,223,2,223,1006,224,674,1001,223,1,223,4,223,99,226";
    //private static String input = "3,3,1108,-1,8,3,4,3,99";

    public static void main(String[] args) {
        String[] parts = input.split(",");
        parts = input.split(",");
        int position = 0;
        String opcode = parts[position];
        while (!opcode.equalsIgnoreCase("99")) {
            if (opcode.length() == 1) {
                switch (opcode) {
                    case "1": {
                        int numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        int numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        int output = Integer.parseInt(parts[position + 3]);
                        parts[output] = (numb1 + numb2) + "";
                        position += 4;
                        System.out.println("Addition (Normal): " + parts[output] + " to " + output);
                        break;
                    }
                    case "2": {
                        int numb1 = Integer.parseInt(parts[position + 1]);
                        int numb2 = Integer.parseInt(parts[position + 2]);
                        int output = Integer.parseInt(parts[position + 3]);
                        parts[output] = (Integer.parseInt(parts[numb1]) * Integer.parseInt(parts[numb2])) + "";
                        position += 4;
                        System.out.println("Multiplication (Normal): " + parts[numb1] + " * " + parts[numb2] + " to " + output);
                        break;
                    }
                    case "3": {
                        int output = Integer.parseInt(parts[position + 1]);
                        System.out.println("Input a number: ");
                        Scanner in = new Scanner(System.in);
                        String s = in.nextLine();
                        parts[output] = s + "";
                        position += 2;
                        System.out.println("Input: " + s + " to " + output);
                        break;
                    }
                    case "4": {
                        int output = Integer.parseInt(parts[position + 1]);
                        System.out.println(parts[output]);
                        position += 2;
                        break;
                    }
                    case "5": {
                        String condition = parts[Integer.parseInt(parts[position + 1])];
                        if (!condition.equalsIgnoreCase("0")) {
                            position = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                            System.out.println("J-i-T (Normal): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            System.out.println("J-i-T (Normal): " + condition + ": Nothing happened.");
                        }
                        break;
                    }
                    case "6": {
                        String condition = parts[Integer.parseInt(parts[position + 1])];
                        if (condition.equalsIgnoreCase("0")) {
                            position = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                            System.out.println("J-i-F (Normal): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            System.out.println("J-i-F (Normal): " + condition + ": Nothing happened.");
                        }
                        break;
                    }
                    case "7": {
                        int numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        int numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        int output = Integer.parseInt(parts[position + 3]);
                        if (numb1 < numb2) {
                            parts[output] = "1";
                            System.out.println("less than (Normal): " + numb1 + " < " + numb2 + ": Changed " + output + " to 1");
                        } else {
                            parts[output] = "0";
                            System.out.println("less than (Normal): " + numb1 + " > " + numb2 + ": Changed " + output + " to 0");
                        }
                        position += 4;
                        break;
                    }
                    case "8": {
                        int numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        int numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        int output = Integer.parseInt(parts[position + 3]);
                        if (numb1 == numb2) {
                            parts[output] = "1";
                            System.out.println("equals (Normal): " + numb1 + " == " + numb2 + ": Changed " + output + " to 1");
                        } else {
                            parts[output] = "0";
                            System.out.println("equals (Normal): " + numb1 + " != " + numb2 + ": Changed " + output + " to 0");
                        }
                        position += 4;
                        break;
                    }
                }

            } else {
                switch (opcode.substring(opcode.length() - 2)) {
                    case "01": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        int numb1 = 0, numb2 = 0, output = 0;

                        if (mode1 == 0) numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        else numb1 = Integer.parseInt(parts[position + 1]);
                        if (mode2 == 0) numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        else numb2 = Integer.parseInt(parts[position + 2]);
                        output = Integer.parseInt(parts[position + 3]);

                        parts[output] = (numb1 + numb2) + "";
                        System.out.println("Addition (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " + " + numb2 + " to " + output);
                        position += 4;
                        break;
                    }
                    case "02": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        int numb1 = 0, numb2 = 0, output = 0;

                        if (mode1 == 0) numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        else numb1 = Integer.parseInt(parts[position + 1]);
                        if (mode2 == 0) numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        else numb2 = Integer.parseInt(parts[position + 2]);
                        output = Integer.parseInt(parts[position + 3]);

                        System.out.println("Multiplication (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " + " + numb2 + " to " + output);

                        parts[output] = (numb1 * numb2) + "";
                        position += 4;
                        break;
                    }
                    case "04": {
                        int mode = parseNumber(opcode, opcode.length() - 3);
                        int output = 0;
                        if (mode == 0) output = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        else output = Integer.parseInt(parts[position + 1]);
                        System.out.println(output);
                        position += 2;
                        break;
                    }
                    case "05": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        String condition = "";
                        int output = 0;
                        if (mode1 == 0) condition = parts[Integer.parseInt(parts[position + 1])];
                        else condition = parts[position + 1];
                        if (mode2 == 0) output = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        else output = Integer.parseInt(parts[position + 2]);
                        if (!condition.equalsIgnoreCase("0")) {
                            position = output;
                            System.out.println("J-i-T (Modes: " + mode1 + " " + mode2 + "): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            System.out.println("J-i-T (Modes: " + mode1 + " " + mode2 + "): " + condition + ": Nothing happened");
                        }
                        break;
                    }
                    case "06": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        String condition = "";
                        int output = 0;
                        if (mode1 == 0) condition = parts[Integer.parseInt(parts[position + 1])];
                        else condition = parts[position + 1];
                        if (mode2 == 0) output = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        else output = Integer.parseInt(parts[position + 2]);
                        if (condition.equalsIgnoreCase("0")) {
                            System.out.println("J-i-F (Modes: " + mode1 + " " + mode2 + "): " + condition + ": jumped to " + position);
                            position = output;
                        } else {
                            position += 3;
                            System.out.println("J-i-F (Modes: " + mode1 + " " + mode2 + "): " + condition + ": Nothing happened");
                        }
                        break;
                    }
                    case "07": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        int numb1 = 0, numb2 = 0, output = 0;

                        if (mode1 == 0) numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        else numb1 = Integer.parseInt(parts[position + 1]);
                        if (mode2 == 0) numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        else numb2 = Integer.parseInt(parts[position + 2]);
                        output = Integer.parseInt(parts[position + 3]);
                        if (numb1 < numb2) {
                            parts[output] = "1";
                            System.out.println("less than (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " < " + numb2 + ": Changed " + output + " to 1 ");
                        } else {
                            parts[output] = "0";
                            System.out.println("less than (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " < " + numb2 + ": Changed " + output + " to 0 ");
                        }
                        position += 4;
                        break;
                    }
                    case "08": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        int numb1 = 0, numb2 = 0, output = 0;

                        if (mode1 == 0) numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        else numb1 = Integer.parseInt(parts[position + 1]);
                        if (mode2 == 0) numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        else numb2 = Integer.parseInt(parts[position + 2]);
                        output = Integer.parseInt(parts[position + 3]);
                        if (numb1 == numb2) {
                            parts[output] = "1";
                            System.out.println("equals (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " == " + numb2 + ": Changed " + output + " to 1 ");
                        } else {
                            parts[output] = "0";
                            System.out.println("equals (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " != " + numb2 + ": Changed " + output + " to 0 ");
                        }
                        position += 4;
                        break;
                    }
                }
            }
            opcode = parts[position];
        }
    }

    private static int parseNumber(String number, int position) {
        if (position < 0) {
            return 0;
        }
        return Integer.parseInt((number.charAt(position) + ""));
    }
}
