package org.nhnacademy.cannonball;

import java.awt.Color;

public class MovableBall extends Ball {
    double velocity;
    double angle;

    public MovableBall(Point location, double radius, Color color) {
        super(location, radius, color);
        velocity = 0;
        angle = 0;
    }

    public double getVelocity() {
        return  velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAngle() {
        return  angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void next() {
        double radius = Math.toRadians(angle);
        double dx = velocity * Math.cos(radius);
        double dy = velocity * Math.sin(radius);

        location.move(dx, dy);
    }
}
