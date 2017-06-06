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
/**
public class TriangleTest {

    @Test
    public  void getNormalTest(){
        Triangle triangle = new Triangle(new Point3D( 0, 1, 0),
                new Point3D( 0, 1, 2),
                new Point3D(1, 2, 3));

        Vector N = new Vector(triangle.getNormal(triangle.getP1()));

        System.out.println(N);

        Vector exp = new Vector(-0.71,0.71,0);
        assertEquals(N.toString(),exp.toString());


    }

    /*** Triangle test ***/
/**    @Test
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
    @Test
    public void testFindIntersections2() {
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
        Coordinate c8=new Coordinate(1);
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
        int expResult = 1;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}*/


import Elements.Camera;
import org.junit.Test;
import primitives.Ray;
import primitives.Point3D;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yona on 10/05/2017.
 */
public class TriangleTest {
    /************************************** Camera test **************************************************************/
    @Test
    public void Test13()
    {

        final int WIDTH  = 10;
        final int HEIGHT = 10;

        Point3D[][] screen = new Point3D [HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        System.out.println("Test13: Camera test:\n" + camera);

        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {

                Ray ray = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                screen[i][j] = ray.get_POO();

                System.out.print(screen[i][j]);
                System.out.println(ray.get_direction());

                // Checking z-coordinate
                assertTrue(Double.compare(screen[i][j].getZ().getCoordinate(), -1.0) == 0);

                // Checking all options
                double x = screen[i][j].getX().getCoordinate();
                double y = screen[i][j].getY().getCoordinate();

                double[] values = {1.5,4.5,7.5,10.5,13.5};

                int k = 0;
                for(; k < values.length; k++)
                    if(values[k] == Math.abs(x))
                        break;
                if(k == values.length)
                    fail("Wrong x coordinate");

                k = 0;
                for(; k < values.length; k++)
                    if(values[k] == Math.abs(y))
                        break;
                if(k == values.length)
                    fail("Wrong Y coordinate");
            }
            System.out.println("---");
        }

    }

    /************************************** Triangle test ******************************************************/
    @Test
    public void Test14()
    {
        final int WIDTH  = 3;
        final int HEIGHT = 3;

        System.out.println("Test14: Triangle intersection test");

        Ray[][] rays = new Ray [HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        Triangle triangle1 = new Triangle(new Point3D( 0,  1, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));

        Triangle triangle2 = new Triangle(new Point3D( 0,  10, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));

        List<Point3D> intersectionPointsTriangle1 = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                List<Point3D> rayIntersectionPoints1  = triangle1.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2  = triangle2.FindIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints1)
                    intersectionPointsTriangle1.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsTriangle2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsTriangle1. size() == 1);
        assertTrue(intersectionPointsTriangle2.size() == 2);

        System.out.println("Intersection Points:");
        for (Point3D iPoint: intersectionPointsTriangle1){
            System.out.println(iPoint);
            assertEquals("Bad Intersection! ","(0.00, 0.00, -2.00)", iPoint.toString());
        }
        System.out.println("--");
        for(int i = 0; i < intersectionPointsTriangle2.size(); i++)
        {
            Point3D iPoint = intersectionPointsTriangle2.get(i);
            System.out.println(iPoint);
            switch(i)
            {
                case 0:
                    assertEquals("Bad Intersection! ","(0.00, 6.00, -2.00)", iPoint.toString());
                    break;
                case 1:
                    assertEquals("Bad Intersection! ","(0.00, 0.00, -2.00)", iPoint.toString());
                    break;
            }
        }
    }

    @Test
    public void Test15()
    {
        System.out.print("Test15: Triangle getNormal test: ");
        Triangle triangle = new Triangle(new Point3D( 0,  1, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));
        Vector normal = triangle.getNormal(new Point3D());
        System.out.println(normal);
        assertEquals("Bad normal! ", normal.toString(),"(-0.00, 0.00, 1.00)");
    }
    /************************************** Sphere test ******************************************************/
    @Test
    public void Test16(){

        final int WIDTH  = 3;
        final int HEIGHT = 3;

        System.out.println("Test16: Sphere intersection test");

        Ray[][] rays = new Ray [HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        Sphere sphere1 = new Sphere(1, new Point3D(0.0, 0.0, -3.0));
        Sphere sphere2 = new Sphere(10, new Point3D(0.0, 0.0, -3.0));

        // Only the center ray intersect the sphere in two locations
        List<Point3D> intersectionPointsSphere1 = new ArrayList<Point3D>();

        // The sphere encapsulates the view plane - all rays intersect with the sphere once
        List<Point3D> intersectionPointsSphere2 = new ArrayList<Point3D>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                List<Point3D> rayIntersectionPoints1 = sphere1.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2 = sphere2.FindIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints1)
                    intersectionPointsSphere1.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsSphere2.add(iPoint);

            }
        }

        assertTrue(intersectionPointsSphere1.size() == 2);
        assertTrue(intersectionPointsSphere2.size() == 9);

        System.out.println("Intersection Points:");
        for (Point3D iPoint: intersectionPointsSphere1)
        {

            assertTrue(iPoint.compareTo(new Point3D(0.0, 0.0, -2.0)) == 0 ||
                    iPoint.compareTo(new Point3D(0.0, 0.0, -4.0)) == 0);
            System.out.println(iPoint);
        }
    }
    @Test
    public void Test17()
    {
        System.out.print("Test17: Sphere getNormal test: ");
        Sphere sphere = new Sphere(10, new Point3D(0.0, 0.0, -3.0));
        Vector normal = sphere.getNormal(new Point3D(5.0,5.0,-3.0));
        System.out.println(normal);
        assertEquals("Bad normal! ", normal.toString(),"(0.71, 0.71, 0.00)");
    }
    /************************************ Plane test *****************************************************/
    @Test
    public void Test18()
    {

        final int WIDTH  = 3;
        final int HEIGHT = 3;

        System.out.println("Test18: Plane intersection test");

        Ray[][] rays = new Ray [HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        // plane orthogonal to the view plane
        Plane plane1  = new Plane(new Vector(0.0, 0.0, -1.0), new Point3D(0.0, 0.0, -3.0));

        // 45 degrees to the view plane
        Plane plane2 = new Plane(new Vector(0.0, 0.25, -1.0), new Point3D(0.0, 0.0, -3.0));

        List<Point3D> intersectionPointsPlane1 = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                List<Point3D> rayIntersectionPoints1  = plane1.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2  = plane2.FindIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints1)
                    intersectionPointsPlane1.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsPlane2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsPlane1.size() == 9);
        assertTrue(intersectionPointsPlane2.size() == 9);

        System.out.println("Plane1 intersetions");
        for (Point3D iPoint: intersectionPointsPlane1)
            System.out.println(iPoint);
        System.out.println("---");
        System.out.println("Plane2 intersetions");
        for (Point3D iPoint: intersectionPointsPlane2)
            System.out.println(iPoint);
    }





    @Test
    public void testIntersectionPoints(){
        final int WIDTH = 3;
        final int HEIGHT = 3;
        Ray[][] rays = new Ray [HEIGHT][WIDTH];
        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));
// plane orthogonal to the view plane
        Plane plane = new Plane(new Vector(0.0, 0.0, -1.0), new Point3D(0.0, 0.0, -3.0));
// 45 degrees to the view plane
        Plane plane2 = new Plane(new Vector(0.0, 0.25, -1.0), new Point3D(0.0, 0.0, -3.0));
        List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();
        System.out.println("Camera:\n" + camera);
        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                List<Point3D> rayIntersectionPoints = plane. FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2 = plane2.FindIntersections(rays[i][j]);
                for (Point3D iPoint: rayIntersectionPoints)
                    intersectionPointsPlane.add(iPoint);
                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsPlane2.add(iPoint);
            }
        }
        assertTrue(intersectionPointsPlane. size() == 9);
        assertTrue(intersectionPointsPlane2.size() == 9);
        for (Point3D iPoint: intersectionPointsPlane)
            System.out.println(iPoint);
        System.out.println("---");
        for (Point3D iPoint: intersectionPointsPlane2)
            System.out.println(iPoint);
    }

}