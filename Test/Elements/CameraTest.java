package Elements;

import org.junit.Test;
import primitives.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */
public class CameraTest {




    @Test
    public void testRaysConstruction1(){
        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        System.out.println("vR "+ camera.vRight());
        Ray ray = camera.constructRayThroughPixel(
                3, 3, 3, 3, 100,  150,  150);
        System.out.println("p00" + ray.get_POO());
        System.out.println(ray.get_direction());

        Ray expected = new Ray(camera.get_P0() ,new Vector(   0.58,-0.58,-0.58));
        assertEquals(expected.get_direction().toString(), ray.get_direction().toString());

    }
    /*** Camera test ***/
    @Test
    public void testRaysConstruction(){
        final int WIDTH = 3;
        final int HEIGHT = 3;
        Point3D[][] screen = new Point3D [HEIGHT][WIDTH];
        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));
        System.out.println("Camera:\n" + camera);
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                Ray ray = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                screen[i][j] = ray.get_POO();
                System.out.print(screen[i][j]);
                System.out.println(ray.get_direction());
                    // Checking z-coordinate
                assertTrue(Double.compare(screen[i][j].getZ().getCoordinate(), -1.0) == 0);
                    // Checking all options
                double x = screen[i][j].getX().getCoordinate();
                double y = screen[i][j].getX().getCoordinate();
                if (Double.compare(x, 3) == 0 ||
                        Double.compare(x, 0) == 0 ||
                        Double.compare(x, -3) == 0){
                    if (Double.compare(y, 3) == 0 ||
                            Double.compare(y, 0) == 0 ||
                            Double.compare(y, -3) == 0){
                        assertTrue(true);
                    }
                    else
                        fail("Wrong y coordinate");
                } else
                    fail("Wrong x coordinate");
            }
            System.out.println("---");
        }
    }

}