package primitives;

import org.junit.Test;

import java.text.DecimalFormat;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by {Itay Amar and Shalom bloch} on 26 מרץ 2017.
 */
public class VectorTest {

    DecimalFormat df = new DecimalFormat("#.##");

    Vector vector1 = new Vector(2,2,2);
    Vector vector2 = new Vector(-2,-2,-2);
    Vector vector3 = new Vector(1,0,6);
    Vector vector4 = new Vector(6,0,3);
    Vector vector5 = new Vector(1,2,-2);
    Vector vector6 = new Vector(0,0,0);


    @Test
    public void compareTo() {
        assertEquals(0, vector1.compareTo(vector2));
        assertEquals(-1, vector1.compareTo(vector3));
    }



    
    @Test
    public void add() {
        vector1.add(vector2);
        vector2.add(vector3);
        assertEquals( "(0.00, 0.00, 0.00)",vector1.toString());
        assertEquals( "(-1.00, -2.00, 4.00)",vector2.toString());
    }

    @Test
    public void subtract() {
    vector1.subtract(vector2);
    vector2.subtract(vector3);
        assertEquals( "(4.00, 4.00, 4.00)",vector1.toString());
        assertEquals( "(-3.00, -2.00, -8.00)",vector2.toString());
    }

    @Test
    public void scale() {
        vector1.scale(2);
        vector3.scale(-4.5);
        assertEquals("(4.00, 4.00, 4.00)",vector1.toString());
        assertEquals("(-4.50, -0.00, -27.00)",vector3.toString());
    }

    @Test
    public void crossProduct() {
        assertEquals("(-6.00, 15.00, 12.00)",vector4.crossProduct(vector5).toString());

    }

    @Test
    public void length() {
        assertEquals("3.46",df.format(vector1.length()));
        assertEquals("3.46",df.format(vector2.length()));
        assertEquals("6.08",df.format(vector3.length()));

        ;

    }

    @Test
    public void normalize() {
        vector4.normalize();
        assertEquals("(0.89, 0.00, 0.45)",vector4.toString());

       // vector6.normalize();
        // assertEquals(new ArithmeticException(),vector6.toString());



    }

    @Test
    public void dotProduct() {
        assertEquals(0.0,vector1.dotProduct(vector6));
        assertEquals(14.0, vector1.dotProduct(vector3));

    }


}