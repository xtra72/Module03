package org.nhnacademy.cannonball;

public class WalledWorld extends MovableWorld {
    public WalledWorld(int width, int height) {
        super(width, height);
        add(new Box(new Point(-width * 0.5, height * 0.5), width, 3.0 * height));
        add(new Box(new Point(width * 1.5, height * 0.5), width, 3.0 * height));
        add(new Box(new Point(width * 0.5, height * 1.5), 3.0 * width, height));
        add(new Box(new Point(width * 0.5, -height * 0.5), 3.0 * width, height));
    }

    @Override
    public void next() {
        super.next();

        for(Shape shape : shapes) {
            if(shape instanceof Boundable) {
                shapes.stream()
                        .filter(x -> x != shape)
                        .filter(x -> x.getRegion().isCollision(shape.getRegion()))
                        .forEach(x -> {
                            double dx = shape.getX() - x.getX();
                            double dy = shape.getY() - x.getY();

                            double velocity = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                            int angle = Math.abs((int)Math.toDegrees(Math.asin(dy / velocity))) % 180;
                            if (angle < 50 || angle > 130) {
                                ((Boundable) shape).turnX();
                            }
                            if (angle > 40 && angle < 140) {
                                ((Boundable) shape).turnY();
                            }
                        });
            }
        }
    }
}
