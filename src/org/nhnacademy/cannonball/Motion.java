package org.nhnacademy.cannonball;

public class Motion {
    double velocity;
    double angle;
    double dx;
    double dy;

    public Motion() {
        velocity = 0;
        angle = 0;
        dx = 0;
        dy = 0;
    }

    public Motion(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = angle;
        updateDXDY();
    }

    public Motion(Motion motion) {
        velocity = motion.getVelocity();
        angle = motion.getAngle();
        dx = motion.getDX();
        dy = motion.getDY();
    }

    public void add(Motion motion) {
        this.dx += motion.getDX();
        this.dy += motion.getDY();
        updateVelocityAndAngle();
    }

    public double getVelocity() {
        return  velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
        updateDXDY();
    }

    public void addVelocity(double velocity) {
        this.velocity += velocity;
        updateDXDY();
    }

    public double getAngle() {
        return  angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        updateDXDY();
    }

    public void addAngle(double angle) {
        this.angle += angle;
        updateDXDY();
    }

    public double getDX() {
        return  dx;
    }

    public void setDX(double dx) {
        this.dx= dx;
        updateVelocityAndAngle();
    }

    public void addDX(double dx) {
        this.dx += dx;
        updateVelocityAndAngle();
    }

    public double getDY() {
        return  dy;
    }

    public void setDY(double dy) {
        this.dy = dy;
        updateVelocityAndAngle();
    }

    public void addDY(double dy) {
        this.dy += dy;
        updateVelocityAndAngle();
    }

    public void updateDXDY() {
        double radian = Math.toRadians(angle);
        dx = velocity * Math.cos(radian);
        dy = velocity * Math.sin(radian);
    }

    public void updateVelocityAndAngle() {
        velocity = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        angle = Math.toDegrees(Math.asin(dy / velocity));
    }
}
