package lineLenghtTest;


import autoLineLenght.Point;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTest {

    @Test
    public void firstTest (){

        Point p1 = new Point(8,3);
        Point p2 = new Point(5,1);

        double notRoundedlineLenght = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        double roundedLineLenght = Math.round(Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));

        System.out.println(notRoundedlineLenght);
        System.out.println(roundedLineLenght);

        Assert.assertEquals(roundedLineLenght,4.0);
        Assert.assertNotEquals(notRoundedlineLenght,4);
    }
}
