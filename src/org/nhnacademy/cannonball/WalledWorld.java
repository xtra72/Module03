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

        for(Shape shape : shapes) {
            if(shape instanceof BoundedBall) {
                if (leftWall.isCollision(((BoundedBall)shape).getRegion()) || rightWall.isCollision(((BoundedBall)shape).getRegion())) {
                    ((BoundedBall)shape).turnX();
                }

                if (topWall.isCollision(((BoundedBall)shape).getRegion()) || bottomWall.isCollision(((BoundedBall)shape).getRegion())) {
                    ((BoundedBall)shape).turnY();
                }

                shapes.stream().filter(x -> x != shape)
                        .filter(x -> x.getRegion().isCollision(shape.getRegion()))
                        .forEach(x -> ((BoundedBall) shape).turnX());
            }

            if (shape instanceof BoundedBox) {
                if (leftWall.isCollision(((BoundedBox) shape).getRegion())
                        || rightWall.isCollision(((BoundedBox) shape).getRegion())) {
                    ((BoundedBox) shape).turnX();
                }

                if (topWall.isCollision(((BoundedBox)shape).getRegion()) || bottomWall.isCollision(((BoundedBox)shape).getRegion())) {
                    ((BoundedBox)shape).turnY();
                }

                shapes.stream().filter(x -> x != shape)
                        .filter(x -> x.getRegion().isCollision(shape.getRegion()))
                        .forEach(x -> ((BoundedBox) shape).turnX());
            }
        }
    }
}
