package geometries;

import junit.framework.TestCase;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */
public class PlaneTest extends TestCase {
    @Test
    public void findIntersections() throws Exception {
    }

    @Test
    public void getNormal() throws Exception {
    }

    @Test
    public void GetNormal() {
        System.out.println("getNormal");
        Point3D p = new Point3D(0.00,0.00,0.00);
        Plane instance = new Plane();
        Vector expResult = new Vector(0.00,0.00,0.00);
        Vector result = instance.getNormal(p);
        assertEquals(expResult, result);

    }
}