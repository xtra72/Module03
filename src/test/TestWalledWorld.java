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
        world.setInterval(100);

        Random random = new Random();
        double radius = 20.0;
        Point location = new Point(30, 30);
        BoundedBall ball = new BoundedBall(location, radius, colors[random.nextInt(colors.length)]);
        ball.setMotion(new Motion.MotionBuilderVA(20, 40).build());
        world.add(ball);

        world.setVisible(true);
        world.run(100);
    }
}
