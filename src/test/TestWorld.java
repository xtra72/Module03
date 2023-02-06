package test;

import java.util.Random;
import java.awt.Color;
import org.nhnacademy.cannonball.Ball;
import org.nhnacademy.cannonball.Point;
import org.nhnacademy.cannonball.World;

public class TestWorld {
    public static void main(String[] args) {
        World world = new World(500, 400) ;

        Random random = new Random();

        for(int i = 0 ; i < 10 ; i++) {
            double radius = 10.0 + random.nextInt(40);
            world.add(new Ball(new Point((int) (radius +  random.nextInt((int) (world.getWidth() - 2 * radius))),
                                         (int) (radius +  random.nextInt((int) (world.getHeight() - 2 * radius)))),
                               radius, Color.BLACK));

        }

        world.setVisible(true);
    }

}
