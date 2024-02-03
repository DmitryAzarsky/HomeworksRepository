package HW8;

public class Point {
    private double[] cords = new double[2];
    public double getX(){
        return cords[0];
    }
    public double getY(){
        return cords[1];
    }
    public double getDistance(Point anotherPoint) {
        return Math.sqrt((anotherPoint.getX() - this.getX())*(anotherPoint.getX() - this.getX())+(anotherPoint.getY() - this.getY())*(anotherPoint.getY() - this.getY()));
    }
    public boolean doesThreePointsLieOnTheSameLine(Point firstAnotherPoint, Point secondAnotherPoint){ // поверне true, якшо три точки належать одній прямій
        return this.getX()*firstAnotherPoint.getY()+this.getY()*secondAnotherPoint.getX()+firstAnotherPoint.getX()*secondAnotherPoint.getY()-firstAnotherPoint.getY()*secondAnotherPoint.getX()-this.getY()*firstAnotherPoint.getX()-secondAnotherPoint.getY()*this.getX() == 0;
    }
    public double[] getCords() {
        return cords;
    }
    public void setCords(double[] cords) {
        this.cords = cords;
    }
    public Point(double x, double y) {
        this.cords[0] = x;
        this.cords[1] = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (this.getX() == ((Point) o).getX() && this.getY() == ((Point) o).getY()){
            return true;
        }
        return false;
    }
    public String coordsToString(){
        return "(" + this.getX() + "; " + this.getY() + ")";
    }
}
