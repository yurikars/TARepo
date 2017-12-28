package autoLineLenght;

public class Runner {

    public static void main (String args []){
        Point p1 = new Point(8, 3);
        Point p2 = new Point(5,1);

        System.out.println("Расстояние между точками p1 и p2 без округления равно: " + p1.distanceBetweenTwoPoints(p2));

        }
    }
