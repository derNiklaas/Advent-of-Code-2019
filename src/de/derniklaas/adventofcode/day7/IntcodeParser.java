package de.derniklaas.adventofcode.day7;

public class IntcodeParser {

    private String[] parts;
    private boolean stopped = false;
    private int firstinput = 0;
    private int secondinput = 0;
    private int position = 0;

    public IntcodeParser(String input, int firstinput, int secondinput) {
        parts = input.split(",");
        this.firstinput = firstinput;
        this.secondinput = secondinput;
    }

    public void changeSecondInput(int secondInput) {
        this.firstinput = secondinput;
    }

    public int parseCode() {
        String opcode = parts[position];
        boolean checked = false;
        while (!opcode.equalsIgnoreCase("99")) {
            if (opcode.length() == 1) {
                switch (opcode) {
                    case "1": {
                        int numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        int numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        int output = Integer.parseInt(parts[position + 3]);
                        parts[output] = (numb1 + numb2) + "";
                        position += 4;
                        //System.out.println("Addition (Normal): " + parts[output] + " to " + output);
                        break;
                    }
                    case "2": {
                        int numb1 = Integer.parseInt(parts[position + 1]);
                        int numb2 = Integer.parseInt(parts[position + 2]);
                        int output = Integer.parseInt(parts[position + 3]);
                        parts[output] = (Integer.parseInt(parts[numb1]) * Integer.parseInt(parts[numb2])) + "";
                        position += 4;
                        //System.out.println("Multiplication (Normal): " + parts[numb1] + " * " + parts[numb2] + " to " + output);
                        break;
                    }
                    case "3": {
                        int output = Integer.parseInt(parts[position + 1]);
                        //System.out.println("Input a number: ");
                        if (!checked) {
                            parts[output] = firstinput + "";
                            checked = true;
                            //System.out.println("Input (first): " + firstinput + " to " + output);
                        } else {
                            parts[output] = secondinput + "";
                            //System.out.println("Input (second): " + secondinput + " to " + output);
                        }

                        position += 2;

                        break;
                    }
                    case "4": {
                        int output = Integer.parseInt(parts[position + 1]);
                        //System.out.println();
                        position += 2;
                        return Integer.parseInt(parts[output]);
                    }
                    case "5": {
                        String condition = parts[Integer.parseInt(parts[position + 1])];
                        if (!condition.equalsIgnoreCase("0")) {
                            position = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                            //    System.out.println("J-i-T (Normal): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            //    System.out.println("J-i-T (Normal): " + condition + ": Nothing happened.");
                        }
                        break;
                    }
                    case "6": {
                        String condition = parts[Integer.parseInt(parts[position + 1])];
                        if (condition.equalsIgnoreCase("0")) {
                            position = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                            //    System.out.println("J-i-F (Normal): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            //    System.out.println("J-i-F (Normal): " + condition + ": Nothing happened.");
                        }
                        break;
                    }
                    case "7": {
                        int numb1 = Integer.parseInt(parts[Integer.parseInt(parts[position + 1])]);
                        int numb2 = Integer.parseInt(parts[Integer.parseInt(parts[position + 2])]);
                        int output = Integer.parseInt(parts[position + 3]);
                        if (numb1 < numb2) {
                            parts[output] = "1";
                            //    System.out.println("less than (Normal): " + numb1 + " < " + numb2 + ": Changed " + output + " to 1");
                        } else {
                            parts[output] = "0";
                            //    System.out.println("less than (Normal): " + numb1 + " > " + numb2 + ": Changed " + output + " to 0");
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
                            //    System.out.println("equals (Normal): " + numb1 + " == " + numb2 + ": Changed " + output + " to 1");
                        } else {
                            parts[output] = "0";
                            //    System.out.println("equals (Normal): " + numb1 + " != " + numb2 + ": Changed " + output + " to 0");
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
                        //System.out.println("Addition (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " + " + numb2 + " to " + output);
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

                        //System.out.println("Multiplication (Modes: " + mode1 + " " + mode2 + " " + mode3 + "): " + numb1 + " + " + numb2 + " to " + output);

                        parts[output] = (numb1 * numb2) + "";
                        position += 4;
                        break;
                    }
                    case "04": {
                        int output = 0;
                        if (!checked) {
                            parts[output] = firstinput + "";
                            checked = true;
                        } else parts[output] = secondinput + "";
                        //System.out.println();
                        return output;
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
                            //    System.out.println("J-i-T (Modes: " + mode1 + " " + mode2 + "): " + condition + ": jumped to " + position);
                        } else {
                            position += 3;
                            //    System.out.println("J-i-T (Modes: " + mode1 + " " + mode2 + "): " + condition + ": Nothing happened");
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
                            //    System.out.println("J-i-F (Modes: " + mode1 + " " + mode2 + "): " + condition + ": jumped to " + position);
                            position = output;
                        } else {
                            position += 3;
                            //    System.out.println("J-i-F (Modes: " + mode1 + " " + mode2 + "): " + condition + ": Nothing happened");
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
                            //    System.out.println("less than (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " < " + numb2 + ": Changed " + output + " to 1 ");
                        } else {
                            parts[output] = "0";
                            //    System.out.println("less than (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " < " + numb2 + ": Changed " + output + " to 0 ");
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
                            //    System.out.println("equals (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " == " + numb2 + ": Changed " + output + " to 1 ");
                        } else {
                            parts[output] = "0";
                            //    System.out.println("equals (Modes: " + mode1 + " + " + mode2 + " " + mode3 + "):" + numb1 + " != " + numb2 + ": Changed " + output + " to 0 ");
                        }
                        position += 4;
                        break;
                    }
                }
            }
            opcode = parts[position];
        }
        stopped = true;
        return 0;
    }

    private static int parseNumber(String number, int position) {
        if (position < 0) {
            return 0;
        }
        return Integer.parseInt((number.charAt(position) + ""));
    }

    public boolean hasStopped() {
        return stopped;
    }
}
