package test;

import java.awt.Color;
import org.nhnacademy.cannonball.BoundedBall;
import org.nhnacademy.cannonball.BoundedWorld;
import org.nhnacademy.cannonball.Motion;
import org.nhnacademy.cannonball.Point;

public class TestBoundedWorld {
    public static void main(String[] args) throws InterruptedException {
        BoundedWorld world = new BoundedWorld(500, 400);

        BoundedBall ball = new BoundedBall(new Point(100, 100), 40, Color.BLACK);
        Motion motion = new Motion();
        motion.setVelocity(20);
        motion.setAngle(40);
        ball.setMotion(motion);
        world.add(ball);
        world.setVisible(true);
        world.run(100);
    }
}
