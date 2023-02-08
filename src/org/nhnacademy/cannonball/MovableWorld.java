package org.nhnacademy.cannonball;

public class MovableWorld extends World {
    long interval;

    public MovableWorld(int width, int height)  {
        super(width, height);
        interval = 100;
    }

    public void setInterval(long millis) {
        interval = millis;
    }

    public long getInterval() {
        return  interval;
    }

    public void next() {
        shapes.stream()
                .filter(Movable.class::isInstance)
                .forEach(shape -> ((Movable)shape).next());
    //     for(Shape shape : shapes) {
    //         if (shape instanceof Movable) {
    //             ((Movable)shape).next();
    //         }
    //     }
    }

    public void run(long seconds) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        while(System.currentTimeMillis() < startTime + seconds * 1000) {
            next();
            repaint();
            Thread.sleep(interval);
        }
    }
}
