package test;

import java.awt.Color;
import java.util.Random;
import org.nhnacademy.cannonball.BoundedBall;
import org.nhnacademy.cannonball.BoundedBox;
import org.nhnacademy.cannonball.WalledWorld;
import org.nhnacademy.cannonball.Motion;
import org.nhnacademy.cannonball.Point;

public class TestWalledWorld {
    public static void main(String[] args) throws InterruptedException {
        Color [] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK, Color.GRAY};
        WalledWorld world = new WalledWorld(500, 400);
        world.setInterval(10);

        Random random = new Random();
        double radius = 20.0 + random.nextInt(20);
        Point location = new Point(radius + random.nextInt((int) (world.getWidth() - 2 * radius)),
                radius + random.nextInt((int) (world.getHeight() - 2 * radius)));
        BoundedBall ball = new BoundedBall(location, radius, colors[random.nextInt(colors.length)]);
        Motion motion = new Motion();
        motion.setVelocity(2);
        motion.setAngle(40);
        ball.setMotion(motion);
        world.add(ball);

        double width = 20.0 + random.nextInt(20);
        double height = 20.0 + random.nextInt(20);
        Point location2 = new Point(radius + random.nextInt((int) (world.getWidth() - 2 * radius)),
                radius + random.nextInt((int) (world.getHeight() - 2 * radius)));
        BoundedBox box = new BoundedBox(location2, width, height, colors[random.nextInt(colors.length)]);
        Motion motion2 = new Motion();
        motion2.setVelocity(3);
        motion2.setAngle(40);
        box.setMotion(motion2);
        world.add(box);

        world.setVisible(true);
        world.run(100);
    }
}
