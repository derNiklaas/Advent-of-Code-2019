package de.derniklaas.adventofcode.year_2019.day10;

import de.derniklaas.adventofcode.year_2019.Position;

import java.util.ArrayList;

public class Day10A {

    private static String input = "#.#.##..#.###...##.#....##....###\n...#..#.#.##.....#..##.#...###..#\n####...#..#.##...#.##..####..#.#.\n..#.#..#...#..####.##....#..####.\n....##...#.##...#.#.#...#.#..##..\n.#....#.##.#.##......#..#..#..#..\n.#.......#.....#.....#...###.....\n#.#.#.##..#.#...###.#.###....#..#\n#.#..........##..###.......#...##\n#.#.........##...##.#.##..####..#\n###.#..#####...#..#.#...#..#.#...\n.##.#.##.........####.#.#...##...\n..##...#..###.....#.#...#.#..#.##\n.#...#.....#....##...##...###...#\n###...#..#....#............#.....\n.#####.#......#.......#.#.##..#.#\n#.#......#.#.#.#.......##..##..##\n.#.##...##..#..##...##...##.....#\n#.#...#.#.#.#.#..#...#...##...#.#\n##.#..#....#..##.#.#....#.##...##\n...###.#.#.......#.#..#..#...#.##\n.....##......#.....#..###.....##.\n........##..#.#........##.......#\n#.##.##...##..###.#....#....###.#\n..##.##....##.#..#.##..#.....#...\n.#.#....##..###.#...##.#.#.#..#..\n..#..##.##.#.##....#...#.........\n#...#.#.#....#.......#.#...#..#.#\n...###.##.#...#..#...##...##....#\n...#..#.#.#..#####...#.#...####.#\n##.#...#..##..#..###.#..........#\n..........#..##..#..###...#..#...\n.#.##...#....##.....#.#...##...##";

    private static ArrayList<Position> asteroids = new ArrayList<>();
    private static int maxX, maxY;

    public static void main(String[] args) {
        String[] lines = input.split("\n");
        maxX = lines[0].toCharArray().length;
        maxY = lines.length;
        int maxCount = 0;
        Position best = new Position(0, 0);
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (lines[y].toCharArray()[x] == '#') {
                    asteroids.add(new Position(x, y));
                }
            }
        }

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                int count = 0;
                for (int y2 = 0; y2 < maxY; y2++) {
                    for (int x2 = 0; x2 < maxX; x2++) {
                        if (checkLineOfSight(x, y, x2, y2)) count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    best = new Position(x, y);
                }
            }
        }
        System.out.println("X: " + best.getX() + " Y: " + best.getY());
        System.out.println(maxCount);

    }

    private static boolean checkLineOfSight(int startX, int startY, int stopX, int stopY) {
        Position start = new Position(startX, startY);
        Position stop = new Position(stopX, stopY);
        if (!asteroids.contains(start)) return false;
        if (!asteroids.contains(stop)) return false;
        if (start.equals(stop)) return false;
        int dy = stopY - startY;
        int dx = stopX - startX;
        if (dx == dy && dy == 0) {
        } else {
            int gcd = getGCD(dy, dx);
            dy /= gcd;
            dx /= gcd;
        }
        int x = startX + dx;
        int y = startY + dy;
        while (y < maxY && y >= 0 && x < maxX && x >= 0) {
            Position pos = new Position(x, y);
            if (asteroids.contains(pos)) {
                if (y == stopY && x == stopX) {
                    return true;
                } else {
                    return false;
                }
            }
            x += dx;
            y += dy;
        }
        return false;
    }

    private static int getGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
