package org.nhnacademy.cannonball;

import java.awt.Color;

public class BounceableBall extends MovableBall implements Bounceable {
    public BounceableBall(Point location, double radius, Color color) {
        super(location, radius, color);
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
