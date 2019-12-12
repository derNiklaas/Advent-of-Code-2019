package de.derniklaas.adventofcode.year_2019.day12;

public class Planet {

    private Position3D positon;
    private int velocityX, velocityY, velocityZ;

    public Planet(int x, int y, int z, int velocityX, int velocityY, int velocityZ) {
        positon = new Position3D(x, y, z);
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
        this.positon.setX(positon.getX() + velocityX);
        this.positon.setY(positon.getY() + velocityY);
        this.positon.setZ(positon.getZ() + velocityZ);
    }

    public int getPotentialEnergy() {
        return Math.abs(positon.getX()) + Math.abs(positon.getY()) + Math.abs(positon.getZ());
    }

    public int getKinecticEnergy() {
        return Math.abs(velocityX) + Math.abs(velocityY) + Math.abs(velocityZ);
    }

    public int getTotalEnergy() {
        return getPotentialEnergy() * getKinecticEnergy();
    }

    public int getX() {
        return positon.getX();
    }

    public int getY() {
        return positon.getY();
    }

    public int getZ() {
        return positon.getZ();
    }

    public Position3D getPositon() {
        return positon;
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
