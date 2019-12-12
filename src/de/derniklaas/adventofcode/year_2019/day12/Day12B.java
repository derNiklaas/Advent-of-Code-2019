package de.derniklaas.adventofcode.year_2019.day12;

public class Day12B {

    public static void main(String[] args) {
        Planet io = new Planet(6, -2, -7);
        Planet europa = new Planet(-6, -7, -4);
        Planet ganymede = new Planet(-9, 11, 0);
        Planet callisto = new Planet(-3, -4, 6);

        Position3D start0 = io.getPositon().clone();
        Position3D start1 = europa.getPositon().clone();
        Position3D start2 = ganymede.getPositon().clone();
        Position3D start3 = callisto.getPositon().clone();

        Position3D[] startingPositions = new Position3D[]{start0, start1, start2, start3};

        Planet[] planets = new Planet[]{io, europa, ganymede, callisto};

        long steps = 0;
        int xSteps = -1;
        int ySteps = -1;
        int zSteps = -1;
        while (true) {
            steps++;
            for (int i = 0; i < planets.length; i++) {
                int xVel = 0, yVel = 0, zVel = 0;
                for (int i2 = 0; i2 < planets.length; i2++) {
                    if (i != i2) {
                        xVel += getVelocityChange(planets[i].getX(), planets[i2].getX());
                        yVel += getVelocityChange(planets[i].getY(), planets[i2].getY());
                        zVel += getVelocityChange(planets[i].getZ(), planets[i2].getZ());
                    }
                }
                planets[i].applyGravity(xVel, yVel, zVel);
            }
            for (Planet planet : planets) {
                planet.tick();
            }
            int matchesX = 0, matchesY = 0, matchesZ = 0;
            for (int i = 0; i < startingPositions.length; i++) {
                if (planets[i].getVelocityX() == 0 && planets[i].getPositon().getX() == startingPositions[i].getX()) {
                    matchesX++;
                }
                if (planets[i].getVelocityY() == 0 && planets[i].getPositon().getY() == startingPositions[i].getY()) {
                    matchesY++;
                }
                if (planets[i].getVelocityZ() == 0 && planets[i].getPositon().getZ() == startingPositions[i].getZ()) {
                    matchesZ++;
                }
            }
            if (matchesX == 4) {
                if (xSteps == -1) xSteps = (int) steps;
            }
            if (matchesY == 4) {
                if (ySteps == -1) ySteps = (int) steps;
            }
            if (matchesZ == 4) {
                if (zSteps == -1) zSteps = (int) steps;
            }
            if (zSteps != -1 && xSteps != -1 && ySteps != -1) {
                break;
            }
        }
        System.out.printf("Steps for cycle: X %d Y %d Z %d \n", xSteps, ySteps, zSteps);
        long output = lcm(lcm(xSteps, ySteps), zSteps);
        System.out.printf("[Day 12/B] It needs %d stesp to reset the universe. \n", output);
    }

    /**
     * @param number1 the first number
     * @param number2 the second number
     * @return +1 if number1 < number2, 0 if number1 == number2, -1 if number1 > number2
     */
    private static int getVelocityChange(int number1, int number2) {
        return Integer.compare(number2, number1);
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
