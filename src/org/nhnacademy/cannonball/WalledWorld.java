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
            if(shape instanceof Boundable) {
                if (leftWall.isCollision(shape.getRegion()) || rightWall.isCollision(shape.getRegion())) {
                    ((Boundable)shape).turnX();
                }

                if (topWall.isCollision(shape.getRegion()) || bottomWall.isCollision(shape.getRegion())) {
                    ((Boundable)shape).turnY();
                }

                shapes.stream().filter(x -> x != shape)
                        .filter(x -> x.getRegion().isCollision(shape.getRegion()))
                        .forEach(x -> {
                            double dx = shape.getX() - x.getX();
                            double dy = shape.getY() - x.getY();

                            double velocity = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                            int angle = Math.abs((int)Math.toDegrees(Math.asin(dy / velocity))) % 180;
                            if (angle < 45 || angle > 135) {
                                ((Boundable) shape).turnX();
                            } else {
                                ((Boundable) shape).turnY();
                            }
                        });
            }
        }
    }
}
