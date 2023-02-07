package org.nhnacademy.cannonball;

import java.awt.Color;

public class MovableBox extends Box implements Movable {
    Motion motion;

    public MovableBox(Point location, double width, double height, Color color) {
        super(location, width, height, color);
        motion = new Motion();
    }

    public Motion getMotion() {
        return  motion;
    }

    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public double getVelocity() {
        return  motion.getVelocity();
    }

    public void setVelocity(double velocity) {
        this.motion.setVelocity(velocity);
    }

    public double getAngle() {
        return  motion.getAngle();
    }

    public void setAngle(double angle) {
        this.motion.setAngle(angle);
    }

    public void next() {
        location.move(motion.getDX(), motion.getDY());
    }
}
