package de.derniklaas.adventofcode.year_2019.day13;

import de.derniklaas.adventofcode.year_2019.IntcodeComputer;
import de.derniklaas.adventofcode.year_2019.Position;

import java.util.HashMap;
import java.util.Map;

public class Day13B {

    private static String input = "1,380,379,385,1008,2655,725232,381,1005,381,12,99,109,2656,1101,0,0,383,1102,1,0,382,21002,382,1,1,21001,383,0,2,21101,37,0,0,1106,0,578,4,382,4,383,204,1,1001,382,1,382,1007,382,42,381,1005,381,22,1001,383,1,383,1007,383,24,381,1005,381,18,1006,385,69,99,104,-1,104,0,4,386,3,384,1007,384,0,381,1005,381,94,107,0,384,381,1005,381,108,1105,1,161,107,1,392,381,1006,381,161,1102,-1,1,384,1106,0,119,1007,392,40,381,1006,381,161,1102,1,1,384,21002,392,1,1,21101,22,0,2,21101,0,0,3,21101,138,0,0,1106,0,549,1,392,384,392,20102,1,392,1,21102,22,1,2,21102,1,3,3,21102,161,1,0,1105,1,549,1101,0,0,384,20001,388,390,1,21001,389,0,2,21101,0,180,0,1106,0,578,1206,1,213,1208,1,2,381,1006,381,205,20001,388,390,1,21002,389,1,2,21101,0,205,0,1105,1,393,1002,390,-1,390,1101,1,0,384,20101,0,388,1,20001,389,391,2,21101,228,0,0,1106,0,578,1206,1,261,1208,1,2,381,1006,381,253,21002,388,1,1,20001,389,391,2,21101,253,0,0,1105,1,393,1002,391,-1,391,1102,1,1,384,1005,384,161,20001,388,390,1,20001,389,391,2,21102,279,1,0,1106,0,578,1206,1,316,1208,1,2,381,1006,381,304,20001,388,390,1,20001,389,391,2,21102,304,1,0,1105,1,393,1002,390,-1,390,1002,391,-1,391,1102,1,1,384,1005,384,161,21002,388,1,1,21002,389,1,2,21102,0,1,3,21101,338,0,0,1106,0,549,1,388,390,388,1,389,391,389,20101,0,388,1,21001,389,0,2,21102,1,4,3,21101,0,365,0,1105,1,549,1007,389,23,381,1005,381,75,104,-1,104,0,104,0,99,0,1,0,0,0,0,0,0,312,19,19,1,1,21,109,3,22101,0,-2,1,22102,1,-1,2,21102,0,1,3,21101,0,414,0,1106,0,549,22101,0,-2,1,22101,0,-1,2,21102,1,429,0,1106,0,601,2101,0,1,435,1,386,0,386,104,-1,104,0,4,386,1001,387,-1,387,1005,387,451,99,109,-3,2106,0,0,109,8,22202,-7,-6,-3,22201,-3,-5,-3,21202,-4,64,-2,2207,-3,-2,381,1005,381,492,21202,-2,-1,-1,22201,-3,-1,-3,2207,-3,-2,381,1006,381,481,21202,-4,8,-2,2207,-3,-2,381,1005,381,518,21202,-2,-1,-1,22201,-3,-1,-3,2207,-3,-2,381,1006,381,507,2207,-3,-4,381,1005,381,540,21202,-4,-1,-1,22201,-3,-1,-3,2207,-3,-4,381,1006,381,529,21202,-3,1,-7,109,-8,2105,1,0,109,4,1202,-2,42,566,201,-3,566,566,101,639,566,566,2101,0,-1,0,204,-3,204,-2,204,-1,109,-4,2106,0,0,109,3,1202,-1,42,594,201,-2,594,594,101,639,594,594,20102,1,0,-2,109,-3,2105,1,0,109,3,22102,24,-2,1,22201,1,-1,1,21102,509,1,2,21101,480,0,3,21102,1008,1,4,21102,1,630,0,1105,1,456,21201,1,1647,-2,109,-3,2106,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,2,0,0,0,2,2,2,0,2,2,2,2,0,0,2,2,2,0,0,2,2,0,2,2,0,2,0,2,0,0,0,0,0,0,0,2,0,2,0,1,1,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,2,2,2,0,2,0,0,2,0,0,2,2,0,2,2,0,0,2,0,0,2,2,0,0,0,1,1,0,0,0,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,0,2,0,0,0,0,2,2,0,0,2,0,0,2,0,0,0,0,2,0,0,0,1,1,0,2,2,0,0,0,2,0,0,2,2,2,2,0,2,2,0,2,2,2,0,0,0,2,0,0,2,2,2,0,0,2,2,2,0,0,2,2,0,0,1,1,0,2,2,0,2,2,2,0,2,2,0,2,0,2,0,2,2,2,2,0,0,2,0,2,2,0,2,2,0,0,0,0,2,0,2,0,0,2,2,0,1,1,0,0,2,2,0,2,2,0,0,2,2,0,0,2,2,0,0,2,2,2,0,0,2,0,2,0,0,2,0,2,2,2,2,2,2,0,2,0,0,0,1,1,0,0,0,2,2,0,0,2,0,2,0,2,2,2,2,2,2,2,0,2,2,2,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2,2,0,0,1,1,0,0,2,2,2,2,2,2,2,0,2,2,2,0,2,0,2,0,2,2,0,0,2,0,0,0,0,2,2,0,0,2,0,2,0,0,0,2,0,0,1,1,0,2,0,0,2,2,2,2,2,0,2,0,0,0,2,0,2,0,2,2,2,2,2,2,2,2,0,2,2,2,0,0,2,2,2,2,2,0,0,0,1,1,0,0,0,0,2,2,2,2,2,0,2,0,0,0,2,0,0,0,0,0,2,2,0,0,0,0,2,2,0,0,0,2,0,0,2,2,2,2,0,0,1,1,0,0,0,0,2,0,0,2,2,2,2,0,0,2,2,2,2,2,2,0,0,0,0,2,2,0,2,0,0,2,2,2,2,0,2,0,2,2,2,0,1,1,0,2,0,2,0,2,0,0,2,0,0,2,0,0,0,2,2,0,0,0,2,2,0,2,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,1,1,0,0,2,2,2,2,2,2,0,2,0,0,2,0,0,0,2,0,2,2,0,2,0,0,2,2,2,2,0,0,2,2,2,2,0,2,2,2,2,0,1,1,0,0,2,0,0,0,0,2,2,0,0,2,2,0,2,0,2,0,0,2,2,2,2,0,0,0,2,0,0,2,2,0,2,2,0,2,0,2,0,0,1,1,0,0,2,0,2,2,2,0,0,0,2,2,2,0,0,2,0,2,2,0,0,0,0,0,0,2,2,2,0,2,2,0,2,0,0,0,0,2,2,0,1,1,0,2,2,2,2,2,0,2,0,0,2,0,2,2,2,2,0,0,0,0,2,0,2,2,0,2,2,2,0,0,0,2,0,0,2,2,2,0,2,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,90,66,5,79,27,87,67,84,18,77,20,97,79,59,38,12,54,16,15,83,77,22,98,1,84,89,72,20,64,38,74,10,19,81,77,18,18,79,60,64,49,19,65,73,57,65,57,22,12,50,6,28,49,28,83,2,85,53,8,59,96,16,64,65,38,32,27,75,93,46,16,8,43,50,83,18,49,28,18,79,16,82,86,12,53,5,80,52,23,66,48,37,81,12,93,12,84,1,32,35,93,19,90,65,40,52,44,71,34,52,54,59,17,34,69,77,35,97,89,38,60,53,16,77,20,65,66,61,39,26,98,41,58,96,20,70,13,9,21,3,64,68,70,84,45,43,15,60,82,25,91,93,68,71,20,91,38,38,74,63,62,95,5,73,12,52,32,14,89,64,37,85,80,39,50,27,55,39,69,19,83,77,26,31,60,23,70,51,35,80,70,39,28,40,84,32,67,44,49,83,42,53,89,54,31,85,7,94,69,65,80,2,21,70,76,19,77,53,3,82,1,56,62,30,2,72,22,43,7,65,54,52,66,55,53,26,85,13,79,34,97,9,61,41,24,30,71,12,55,17,22,25,7,32,72,72,21,25,22,79,23,36,71,13,70,29,55,3,29,18,91,85,30,10,56,84,90,66,45,63,13,74,40,43,46,3,74,94,10,12,11,43,17,46,50,79,88,2,11,1,72,92,35,5,83,49,48,97,22,64,14,69,45,10,51,95,36,70,54,49,10,85,91,27,87,73,52,69,47,82,21,63,50,11,65,23,4,35,14,23,79,81,93,35,81,95,88,70,73,13,44,84,8,18,50,78,48,62,34,2,32,89,89,18,63,90,8,78,71,73,91,52,21,8,44,94,75,20,20,94,85,45,69,36,41,62,29,42,11,42,88,8,88,7,64,55,33,65,65,82,71,97,73,58,27,63,93,70,92,93,48,69,20,66,57,75,63,96,81,46,18,60,57,79,74,35,93,33,20,86,76,82,94,3,62,26,47,36,71,54,32,43,74,59,13,78,36,30,44,11,1,60,25,70,83,13,43,14,24,21,16,94,82,67,74,27,32,50,33,88,76,89,31,50,73,70,94,80,24,85,40,5,48,50,18,40,98,81,74,89,8,28,42,11,1,89,10,51,32,94,91,67,65,75,20,59,73,42,27,43,46,62,84,9,42,79,17,33,65,66,45,98,86,56,46,12,78,66,24,74,85,7,43,84,83,39,79,46,81,46,6,97,36,54,4,40,32,74,31,15,62,32,72,36,86,87,65,82,54,6,71,14,29,82,72,55,72,72,86,26,30,58,1,26,36,9,23,7,8,96,84,33,53,18,72,93,46,17,72,87,25,65,96,67,42,77,83,23,85,86,71,46,82,45,41,66,77,4,21,37,18,82,34,87,8,69,86,90,31,55,79,18,75,8,29,43,60,26,78,40,4,91,1,54,29,62,76,80,98,23,5,63,28,17,29,85,7,87,88,76,45,90,22,41,74,17,34,66,47,75,12,97,84,73,3,78,67,38,4,49,92,94,96,62,40,5,93,58,49,29,43,9,30,41,63,52,2,77,10,21,27,82,39,65,8,73,10,33,86,31,38,71,20,2,1,70,27,70,3,45,30,12,41,49,62,27,3,65,8,15,36,14,20,5,68,61,24,61,63,57,68,53,64,80,86,22,94,83,20,14,88,22,12,40,38,71,67,73,17,96,10,48,97,1,98,61,95,16,74,93,64,56,84,25,48,70,93,50,79,86,33,14,38,58,21,15,96,46,82,51,78,39,29,63,49,17,80,92,42,59,41,86,58,30,34,85,89,24,75,70,21,39,29,80,91,13,16,78,12,47,58,33,69,58,87,44,27,70,31,45,52,64,11,20,56,94,46,17,17,68,24,55,74,7,50,51,46,16,74,88,39,51,54,82,7,42,28,97,96,64,42,59,43,12,53,15,8,36,18,48,97,83,4,8,55,78,46,16,22,42,8,72,94,94,24,74,84,53,75,97,13,64,6,31,9,20,4,38,56,2,45,14,62,8,86,42,27,54,73,87,97,62,4,52,27,98,23,11,52,66,75,22,88,8,19,1,16,64,47,98,94,30,54,17,61,5,92,53,83,17,11,93,91,75,2,17,30,23,31,72,25,10,13,57,45,59,48,52,35,4,8,20,98,18,53,92,95,21,84,22,68,90,33,72,5,32,95,64,28,53,7,96,39,80,15,43,80,91,53,26,28,71,5,19,96,19,17,5,32,85,76,5,8,75,24,92,6,74,51,19,20,36,84,65,63,43,36,65,725232";

    public static void main(String[] args) {
        IntcodeComputer computer = new IntcodeComputer(input, true, true);
        computer.getParts()[0] = 2;
        int score = 0;
        int ballX = 0;
        int paddleX = 0;
        Map<Position, Integer> map = new HashMap<>();
        while (computer.isRunning()) {
            computer.compute();
            int x = (int) computer.getOutput();
            computer.compute();
            int y = (int) computer.getOutput();
            computer.compute();
            int type = (int) computer.getOutput();
            if (x == -1 && y == 0) {
                score = type;
            } else {
                Position pos = new Position(x, y);
                if (type == 4) {
                    ballX = x;
                }
                if (type == 3) {
                    paddleX = x;
                }
                map.remove(pos);
                map.put(pos, type);
            }
            int inputNumber = getJoystickPosition(ballX, paddleX);
            computer.setInputNumber(inputNumber);
        }

        int blocks = 0;
        for (Position positions : map.keySet()) {
            if (map.get(positions) == 2) blocks++;
        }
        if (blocks != 0) {
            System.out.printf("There was an error! Amount of blocks left: %d \n", blocks);
        }
        System.out.printf("[Day 13/B] The score is %d \n", score);
    }

    private static int getJoystickPosition(int ballX, int paddleX) {
        if (paddleX > ballX) return -1;
        if (paddleX < ballX) return 1;
        return 0;
    }
}
