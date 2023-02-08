package org.nhnacademy.cannonball;

import java.awt.Graphics;
import java.util.function.UnaryOperator;

public class Cannon extends Shape {

    public Cannon(Point location) {
        super(location);
    }

    public Region getRegion() {
        return  new Region(location.getX() - 50, location.getY() - 40, 100, 80);
    }

    public void draw(Graphics graphics) {
        graphics.fillRect((int) (location.getX() - 30), (int) (location.getY() - 30), 60, 60);
    }

    public void draw(Graphics graphics, UnaryOperator<Point> translate) {
        Point newLocation = translate.apply(location);

        graphics.fillRect((int) (newLocation.getX() - 30), (int) (newLocation.getY() - 30), 60, 60);
    }
}
