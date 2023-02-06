package org.nhnacademy.cannonball;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;

public class World extends Frame {
    List<Ball> balls;

    public World(int width, int height) {
        super();
        setSize(width, height);
        balls = new LinkedList<>();
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for(Ball ball : balls) {
            ball.draw(graphics);
        }
    }
}
