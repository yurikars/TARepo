package autoLineLenght;

public class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance (Point p1, Point p2){
        double dx = Math.pow((p2.x - p1.x),2);
        double dy = Math.pow((p2.y - p1.y),2);
        return Math.sqrt(dx + dy);
    }
}
