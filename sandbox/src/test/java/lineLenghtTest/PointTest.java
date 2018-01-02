package lineLenghtTest;


import autoLineLenght.Point;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTest {

    @Test
    public void firstTest (){

        Point p1 = new Point(8,3);
        Point p2 = new Point(5,1);

        double notRoundedlineLenght = p1.distanceBetweenTwoPoints(p2);
        double roundedLineLenght = Math.round(p1.distanceBetweenTwoPoints(p2));

        System.out.println("Длина отрезка без округления равна: " + notRoundedlineLenght);
        System.out.println("Длина отрезка с округлением равна: " + roundedLineLenght);

        // проверка того, что округлённое значение длины отрезка равно 4
         Assert.assertEquals(roundedLineLenght,4.0);


        // проверка того, что не округлённое значение длины отрезка не равно 4
        Assert.assertNotEquals(notRoundedlineLenght,4.0);

    }
}
