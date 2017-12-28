package autoLineLenght;

import org.testng.annotations.Test;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceBetweenTwoPoints(Point p) {
        return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }

    @Test
    public void firstTest (){

    }
}
