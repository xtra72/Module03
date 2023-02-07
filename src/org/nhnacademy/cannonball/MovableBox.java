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
        this.motion.setAngle(motion.getAngle());
        this.motion.setVelocity(motion.getVelocity());
    }

    public void addMotion(Motion motion) {
        this.motion.addAngle(motion.getAngle());
        this.motion.addVelocity(motion.getVelocity());
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

    public void stop() {
        motion.setVelocity(0);
    }

    public void next() {
        location.move(motion.getDX(), motion.getDY());
    }
}
