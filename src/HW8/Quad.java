package HW8;

public class Quad implements Shape{
    private Point point1;
    public Point getPoint1(){
        return this.point1;
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
    public Quad(Point p1, Point p2, Point p3, Point p4){
        if (p1.getDistance(p2)*p1.getDistance(p2)+p1.getDistance(p4)*p1.getDistance(p4)==p2.getDistance(p4)*p2.getDistance(p4)&&p1.getDistance(p2)*p1.getDistance(p2)+p3.getDistance(p2)*p3.getDistance(p2)==p1.getDistance(p3)*p1.getDistance(p3)&&p1.getDistance(p4)*p1.getDistance(p4)+p3.getDistance(p4)*p3.getDistance(p4)==p1.getDistance(p3)*p1.getDistance(p3)){
            throw new RuntimeException("Quad does not exist! Adjacent sides of a square are not perpendicular!");
        } else if(p1.getDistance(p2)!=p2.getDistance(p3)) {
            throw new RuntimeException("Quad does not exist! The sides of quad have to equal each other!");
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
        if (this.getPoint1().equals(((Quad) o).getPoint1()) && this.getPoint2().equals(((Quad) o).getPoint2()) && this.getPoint3().equals(((Quad) o).getPoint3())){
            return true;
        }
        return false;
    }
    @Override
    public String getShapeType(){
        return "Quad";
    }
}