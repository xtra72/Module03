package test;

import java.awt.Color;
import java.util.Random;
import org.nhnacademy.cannonball.BoundedBall;
import org.nhnacademy.cannonball.WalledWorld;
import org.nhnacademy.cannonball.Motion;
import org.nhnacademy.cannonball.Point;

public class TestWalledWorld {
    public static void main(String[] args) throws InterruptedException {
        Color [] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK, Color.GRAY};
        WalledWorld world = new WalledWorld(500, 400);

        Random random = new Random();
        for(int i = 0 ; i < 2 ; i++) {
            double radius = 10 + random.nextInt(40);
            Point location = new Point(radius + random.nextInt((int) (world.getWidth() - 2 * radius)),
                    radius + random.nextInt((int) (world.getHeight() - 2 * radius)));
            BoundedBall ball = new BoundedBall(location, radius, colors[random.nextInt(colors.length)]);
            Motion motion = new Motion();
            motion.setVelocity(20);
            motion.setAngle(40);
            ball.setMotion(motion);
            world.add(ball);
        }
        world.setVisible(true);
        world.run(100);
    }
}
