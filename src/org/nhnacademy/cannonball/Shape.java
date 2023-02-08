package org.nhnacademy.cannonball;

import java.awt.Graphics;
import java.util.function.UnaryOperator;

abstract class Shape {
    Point location;

    Shape(Point location) {
        this.location = location;
    }

    public double getX() {
        return  location.getX();
    }

    public double getY() {
        return  location.getY();
    }

    abstract Region getRegion();
    abstract void draw(Graphics graphics);
    abstract void draw(Graphics graphics, UnaryOperator<Point>translate);
}
