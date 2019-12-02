package de.derniklaas.adventofcode.day2;

public class Day2B {

    private static String input = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,1,6,19,23,2,23,6,27,1,5,27,31,1,31,9,35,2,10,35,39,1,5,39,43,2,43,10,47,1,47,6,51,2,51,6,55,2,55,13,59,2,6,59,63,1,63,5,67,1,6,67,71,2,71,9,75,1,6,75,79,2,13,79,83,1,9,83,87,1,87,13,91,2,91,10,95,1,6,95,99,1,99,13,103,1,13,103,107,2,107,10,111,1,9,111,115,1,115,10,119,1,5,119,123,1,6,123,127,1,10,127,131,1,2,131,135,1,135,10,0,99,2,14,0,0";

    public static void main(String[] args) {
        String wantedOutput = "19690720";
        String[] parts = input.split(",");

        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                parts = input.split(",");
                parts[1] = i + "";
                parts[2] = j + "";
                for (int k = 0; k < parts.length / 4 + 1; k++) {
                    String opcode = parts[k * 4];
                    switch (opcode) {
                        case "1": {
                            int numb1 = Integer.parseInt(parts[k * 4 + 1]);
                            int numb2 = Integer.parseInt(parts[k * 4 + 2]);
                            int output = Integer.parseInt(parts[k * 4 + 3]);
                            parts[output] = (Integer.parseInt(parts[numb1]) + Integer.parseInt(parts[numb2])) + "";
                            break;
                        }
                        case "2": {
                            int numb1 = Integer.parseInt(parts[k * 4 + 1]);
                            int numb2 = Integer.parseInt(parts[k * 4 + 2]);
                            int output = Integer.parseInt(parts[k * 4 + 3]);
                            parts[output] = (Integer.parseInt(parts[numb1]) * Integer.parseInt(parts[numb2])) + "";
                            break;
                        }
                        case "99": {
                            if (parts[0].equalsIgnoreCase(wantedOutput)) {
                                System.out.println("Number at position 0: " + parts[0]);
                                System.out.println("Noun: " + parts[1] + " Verb: " + parts[2] + " is right!");
                                System.out.println("Output for Question: " + (100 * Integer.parseInt(parts[1]) + Integer.parseInt(parts[2])));
                                return;
                            }
                        }
                    }
                }
            }
            parts[1] = "12";
            parts[2] = "2";
        }
    }

}
