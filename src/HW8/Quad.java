package HW8;

public class Quad implements Shape{
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    public Quad(Point p1,Point p2,Point p3, Point p4){
        if (p1.getDistance(p2)*p1.getDistance(p2)+p1.getDistance(p4)*p1.getDistance(p4)==p2.getDistance(p4)*p2.getDistance(p4)&&p1.getDistance(p2)*p1.getDistance(p2)+p3.getDistance(p2)*p3.getDistance(p2)==p1.getDistance(p3)*p1.getDistance(p3)&&p1.getDistance(p4)*p1.getDistance(p4)+p3.getDistance(p4)*p3.getDistance(p4)==p1.getDistance(p3)*p1.getDistance(p3)){
            throw new RuntimeException("Quad does not exist! Adjacent sides of a square are not perpendicular!");
        } else if(p1.getDistance(p2)!=p2.getDistance(p3)) {
            throw new RuntimeException("Quad does not exist! The sides of quad are have to equal each other!");
        } else {
            this.point1 = p1;
            this.point2 = p2;
            this.point3 = p3;
            this.point4 = p4;
        }
    }
}
