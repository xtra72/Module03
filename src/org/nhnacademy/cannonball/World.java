package org.nhnacademy.cannonball;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

import java.util.LinkedList;

public class World extends Frame implements ActionListener {
    List<Shape> shapes;

    public World(int width, int height) {
        super();

        shapes = new LinkedList<>();

        prepareDashboard(width, height);
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for(Shape shape : shapes) {
            shape.draw(graphics,
                    location -> new Point(location.getX(), getHeight() - location.getY())
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BoundedBall ball = new BoundedBall( new Point(30, 30), 20, Color.BLACK);
        ball.setMotion(new Motion.MotionBuilderVA(20, 40).build());

        add(ball);
    }

    public void prepareDashboard(int width, int height) {
        Button fireButton = new Button("Click");
        fireButton.setBounds(50, 100, 80, 30);
        fireButton.addActionListener(this);

        add(fireButton);

        setLayout(null);
        setSize(width, height);

    }
}
