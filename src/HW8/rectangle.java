package HW8;

public class Rectangle implements Shape{
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

    private Point point4;

    public Point getPoint4() {
        return point4;
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4){
        if (p1.getDistance(p2)*p1.getDistance(p2)+p1.getDistance(p4)*p1.getDistance(p4)==p2.getDistance(p4)*p2.getDistance(p4)&&p1.getDistance(p2)*p1.getDistance(p2)+p3.getDistance(p2)*p3.getDistance(p2)==p1.getDistance(p3)*p1.getDistance(p3)&&p1.getDistance(p4)*p1.getDistance(p4)+p3.getDistance(p4)*p3.getDistance(p4)==p1.getDistance(p3)*p1.getDistance(p3)){
            throw new RuntimeException("Rectangle does not exist! Adjacent sides of a square are not perpendicular!");
        } else {
            this.point1 = p1;
            this.point2 = p2;
            this.point3 = p3;
            this.point4 = p4;
        }
    }
    @Override
    public double calculateArea() {
        return this.getPoint1().getDistance(this.getPoint2())*this.getPoint1().getDistance(this.getPoint3());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (this.getPoint1().equals(((Rectangle) o).getPoint1()) && this.getPoint2().equals(((Rectangle) o).getPoint2()) && this.getPoint3().equals(((Rectangle) o).getPoint3())){
            return true;
        }
        return false;
    }
}
