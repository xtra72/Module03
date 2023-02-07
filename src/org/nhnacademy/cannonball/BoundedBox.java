package org.nhnacademy.cannonball;

import java.awt.Color;

public class BoundedBox extends MovableBox implements Boundable {
    Region bounds;

    public BoundedBox(Point location, double width, double height, Color color) {
        super(location, width, height, color);
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
            if ((location.getX() + width / 2 < bounds.getX() - bounds.getWidth() / 2) || (bounds.getX() + bounds.getWidth() / 2  < location.getX() - width / 2)) {
                turnX();
            }

            if ((location.getY() + height / 2 < bounds.getY() - bounds.getHeight() / 2) || (bounds.getY() + bounds.getHeight() / 2  < location.getY() - height / 2)) {
                turnY();
            }
        }
    }
}
