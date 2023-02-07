package org.nhnacademy.cannonball;

import java.awt.Graphics;

abstract class Shape {
    Point location;

    Shape(Point location) {
        this.location = location;
    }

    abstract Region getRegion();
    abstract void draw(Graphics graphics);
}
