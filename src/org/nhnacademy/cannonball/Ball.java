package org.nhnacademy.cannonball;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    double x;
    double y;
    double radius;
    Color color;

    public Ball(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public double getX() {
        return  x;
    }

    public double getY() {
        return  y;
    }

    public double getRadius() {
        return  radius;
    }

    public void draw(Graphics graphics) {
        graphics.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }
}
