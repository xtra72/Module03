package org.nhnacademy.cannonball;

public class BoundedWorld extends MovableWorld {
    public BoundedWorld(int width, int height) {
        super(width, height);
    }

    public void add(BoundedBall ball) {
        ball.setBounds(new Region(0, 0, getWidth(), getHeight()));
        super.add(ball);
    }
}
