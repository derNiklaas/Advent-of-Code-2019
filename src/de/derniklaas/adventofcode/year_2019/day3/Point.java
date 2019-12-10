package de.derniklaas.adventofcode.year_2019.day3;

public class Point {

    private int x, y;
    private boolean visited = false;
    private boolean corner = false;

    public Point(int x, int y, boolean corner) {
        this.x = x;
        this.y = y;
        this.visited = false;
        this.corner = corner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point clone() {
        return new Point(x, y, corner);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setCorner(boolean corner) {
        this.corner = corner;
    }

    public boolean isCorner() {
        return this.corner;
    }
}
