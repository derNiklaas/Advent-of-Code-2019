package de.derniklaas.adventofcode.day9;

import java.util.Arrays;
import java.util.Scanner;

public class Day9A {

    private static String input = "1102,34463338,34463338,63,1007,63,34463338,63,1005,63,53,1102,1,3,1000,109,988,209,12,9,1000,209,6,209,3,203,0,1008,1000,1,63,1005,63,65,1008,1000,2,63,1005,63,902,1008,1000,0,63,1005,63,58,4,25,104,0,99,4,0,104,0,99,4,17,104,0,99,0,0,1101,0,39,1005,1102,1,1,1021,1101,0,212,1025,1101,0,24,1014,1102,22,1,1019,1101,0,35,1003,1101,38,0,1002,1101,0,571,1026,1102,32,1,1006,1102,31,1,1000,1102,25,1,1018,1102,1,37,1016,1101,0,820,1023,1102,1,29,1004,1101,564,0,1027,1101,0,375,1028,1101,26,0,1013,1102,1,370,1029,1101,21,0,1007,1101,0,0,1020,1102,1,30,1001,1102,36,1,1011,1102,1,27,1017,1101,0,28,1012,1101,0,217,1024,1101,823,0,1022,1102,1,20,1009,1101,0,23,1010,1101,34,0,1015,1101,33,0,1008,109,5,1208,0,39,63,1005,63,199,4,187,1106,0,203,1001,64,1,64,1002,64,2,64,109,13,2105,1,6,4,209,1105,1,221,1001,64,1,64,1002,64,2,64,109,-4,21108,40,39,-1,1005,1013,241,1001,64,1,64,1105,1,243,4,227,1002,64,2,64,109,5,21102,41,1,-1,1008,1018,40,63,1005,63,267,1001,64,1,64,1106,0,269,4,249,1002,64,2,64,109,-28,1202,10,1,63,1008,63,30,63,1005,63,291,4,275,1106,0,295,1001,64,1,64,1002,64,2,64,109,24,21107,42,43,-4,1005,1011,313,4,301,1106,0,317,1001,64,1,64,1002,64,2,64,109,-8,21108,43,43,3,1005,1010,335,4,323,1105,1,339,1001,64,1,64,1002,64,2,64,109,-8,1207,4,34,63,1005,63,359,1001,64,1,64,1106,0,361,4,345,1002,64,2,64,109,26,2106,0,3,4,367,1106,0,379,1001,64,1,64,1002,64,2,64,109,-21,2102,1,-2,63,1008,63,37,63,1005,63,399,1105,1,405,4,385,1001,64,1,64,1002,64,2,64,109,2,1207,-2,30,63,1005,63,427,4,411,1001,64,1,64,1105,1,427,1002,64,2,64,109,4,2108,36,-5,63,1005,63,447,1001,64,1,64,1106,0,449,4,433,1002,64,2,64,109,-13,1201,8,0,63,1008,63,41,63,1005,63,469,1106,0,475,4,455,1001,64,1,64,1002,64,2,64,109,14,21107,44,43,3,1005,1014,495,1001,64,1,64,1106,0,497,4,481,1002,64,2,64,109,2,1205,8,511,4,503,1106,0,515,1001,64,1,64,1002,64,2,64,109,14,1206,-6,527,1105,1,533,4,521,1001,64,1,64,1002,64,2,64,109,-29,2107,31,8,63,1005,63,551,4,539,1105,1,555,1001,64,1,64,1002,64,2,64,109,28,2106,0,1,1001,64,1,64,1106,0,573,4,561,1002,64,2,64,109,-3,21101,45,0,-4,1008,1019,45,63,1005,63,595,4,579,1105,1,599,1001,64,1,64,1002,64,2,64,109,-23,1208,2,39,63,1005,63,615,1105,1,621,4,605,1001,64,1,64,1002,64,2,64,109,15,2108,32,-9,63,1005,63,643,4,627,1001,64,1,64,1105,1,643,1002,64,2,64,109,-9,2107,33,0,63,1005,63,659,1106,0,665,4,649,1001,64,1,64,1002,64,2,64,109,7,21101,46,0,2,1008,1015,49,63,1005,63,689,1001,64,1,64,1106,0,691,4,671,1002,64,2,64,109,-8,2101,0,-3,63,1008,63,35,63,1005,63,711,1105,1,717,4,697,1001,64,1,64,1002,64,2,64,109,12,1202,-9,1,63,1008,63,31,63,1005,63,741,1001,64,1,64,1105,1,743,4,723,1002,64,2,64,109,-27,2102,1,10,63,1008,63,31,63,1005,63,769,4,749,1001,64,1,64,1105,1,769,1002,64,2,64,109,9,2101,0,1,63,1008,63,31,63,1005,63,791,4,775,1106,0,795,1001,64,1,64,1002,64,2,64,109,28,1206,-7,809,4,801,1105,1,813,1001,64,1,64,1002,64,2,64,2105,1,-4,1106,0,829,4,817,1001,64,1,64,1002,64,2,64,109,-15,21102,47,1,-2,1008,1010,47,63,1005,63,851,4,835,1106,0,855,1001,64,1,64,1002,64,2,64,109,5,1205,3,867,1106,0,873,4,861,1001,64,1,64,1002,64,2,64,109,-12,1201,0,0,63,1008,63,39,63,1005,63,895,4,879,1105,1,899,1001,64,1,64,4,64,99,21101,0,27,1,21102,913,1,0,1106,0,920,21201,1,47951,1,204,1,99,109,3,1207,-2,3,63,1005,63,962,21201,-2,-1,1,21101,0,940,0,1105,1,920,21201,1,0,-1,21201,-2,-3,1,21101,0,955,0,1106,0,920,22201,1,-1,-2,1105,1,966,21202,-2,1,-2,109,-3,2105,1,0";
    //private static String input = "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99";
    //private static String input = "3,225,1,225,6,6,1100,1,238,225,104,0,1002,43,69,224,101,-483,224,224,4,224,1002,223,8,223,1001,224,5,224,1,224,223,223,1101,67,60,225,1102,5,59,225,1101,7,16,225,1102,49,72,225,101,93,39,224,101,-98,224,224,4,224,102,8,223,223,1001,224,6,224,1,224,223,223,1102,35,82,225,2,166,36,224,101,-4260,224,224,4,224,102,8,223,223,101,5,224,224,1,223,224,223,102,66,48,224,1001,224,-4752,224,4,224,102,8,223,223,1001,224,2,224,1,223,224,223,1001,73,20,224,1001,224,-55,224,4,224,102,8,223,223,101,7,224,224,1,223,224,223,1102,18,41,224,1001,224,-738,224,4,224,102,8,223,223,101,6,224,224,1,224,223,223,1101,68,71,225,1102,5,66,225,1101,27,5,225,1101,54,63,224,1001,224,-117,224,4,224,102,8,223,223,1001,224,2,224,1,223,224,223,1,170,174,224,101,-71,224,224,4,224,1002,223,8,223,1001,224,4,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1007,226,226,224,1002,223,2,223,1006,224,329,1001,223,1,223,1007,226,677,224,102,2,223,223,1006,224,344,1001,223,1,223,108,677,677,224,102,2,223,223,1005,224,359,1001,223,1,223,1007,677,677,224,1002,223,2,223,1006,224,374,101,1,223,223,8,677,226,224,1002,223,2,223,1006,224,389,101,1,223,223,7,226,226,224,1002,223,2,223,1005,224,404,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,419,1001,223,1,223,8,226,677,224,1002,223,2,223,1005,224,434,101,1,223,223,1008,226,677,224,102,2,223,223,1006,224,449,1001,223,1,223,7,226,677,224,1002,223,2,223,1006,224,464,1001,223,1,223,108,677,226,224,102,2,223,223,1005,224,479,101,1,223,223,108,226,226,224,1002,223,2,223,1006,224,494,101,1,223,223,8,226,226,224,1002,223,2,223,1005,224,509,1001,223,1,223,1107,677,226,224,102,2,223,223,1005,224,524,1001,223,1,223,1107,226,226,224,102,2,223,223,1005,224,539,1001,223,1,223,1108,677,677,224,1002,223,2,223,1006,224,554,101,1,223,223,107,226,677,224,102,2,223,223,1005,224,569,1001,223,1,223,1108,226,677,224,1002,223,2,223,1005,224,584,1001,223,1,223,1107,226,677,224,1002,223,2,223,1005,224,599,1001,223,1,223,1008,226,226,224,1002,223,2,223,1005,224,614,101,1,223,223,107,226,226,224,102,2,223,223,1006,224,629,1001,223,1,223,1008,677,677,224,1002,223,2,223,1006,224,644,101,1,223,223,107,677,677,224,1002,223,2,223,1005,224,659,101,1,223,223,1108,677,226,224,1002,223,2,223,1006,224,674,1001,223,1,223,4,223,99,226";


    private static long[] parts = new long[10000];
    private static int relBase = 0;


    public static void main(String[] args) {
        String[] temp = input.split(",");
        Arrays.fill(parts, 0);
        for (int i = 0; i < temp.length; i++) {
            parts[i] = Long.parseLong(temp[i]);
        }
        temp = null;
        int position = 0;
        String opcode = parts[position] + "";
        while (!opcode.equalsIgnoreCase("99")) {
            if (opcode.length() == 1) {
                switch (opcode) {
                    case "1": {
                        long numb1 = getValue(0, position + 1);
                        long numb2 = getValue(0, position + 2);
                        int output = getAddress(0, position + 3);
                        parts[output] = numb1 + numb2;
                        position += 4;
                        System.out.println("Addition (Normal): " + parts[output] + " to " + output);
                        break;
                    }
                    case "2": {
                        long numb1 = getValue(0, position + 1);
                        long numb2 = getValue(0, position + 2);
                        int output = getAddress(0, position + 3);
                        parts[output] = numb1 * numb2;
                        position += 4;
                        System.out.println("Multiplication (Normal): " + numb1 + " * " + numb2 + " to " + output);
                        break;
                    }
                    case "3": {
                        int output = getAddress(0, position + 1);
                        System.out.println("Input a number: ");
                        Scanner in = new Scanner(System.in);
                        String s = in.nextLine();
                        parts[output] = Long.parseLong(s);
                        position += 2;
                        System.out.println("Input: " + s + " to " + output);
                        break;
                    }
                    case "4": {
                        long output = getValue(0, position + 1);
                        System.out.println(output);
                        position += 2;
                        break;
                    }
                    case "5": {
                        long condition = getValue(0, position + 1);
                        if (condition == 1) {
                            position = getAddress(0, position + 2);
                            System.out.println("J-i-T (Normal): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            System.out.println("J-i-T (Normal): " + condition + ": Nothing happened.");
                        }
                        break;
                    }
                    case "6": {
                        long condition = getValue(0, position + 1);
                        if (condition == 0) {
                            position = getAddress(0, position + 2);
                            System.out.println("J-i-F (Normal): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            System.out.println("J-i-F (Normal): " + condition + ": Nothing happened.");
                        }
                        break;
                    }
                    case "7": {
                        long numb1 = getValue(0, position + 1);
                        long numb2 = getValue(0, position + 2);
                        int output = getAddress(0, position + 3);
                        if (numb1 < numb2) {
                            parts[output] = 1;
                            System.out.println("less than (Normal): " + numb1 + " < " + numb2 + ": Changed " + output + " to 1");
                        } else {
                            parts[output] = 0;
                            System.out.println("less than (Normal): " + numb1 + " > " + numb2 + ": Changed " + output + " to 0");
                        }
                        position += 4;
                        break;
                    }
                    case "8": {
                        long numb1 = getValue(0, position + 1);
                        long numb2 = getValue(0, position + 2);
                        int output = getAddress(0, position + 3);
                        if (numb1 == numb2) {
                            parts[output] = 1;
                            System.out.println("equals (Normal): " + numb1 + " == " + numb2 + ": Changed " + output + " to 1");
                        } else {
                            parts[output] = 0;
                            System.out.println("equals (Normal): " + numb1 + " != " + numb2 + ": Changed " + output + " to 0");
                        }
                        position += 4;
                        break;
                    }
                    case "9": {
                        long numb1 = getValue(0, position + 1);
                        relBase += numb1;
                        System.out.println("move relBase (Normal): Changed to " + relBase);
                        position += 2;
                        break;
                    }
                }
            } else {
                switch (opcode.substring(opcode.length() - 2)) {
                    case "01": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        long numb1 = 0, numb2 = 0;
                        int output = 0;

                        numb1 = getValue(mode1, position + 1);
                        numb2 = getValue(mode2, position + 2);
                        output = getAddress(mode3, position + 3);
                        parts[output] = numb1 + numb2;
                        System.out.println("Addition (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " + " + numb2 + " to " + output);
                        position += 4;
                        break;
                    }
                    case "02": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        long numb1 = 0, numb2 = 0;
                        int output = 0;

                        numb1 = getValue(mode1, position + 1);
                        numb2 = getValue(mode2, position + 2);
                        output = getAddress(mode3, position + 3);
                        System.out.println("Multiplication (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " + " + numb2 + " to " + output);
                        long result = numb1 * numb2;

                        parts[output] = result;
                        position += 4;
                        break;
                    }
                    case "03": {
                        int mode = parseNumber(opcode, opcode.length() - 3);
                        int output = 0;
                        System.out.println("Debug Info: mode:" + mode + " output: " + output + " pos: " + position + " pos+1= " + getAddress(mode, position + 1));
                        output = getAddress(mode, position + 1);
                        System.out.println("Input a number: ");
                        Scanner in = new Scanner(System.in);
                        String s = in.nextLine();
                        parts[output] = Long.parseLong(s);
                        position += 2;
                        System.out.println("Input: " + s + " to " + output);
                        break;
                    }
                    case "04": {
                        int mode = parseNumber(opcode, opcode.length() - 3);
                        long output = 0;
                        output = getValue(mode, position + 1);
                        System.out.println(output);
                        position += 2;
                        break;
                    }
                    case "05": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        long condition = getValue(mode1, position + 1);
                        long output = getValue(mode2, position + 2);
                        if (condition != 0) {
                            position = (int) output;
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
                        long condition = getValue(mode1, position + 1);
                        int output = (int) getValue(mode2, position + 2);
                        if (condition == 0) {
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
                        long numb1 = getValue(mode1, position + 1), numb2 = getValue(mode2, position + 2);
                        int output = getAddress(mode3, position + 3);
                        if (numb1 < numb2) {
                            parts[output] = 1;
                            System.out.println("less than (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " < " + numb2 + ": Changed " + output + " to 1 ");
                        } else {
                            parts[output] = 0;
                            System.out.println("less than (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " < " + numb2 + ": Changed " + output + " to 0 ");
                        }
                        position += 4;
                        break;
                    }
                    case "08": {
                        int mode1 = parseNumber(opcode, opcode.length() - 3);
                        int mode2 = parseNumber(opcode, opcode.length() - 4);
                        int mode3 = parseNumber(opcode, opcode.length() - 5);
                        long numb1 = getValue(mode1, position + 1), numb2 = getValue(mode2, position + 2);
                        int output = getAddress(mode3, position + 3);
                        if (numb1 == numb2) {
                            parts[output] = 1;
                            System.out.println("equals (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " == " + numb2 + ": Changed " + output + " to 1 ");
                        } else {
                            parts[output] = 0;
                            System.out.println("equals (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " != " + numb2 + ": Changed " + output + " to 0 ");
                        }
                        position += 4;
                        break;
                    }
                    case "09": {
                        int mode = parseNumber(opcode, opcode.length() - 3);
                        long numb1 = getValue(mode, position + 1);
                        relBase += numb1;
                        System.out.println("move relBase (Mode): Changed to " + relBase);
                        position += 2;
                        break;
                    }
                }
            }
            opcode = parts[position] + "";
        }
    }

    //pos 18 -> 12
    //12 + 998 =

    private static long getValue(int mode, int position) {
        if (mode == 0) return parts[Integer.parseInt(parts[position] + "")];
        else if (mode == 1) return parts[position];
        else {
            System.out.println((parts[position] + relBase) + " " + parts[(int) parts[position] + relBase]);
            return parts[Integer.parseInt(parts[position] + relBase + "")];
        }
    }

    private static int getAddress(int mode, int position) {
        if (mode == 0) return (int) parts[position];
        else return (int) parts[position] + relBase;
    }

    private static int parseNumber(String number, int position) {
        if (position < 0) {
            return 0;
        }
        return Integer.parseInt((number.charAt(position) + ""));
    }
}
