package primitives;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */
public class Point3DTest {
    Point3D point3D_1 = new Point3D(1,2,2);
    Point3D point3D_2 = new Point3D(1,2,2);
    Vector vector_1 = new Vector(1.5,4.55555,2);
    Vector vector_2 = new Vector(3,3,3);


    @Test
    public void compareTo() {
        assertEquals(0 ,point3D_1.compareTo(point3D_2) );


    }

    @Test
    public void Test01() {
        Assert.assertEquals(0, point3D_2.compareTo(point3D_1));
    }

    @Test
    public  void add() {
        point3D_1.add(vector_1);
        assertEquals("(2.50, 6.56, 4.00)",point3D_1.toString());

    }

    @Test
    public  void subtract() {
        point3D_2.subtract(vector_2);
        assertEquals(point3D_2.toString(),"(-2.00, -1.00, -1.00)"  );
    }

    @Test
    public  void distance() {
        point3D_1 = new Point3D(1,0,0);
        point3D_2 = new Point3D(-1,0,0);
        assertEquals(2.0, point3D_1.distance(point3D_2));

        point3D_1 = new Point3D(5.3,5.9,5);
        point3D_2 = new Point3D(-1,-3,-6);
        assertEquals("15.49" , String.format("%.2f", point3D_1.distance(point3D_2)));
    }


}