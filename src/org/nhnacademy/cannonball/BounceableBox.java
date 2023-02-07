package org.nhnacademy.cannonball;

import java.awt.Color;

public class BounceableBox extends MovableBox implements Bounceable {
    public BounceableBox(Point location, double width, double height, Color color) {
        super(location, width, height, color);
    }

    public void turnX() {
        motion.setDX(-motion.getDX());
    }

    public void turnY() {
        motion.setDY(-motion.getDY());
    }

    @Override
    public void next() {
        super.next();
    }
}
