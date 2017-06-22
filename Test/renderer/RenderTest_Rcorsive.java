package renderer;

import Elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by itay0 on 22/06/2017.
 */
public class RenderTest_Rcorsive {
    @Test
    public void recursiveTest() throws Exception {
        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.set_nShininess(20);
        sphere2.set_emmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }


    @Test
    public void recursiveTest2() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere2.set_nShininess(20);
        sphere2.set_emmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));

        Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        triangle.set_emmission(new Color(20, 20, 20));
        triangle2.set_emmission(new Color(20, 20, 20));
        triangle.setKr(1);
        triangle2.setKr(0.5);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }

    @Test
    public void recursiveTest3() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -1000));
        sphere2.set_nShininess(20);
        sphere2.set_emmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        triangle.set_emmission(new Color(20, 20, 20));
        triangle2.set_emmission(new Color(20, 20, 20));
        triangle.setKr(1);
        triangle2.setKr(0.5);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }

}