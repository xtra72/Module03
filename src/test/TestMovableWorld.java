package test;

import java.awt.Color;
import java.util.Random;
import org.nhnacademy.cannonball.MovableBall;
import org.nhnacademy.cannonball.MovableWorld;
import org.nhnacademy.cannonball.Point;

public class TestMovableWorld {
    public static void main(String[] args) throws InterruptedException {
        MovableWorld world = new MovableWorld(500, 400);

        Random random = new Random();
        for(int i = 0 ; i < 10 ; i++) {
            double radius = 10.0 + random.nextInt(40);

            MovableBall ball = new MovableBall(new Point(radius + random.nextInt((int) (world.getWidth() - 2 * radius)),
                    radius + random.nextInt((int) (world.getHeight() - 2 * radius))),
                    radius, Color.BLACK);
            ball.setVelocity(10 + random.nextInt(40));
            ball.setAngle(random.nextInt(90));
            world.add(ball);
        }

        world.setVisible(true);
        world.run(100);
    }
}
