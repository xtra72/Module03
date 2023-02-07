package org.nhnacademy.cannonball;

import java.awt.Graphics;
import java.util.function.UnaryOperator;

abstract class Shape {
    Point location;

    Shape(Point location) {
        this.location = location;
    }

    abstract double getX();
    abstract double getY();
    abstract Region getRegion();
    abstract void draw(Graphics graphics);
    abstract void draw(Graphics graphics, UnaryOperator<Point>translate);
}
