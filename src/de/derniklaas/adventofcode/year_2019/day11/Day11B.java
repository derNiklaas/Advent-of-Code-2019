package de.derniklaas.adventofcode.year_2019.day11;

import de.derniklaas.adventofcode.year_2019.IntcodeComputer;
import de.derniklaas.adventofcode.year_2019.Position;

import java.util.ArrayList;
import java.util.List;

public class Day11B {

    private static String input = "3,8,1005,8,329,1106,0,11,0,0,0,104,1,104,0,3,8,102,-1,8,10,1001,10,1,10,4,10,1008,8,0,10,4,10,1002,8,1,29,2,1102,1,10,1,1009,16,10,2,4,4,10,1,9,5,10,3,8,1002,8,-1,10,101,1,10,10,4,10,108,0,8,10,4,10,101,0,8,66,2,106,7,10,1006,0,49,3,8,1002,8,-1,10,101,1,10,10,4,10,108,1,8,10,4,10,1002,8,1,95,1006,0,93,3,8,102,-1,8,10,1001,10,1,10,4,10,108,1,8,10,4,10,102,1,8,120,1006,0,61,2,1108,19,10,2,1003,2,10,1006,0,99,3,8,1002,8,-1,10,1001,10,1,10,4,10,1008,8,0,10,4,10,101,0,8,157,3,8,102,-1,8,10,1001,10,1,10,4,10,1008,8,1,10,4,10,1001,8,0,179,2,1108,11,10,1,1102,19,10,3,8,102,-1,8,10,1001,10,1,10,4,10,1008,8,1,10,4,10,101,0,8,209,2,108,20,10,3,8,1002,8,-1,10,101,1,10,10,4,10,108,1,8,10,4,10,101,0,8,234,3,8,102,-1,8,10,101,1,10,10,4,10,108,0,8,10,4,10,1002,8,1,256,2,1102,1,10,1006,0,69,2,108,6,10,2,4,13,10,3,8,102,-1,8,10,101,1,10,10,4,10,1008,8,0,10,4,10,1002,8,1,294,1,1107,9,10,1006,0,87,2,1006,8,10,2,1001,16,10,101,1,9,9,1007,9,997,10,1005,10,15,99,109,651,104,0,104,1,21101,387395195796,0,1,21101,346,0,0,1105,1,450,21101,0,48210129704,1,21101,0,357,0,1105,1,450,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,21101,0,46413147328,1,21102,404,1,0,1106,0,450,21102,179355823323,1,1,21101,415,0,0,1105,1,450,3,10,104,0,104,0,3,10,104,0,104,0,21102,1,838345843476,1,21101,0,438,0,1105,1,450,21101,709475709716,0,1,21101,449,0,0,1105,1,450,99,109,2,22102,1,-1,1,21102,40,1,2,21101,0,481,3,21101,0,471,0,1105,1,514,109,-2,2105,1,0,0,1,0,0,1,109,2,3,10,204,-1,1001,476,477,492,4,0,1001,476,1,476,108,4,476,10,1006,10,508,1101,0,0,476,109,-2,2106,0,0,0,109,4,2101,0,-1,513,1207,-3,0,10,1006,10,531,21101,0,0,-3,21201,-3,0,1,21201,-2,0,2,21101,1,0,3,21101,550,0,0,1105,1,555,109,-4,2106,0,0,109,5,1207,-3,1,10,1006,10,578,2207,-4,-2,10,1006,10,578,21201,-4,0,-4,1105,1,646,22101,0,-4,1,21201,-3,-1,2,21202,-2,2,3,21101,597,0,0,1105,1,555,22102,1,1,-4,21101,0,1,-1,2207,-4,-2,10,1006,10,616,21101,0,0,-1,22202,-2,-1,-2,2107,0,-3,10,1006,10,638,22102,1,-1,1,21101,638,0,0,106,0,513,21202,-2,-1,-2,22201,-4,-2,-4,109,-5,2106,0,0";

    public static void main(String[] args) {
        IntcodeComputer computer = new IntcodeComputer(input, true);
        computer.setInputNumber(1);
        computer.compute();
        int outputPosition = 0;
        ArrayList<Position> white = new ArrayList<>();
        int color = 0, directions = 0, x = 0, y = 0;
        while (computer.isRunning()) {
            List<Long> outputs = computer.getOutputs();
            for (; outputPosition < outputs.size(); outputPosition += 2) {
                color = Integer.parseInt(outputs.get(outputPosition) + "");
                Position position = new Position(x, y);
                if (white.contains(position) && color == 0) {
                    white.remove(position);
                } else if (!white.contains(position) && color == 1) {
                    white.add(position);
                }
                int turn = Integer.parseInt(outputs.get(outputPosition + 1) + "");
                if (turn == 0) {
                    directions--;
                } else {
                    directions++;
                }
                if (directions == -1) directions += 4;
                if (directions == 4) directions -= 4;
                switch (directions) {
                    case 0: { // UP
                        y--;
                        break;
                    }
                    case 1: { // RIGHT
                        x--;
                        break;
                    }
                    case 2: { // DOWN
                        y++;
                        break;
                    }
                    case 3: { // LEFT
                        x++;
                        break;
                    }
                }
            }
            Position position = new Position(x, y);
            int positionColor = 0;
            if (white.contains(position)) {
                positionColor = 1;
            }
            computer.setInputNumber(positionColor);
            computer.compute();
        }
        int minX = 10000;
        int minY = 10000;
        int maxX = -10000;
        int maxY = -10000;
        for (Position pos : white) {
            if (minX > pos.getX()) minX = pos.getX();
            if (minY > pos.getY()) minY = pos.getY();
            if (maxX < pos.getX()) maxX = pos.getX();
            if (maxY < pos.getY()) maxY = pos.getY();
        }

        for (int j = minY; j < maxY + 1; j++) {
            for (int i = maxX; i > minX - 1; i--) {
                Position pos = new Position(i, j);
                if (white.contains(pos)) {
                    System.out.print("\u2588");
                } else {
                    System.out.print("\u2591");
                }
            }
            System.out.print("\n");
        }
    }
}
