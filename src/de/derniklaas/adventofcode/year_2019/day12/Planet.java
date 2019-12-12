package de.derniklaas.adventofcode.year_2019.day12;

public class Planet {

    private int x, y, z;
    private int velocityX, velocityY, velocityZ;

    public Planet(int x, int y, int z, int velocityX, int velocityY, int velocityZ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    public Planet(int x, int y, int z) {
        this(x, y, z, 0, 0, 0);
    }

    public void applyGravity(int xV, int yV, int zV) {
        this.velocityX += xV;
        this.velocityY += yV;
        this.velocityZ += zV;
    }

    public void tick() {
        this.x += velocityX;
        this.y += velocityY;
        this.z += velocityZ;
    }

    public int getPotentialEnergy() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    public int getKinecticEnergy() {
        return Math.abs(velocityX) + Math.abs(velocityY) + Math.abs(velocityZ);
    }

    public int getTotalEnergy() {
        return getPotentialEnergy() * getKinecticEnergy();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getVelocityZ() {
        return velocityZ;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getVelocityX() {
        return velocityX;
    }
}
