package org.nhnacademy.cannonball;

public class BoundedWorld extends MovableWorld {
    public BoundedWorld(int width, int height) {
        super(width, height);
    }

    public void add(Shape shape) {
        if (shape instanceof Boundable ) {
            ((Boundable)shape).setBounds(new Region(0, 0, getWidth(), getHeight()));
        }

        super.add(shape);
    }
}
