package org.nhnacademy.cannonball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.UnaryOperator;

public class Box extends Shape {
    double width;
    double height;
    Color color;

    public Box(Point location, double width, double height, Color color) {
        super(location);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Box(Point location, double width, double height) {
        this(location, width, height, Color.BLACK);
    }

    public double getX() {
        return  location.getX();
    }

    public double getY() {
        return  location.getY();
    }

    public double getWidth() {
        return  width;
    }

    public double getHeight() {
        return  height;
    }

    public Region getRegion() {
        return  new Region(location.getX() - width / 2, location.getY() - height / 2, width, height);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int) (location.getX() - width / 2), (int) (location.getY() - height / 2), (int) width, (int) height);
    }

    public void draw(Graphics graphics, UnaryOperator<Point> translate) {
        Point newLocation = translate.apply(location);

        graphics.setColor(color);
        graphics.fillRect((int) (newLocation.getX() - width / 2), (int) (newLocation.getY() - height / 2), (int) width, (int) height);
    }
}
