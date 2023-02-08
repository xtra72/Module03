package org.nhnacademy.cannonball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.UnaryOperator;

public class Ball extends Shape {
    double radius;
    Color color;

    public Ball(Point location, double radius, Color color) {
        super(location);
        this.location = location;
        this.radius = radius;
        this.color = color;
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

    public void draw(Graphics graphics, UnaryOperator<Point>translate) {
        Point newLocation = translate.apply(location);

        graphics.setColor(color);
        graphics.fillOval((int) (newLocation.getX() - radius), (int) (newLocation.getY() - radius), (int) (2 * radius), (int) (2 * radius));
    }
}
