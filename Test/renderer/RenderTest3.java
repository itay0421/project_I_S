package renderer;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Elements.SpotLight;
import geometries.Plane;
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
public class RenderTest3 {
    @Test
    public void emmissionTest() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(48);
        scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));

        Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D( 100, 100, -49));

        Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
                new Point3D(  0, -100, -49),
                new Point3D( 100,-100, -49));
        triangle2.set_emmission(new Color(50, 200, 50));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D(-100, 100, -49));
        triangle3.set_emmission(new Color (50, 50, 200));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0,  -100, -49),
                new Point3D(-100, -100, -49));
        triangle4.set_emmission(new Color (200, 50, 50));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }



    @Test
    public void spotLightTest2() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.set_emmission(new Color (0, 0, 100));
        triangle.set_nShininess(4);
        triangle.setKd(0.01);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2 + shadow", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }


    @Test
    public void spotLightTest() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                new Vector(2, 2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }


    @Test
    public void pointLightTest() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere (800, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();


    }



    @Test
    public void pointLightTest2() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));

        Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));
        //scene.addGeometry(sphere);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }

    @Test
    public void shadowTest() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(100);
        sphere.set_emmission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }
    @Test
    public void LightTest11() throws Exception {

        Scene scene = new Scene(null, new Color(0,0,0), new AmbientLight(255,255,255), new Camera(), 250,null);
        ImageWriter imageWriter = new ImageWriter("Shadow Test+++17", 500, 500, 500, 500);
        Plane plane = new Plane(new Vector(0,0,1), new Point3D(0,0,-520));
        plane.set_nShininess(200);
        Sphere sph1 = new Sphere(120, new Point3D(0,0,-400));
        PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(80,150,-20), 0.000005, 0.000005, 0.000006);
        pointLight.setArea(20);
        sph1.set_nShininess(35);
        sph1.set_emmission(new Color(17,15,116));
        scene.addGeometry(plane);
        scene.addGeometry(sph1);
        scene.addLight(pointLight);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }

    @Test
    public void LightTest12() throws Exception {

        Scene scene = new Scene(null, new Color(0,0,0), new AmbientLight(255,255,255), new Camera(), 100,null);
        ImageWriter imageWriter = new ImageWriter("Shadow Test2", 500, 500, 500, 500);
       Sphere sph1 = new Sphere(900, new Point3D(0,0,-1300));
        Triangle tri1 = new Triangle(new Point3D(200, 200,-300), new Point3D(0,200,-300), new Point3D(100,400,-300));
       Triangle  tri2 = new Triangle(new Point3D(200, 0,-300), new Point3D(100,-200,-300), new Point3D(0,0,-300));
        Triangle tri3 = new Triangle(new Point3D(0, 200,-300), new Point3D(0,0,-300), new Point3D(-200,100,-300));
       Triangle tri4 = new Triangle(new Point3D(200, 200,-300), new Point3D(400,100,-300), new Point3D(200,0,-300));
        PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(200,200,-20), 0.00002, 0.00002, 0.000001);
        sph1.set_nShininess(35);
        sph1.set_emmission(new Color(17,15,116));
        tri1.setKd(0.2);
        tri1.setKs(0.2);
        tri2.setKd(0.2);
        tri2.setKs(0.2);
        tri3.setKd(0.2);
        tri3.setKs(0.2);
        tri4.setKd(0.2);
        tri4.setKs(0.2);
        scene.addGeometry(sph1);
        scene.addGeometry(tri1);
        scene.addGeometry(tri2);
        scene.addGeometry(tri3);
        scene.addGeometry(tri4);
        scene.addLight(pointLight);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }
    @Test
    public void shadowTest3() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Shadow test 3", 500, 500, 500, 500);

        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }
}






