package de.derniklaas.adventofcode.year_2019.day12;

public class Day12A {

    public static void main(String[] args) {
        int steps = 1000;
        Planet io = new Planet(6, -2, -7);
        Planet europa = new Planet(-6, -7, -4);
        Planet ganymede = new Planet(-9, 11, 0);
        Planet callisto = new Planet(-3, -4, 6);
        Planet[] planets = new Planet[]{io, europa, ganymede, callisto};
        for (int simulations = 0; simulations < steps; simulations++) {
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
        }
        int sumOfTotalEnergy = 0;
        for (Planet planet : planets) {
            sumOfTotalEnergy += planet.getTotalEnergy();
        }
        System.out.printf("[Day 12/A] The sum of total Energy is %d \n", sumOfTotalEnergy);
    }

    /**
     * @param number1 the first number
     * @param number2 the second number
     * @return +1 if number1 < number2, 0 if number1 == number2, -1 if number1 > number2
     */
    private static int getVelocityChange(int number1, int number2) {
        return Integer.compare(number2, number1);
    }
}
