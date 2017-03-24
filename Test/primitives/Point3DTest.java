package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by {Itay Amar and Shalom bloch} on 24 מרץ 2017.
 */
class Point3DTest {
    Point3D point3D_1 = new Point3D(1,2,2);
    Point3D point3D_2 = new Point3D(1,2,3);
    Vector vector_1 = new Vector(1.5,4.55555,2);
    Vector vector_2 = new Vector(3,3,3);


    @Test
    int compareTo() {
              assertEquals("2" ,point3D_1.compareTo(point3D_2) );;

        return 0;
    }

    @Test
    public String toString() {
        String str1 = vector_1.toString();
        String str2 = "(1.50,4.56,2.00)";
        assertEquals(str2,str1);
        return null;
    }

    @Test
    void add() {
        point3D_1.add(vector_1);
        assertEquals("(2.50,6.56,4.00)",point3D_1.toString());

    }

    @Test
    void subtract() {
    point3D_2.subtract(vector_2);
    assertEquals(point3D_2.toString(),"(-2.00,-1.00,0.00)"  );
    }

    @Test
    void distance() {
        point3D_1 = new Point3D(1,0,0);
        point3D_2 = new Point3D(-1,0,0);
        String str2 =String.valueOf(point3D_1.distance(point3D_2))     ;
        String str1 = String.format("%.2f" ,str2);
        assertEquals("2.00",str1);


    }

}