package org.nhnacademy.cannonball;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Shape {
    double radius;
    Color color;

    public Ball(Point location, double radius, Color color) {
        super(location);
        this.location = location;
        this.radius = radius;
        this.color = color;
    }

    public double getX() {
        return  location.getX();
    }

    public double getY() {
        return  location.getY();
    }

    public double getRadius() {
        return  radius;
    }

    public Region getRegion() {
        return  new Region(location.getX() - radius, location.getY() - radius, 2 * radius, 2 * radius);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) (location.getX() - radius), (int) (location.getY() - radius), (int) (2 * radius), (int) (2 * radius));
    }
}
