package org.nhnacademy.cannonball;

public class WalledWorld extends MovableWorld {
    final Box ground;
    final Motion gravity;

    public WalledWorld(int width, int height) {
        super(width, height);
        gravity = new Motion(9.8 / 10, -90);
        add(new Box(new Point(-width * 0.5, height * 0.5), width, 3.0 * height));
        add(new Box(new Point(width * 1.5, height * 0.5), width, 3.0 * height));
        add(new Box(new Point(width * 0.5, height * 1.5), 3.0 * width, height));
        ground = new Box(new Point(width * 0.5, -height * 0.5), 3.0 * width, height);
        add(ground);
    }

    @Override
    public void next() {
        for(Shape shape : shapes) {
            if (shape instanceof Movable) {
                ((Movable)shape).next();
                ((Movable)shape).addMotion(gravity);
            }

            if(shape instanceof Bounceable) {
                shapes.stream()
                        .filter(x -> x != shape)
                        .filter(x -> x.getRegion().isCollision(shape.getRegion()))
                        .forEach(x -> {
                            if (x == ground) {
                                ((Movable)shape).stop();
                            } else {
                                double dx = shape.getX() - x.getX();
                                double dy = shape.getY() - x.getY();

                                double velocity = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                                int angle = Math.abs((int) Math.toDegrees(Math.asin(dy / velocity))) % 180;
                                if (angle < 50 || angle > 130) {
                                    ((Bounceable) shape).turnX();
                                }
                                if (angle > 40 && angle < 140) {
                                    ((Bounceable) shape).turnY();
                                }
                            }
                        });
            }
        }
    }
}
