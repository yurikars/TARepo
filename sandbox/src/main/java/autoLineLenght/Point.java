package autoLineLenght;

public class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distanceBetweenTwoPoints (Point p1, Point p2){
        double dx = Math.pow((p2.x - p1.x),2);
        double dy = Math.pow((p2.y - p1.y),2);
        return Math.sqrt(dx + dy);
    }

    public static void main (String args []){
        Point p1 = new Point(4,2);
        Point p2 = new Point(7,5);

        System.out.println("Расстояние между точками p1 и p2 без округления равно: " + distanceBetweenTwoPoints(p1,p2));
        System.out.println("Расстояние между точками p1 и p2 с округлением равно: " + Math.round(distanceBetweenTwoPoints(p1,p2)));
    }
}
