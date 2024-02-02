package HW8;

public class Triangle implements Shape{
    private Point point1;
    public Point getPoint1() {
        return point1;
    }
    private Point point2;
    public Point getPoint2() {
        return point2;
    }
    private Point point3;

    public Point getPoint3() {
        return point3;
    }
    public Triangle(Point point1, Point point2, Point point3) {
        if(point1.doesThreePointsLieOnTheSameLine(point2, point3)) {
            throw new RuntimeException("This triangle can not exist! Three points lie on the same line!");
        } else {
            this.point1 = point1;
            this.point2 = point2;
            this.point3 = point3;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (this.getPoint1().equals(((Triangle) o).getPoint1()) && this.getPoint2().equals(((Triangle) o).getPoint2()) && this.getPoint3().equals(((Triangle) o).getPoint3())){
            return true;
        }
        return false;
    }
    @Override
    public double calculateArea() {
        double halfPerimeter = (point1.getDistance(point2)+point2.getDistance(point3)+point3.getDistance(point1))/2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-this.point1.getDistance(this.point2))*(halfPerimeter-this.point2.getDistance(this.point3))*(halfPerimeter-this.point1.getDistance(this.point3)));
    }
}
