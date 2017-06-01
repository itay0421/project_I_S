package geometries;

import Elements.Camera;
import org.junit.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */
public class TriangleTest {

    @Test
    public  void getNormalTest(){
        Triangle triangle = new Triangle(new Point3D( 0, 0, 0),
                new Point3D( 0, 1, 0),
                new Point3D(1, 0, 0));

        Vector N = new Vector(triangle.getNormal(triangle.getP1()));

        System.out.println(N);

        Vector exp = new Vector(0,0,-1);
        assertEquals(N.toString(),exp.toString());


    }

    /*** Triangle test ***/
    @Test
    public void TriangleIntersectionPointsTest(){
        final int WIDTH = 3;
        final int HEIGHT = 3;
        Ray[][] rays = new Ray [HEIGHT][WIDTH];
        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector(0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));
        Triangle triangle = new Triangle(new Point3D( 0, 1, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));
        Triangle triangle2 = new Triangle(new Point3D( 0, 10, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));
        List<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();
        System.out.println("Camera:\n" + camera);
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                rays[i][j] = camera.constructRayThroughPixel
                        (WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                List<Point3D> rayIntersectionPoints = triangle. FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2 = triangle2.FindIntersections(rays[i][j]);
                for (Point3D iPoint: rayIntersectionPoints)
                    intersectionPointsTriangle.add(iPoint);
                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsTriangle2.add(iPoint);
            }
        }
        //***********
        System.out.println(intersectionPointsTriangle.size());
        System.out.println(intersectionPointsTriangle2.size());

        assertTrue(intersectionPointsTriangle.size() == 1);
        assertTrue(intersectionPointsTriangle2.size() == 2);
        System.out.println("Intersection Points:");
        for (Point3D iPoint: intersectionPointsTriangle)
            System.out.println(iPoint);
        System.out.println("--");
        for (Point3D iPoint: intersectionPointsTriangle2)
            System.out.println(iPoint);
    }

    //***********
    @Test
    public void testFindIntersections() {
        System.out.println("FindIntersections");
        int count=0;
        Camera c=new Camera();
        Coordinate c1=new Coordinate(-1);
        Coordinate c2=new Coordinate(-1);
        Coordinate c3=new Coordinate(-2);

        Coordinate c4=new Coordinate(1);
        Coordinate c5=new Coordinate(-1);
        Coordinate c6=new Coordinate(-2);

        Coordinate c7=new Coordinate(0);
        Coordinate c8=new Coordinate(10);
        Coordinate c9=new Coordinate(-2);

        Triangle instance2=new Triangle(new Point3D(c1,c2,c3),new Point3D(c4,c5,c6),new Point3D(c7,c8,c9));
        //Sphere instance = new Sphere(new Point3D(new Coordinate(),new Coordinate(),new Coordinate()),5.0);
        ArrayList<Ray> rayList=new ArrayList<Ray>();
        ArrayList<ArrayList<Point3D>> list=new ArrayList<ArrayList<Point3D>>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
            }
        }
        for (Ray ray : rayList) {
            ArrayList<Point3D> listOfPoints = new ArrayList<Point3D>(instance2.FindIntersections(ray));
            list.add(listOfPoints);
        }

        for (ArrayList<Point3D> arrayList : list) {
            count+=arrayList.size();
        }
        int result=count;
        int expResult = 2;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}