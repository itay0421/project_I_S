package renderer;

import Elements.Camera;
import Elements.PointLight;
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
 * Created by itay0 on 14/06/2017.
 */
public class RenderTest2 {
    @Test
    public void PointLightTest1() throws Exception {

        Scene scene = new Scene();
        scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, -1)));

        Triangle triangle = new Triangle(new Point3D(-3495, -3495, -1000),
                new Point3D(3500, -3500, -1000),
                new Point3D(2500, 2495, -1500));

        Triangle triangle2 = new Triangle(new Point3D(-3500, -3500, -1000),
                new Point3D(2495, 2500, -1500),
                new Point3D(-2500, 2500, -1500));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter("PointLight1", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }
    @Test
    public void PointLightTest2() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0,0,100));
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-300, -300, -150), 0.1, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("PointLightTest2", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }

    @Test
    public void SpotLightTest1() throws Exception {

        Scene scene = new Scene();
        scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, -1)));

        Triangle triangle = new Triangle(new Point3D(-3495, -3495, -1000),
                new Point3D(3500, -3500, -1000),
                new Point3D(2500, 2495, -1500));

        Triangle triangle2 = new Triangle(new Point3D(-3500, -3500, -1000),
                new Point3D(2495, 2500, -1500),
                new Point3D(-2500, 2500, -1500));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter("SpotLightTest1", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }
    @Test
    public void SpotLightTest2() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-300, -300, -200),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("SpotLightTest2", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }

}