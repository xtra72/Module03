package org.nhnacademy.cannonball;

import java.awt.Color;

public class MovableBall extends Ball {
    Motion motion;

    public MovableBall(Point location, double radius, Color color) {
        super(location, radius, color);
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
