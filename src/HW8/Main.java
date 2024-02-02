package HW8;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(0.0d, 0.0d);
        Point p2 = new Point(0.0, 1.0);
        Point p3 = new Point(2.0, 1.0);
        Point p4 = new Point(1.0, 0.0);
        Quad q = new Quad(p1, p2, p3, p4);
        System.out.println(p1.doesThreePointsLieOnTheSameLine(p2, p3));
    }
}
