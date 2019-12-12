package de.derniklaas.adventofcode.year_2019.day12;

public class Day12A {

    /*
     * 6, -2, -7     | Io
     * -6, -7, -4    | Europa
     * -9, 11, 0     | Ganymede
     * -3, -4, 6     | Callisto
     *
     */

    public static void main(String[] args) {
        int steps = 1000;
        Planet io = new Planet(6, -2, -7);
        Planet europa = new Planet(-6, -7, -4);
        Planet ganymede = new Planet(-9, 11, 0);
        Planet callisto = new Planet(-3, -4, 6);

        /*
        1, 0, 2
        2, -10, -7
        4, -8, 8
        3, 5, -1
         */
        //Planet io = new Planet(-1, 0, 2);
        //Planet europa = new Planet(2, -10, -7);
        //Planet ganymede = new Planet(4, -8, 8);
        //Planet callisto = new Planet(3, 5, -1);
        Planet[] planets = new Planet[]{io, europa, ganymede, callisto};
        for (int simulations = 0; simulations < steps; simulations++) {
            //System.out.printf("--- Step %d ---\n", simulations +1);
            for (int i = 0; i < planets.length; i++) {

                int xVel = 0, yVel = 0, zVel = 0;
                for (int i2 = 0; i2 < planets.length; i2++) {
                    if (i != i2) {
                        //System.out.printf("Planet 1: %d %d %d | Planet 2: %d %d %d \n", planets[i].getX(), planets[i].getY(), planets[i].getZ(), planets[i2].getX(), planets[i2].getY(), planets[i2].getZ());
                        xVel += getVelocityChange(planets[i].getX(), planets[i2].getX());
                        yVel += getVelocityChange(planets[i].getY(), planets[i2].getY());
                        zVel += getVelocityChange(planets[i].getZ(), planets[i2].getZ());
                    }
                }
                planets[i].applyGravity(xVel, yVel, zVel);
            }
            for (Planet planet : planets) {
                planet.tick();
                //System.out.printf("%d %d %d | %d %d %d\n", planet.getX(), planet.getY(), planet.getZ(), planet.getVelocityX(), planet.getVelocityY(), planet.getVelocityZ());
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
