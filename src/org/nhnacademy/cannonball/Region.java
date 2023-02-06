package org.nhnacademy.cannonball;

import java.awt.Rectangle;

public class Region extends Rectangle{
    public Region(double x, double y, double width, double height) {
        super((int) x, (int) y, (int) width, (int)height);
    }

    public boolean isCollision(Region region) {
        return  intersects(region);
    }
}
