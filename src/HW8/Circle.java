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
    @Override
    public double calculateArea() {
        return radius * radius * 3.14d;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (((Circle) o).getCenter().equals(this.getCenter()) && this.getRadius() == ((Circle) o).getRadius()){
            return true;
        }
        return false;
    }
    @Override
    public String getShapeType(){
        return "Circle";
    }
}
