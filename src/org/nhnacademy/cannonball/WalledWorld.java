package org.nhnacademy.cannonball;

public class WalledWorld extends MovableWorld {
    Region  leftWall;
    Region  rightWall;
    Region  topWall;
    Region  bottomWall;

    public WalledWorld(int width, int height) {
        super(width, height);
        leftWall = new Region(-width, -height, width, 3.0 * height);
        rightWall = new Region(width, -height, width, 3.0 * height);
        topWall = new Region(-width, -height, 3.0 * width, height);
        bottomWall = new Region(-width, height, 3.0 * width, height);
    }

    @Override
    public void next() {
        super.next();

        for(Ball ball : balls) {
            if(ball instanceof BoundedBall) {
                if (leftWall.isCollision(((BoundedBall)ball).getRegion()) || rightWall.isCollision(((BoundedBall)ball).getRegion())) {
                    ((BoundedBall)ball).turnX();
                }

                if (topWall.isCollision(((BoundedBall)ball).getRegion()) || bottomWall.isCollision(((BoundedBall)ball).getRegion())) {
                    ((BoundedBall)ball).turnY();
                }
            }
        }
    }
}
