package org.nhnacademy.cannonball;

import java.awt.Color;

public class BoundedBall extends MovableBall implements Boundable, Bounceable {
    Region bounds;

    public BoundedBall(Point location, double radius, Color color) {
        super(location, radius, color);
        this.bounds = null;
    }

    public void setBounds(Region bounds) {
        this.bounds = bounds;
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
        if (bounds != null && bounds.isCollision(getRegion())) {
            if ((bounds.getX() + bounds.getWidth() < location.getX() + radius) || (location.getX() - radius < bounds.getX())) {
                turnX();
            }

            if ((bounds.getY() + bounds.getHeight() < location.getY() + radius) || (location.getY() - radius < bounds.getY())) {
                turnY();
            }
        }
    }
}
