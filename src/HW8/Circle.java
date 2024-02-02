package HW8;

public class Circle implements Shape{
    private Point center;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    public double calculateArea() {
        return radius * radius * 3.14d;
    }
}
