package renderer;

import Elements.*;
import geometries.*;
import geometries.Rectangle;
import org.junit.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by itay0 on 05/06/2017.
 */
public class RenderTest {


    @Test
    public void test1() throws Exception
    {

	/*create a Sphere and 4 Triangles*/

        Sphere sphere = new Sphere(50, new Point3D(0, 0, -50));
        Triangle triangle1 = new Triangle(new Point3D(250, 200, -49), new Point3D(250, 150, -49), new Point3D(-250, 200, -49));
        Triangle triangle2 = new Triangle(new Point3D(250, 150, -49), new Point3D(-250, 200, -49), new Point3D(-250, 150, -49));
        Triangle triangle3 = new Triangle(new Point3D(250, -150, -49), new Point3D(250, -200, -49), new Point3D(-250, -200, -49));
        Triangle triangle4 = new Triangle(new Point3D(-250, -200, -49), new Point3D(-250, -150, -49), new Point3D(250, -150, -49));
        triangle1.set_emmission(new Color(0,0,255));
        triangle2.set_emmission(new Color(0,0,255));
        triangle3.set_emmission(new Color(0,0,255));
        triangle4.set_emmission(new Color(0,0,255));
        Triangle triangle5 = new Triangle(new Point3D(0, 100, -49), new Point3D(150, -50, -49), new Point3D(-150, -50, -49));
        Triangle triangle6 = new Triangle(new Point3D(0, -100, -49), new Point3D(150, 50, -49), new Point3D(-150, 50, -49));
        triangle5.set_emmission(new Color(0,0,255));
        triangle6.set_emmission(new Color(0,0,255));
	/*create the Scene*/

        Scene scene = new Scene(); //template Scene
        scene.set_screenDistance(48.5);
        scene.set_backGround(new Color(255,255,255));

      //  scene.light.add(new PointLight());
      //  scene.lights.add(new SpotLight());
     //   scene.lights.add(new DirectionalLight());

        //add Geometries to the Scene
        //scene.addGeometry(sphere);
       //scene.addGeometry(plane);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        scene.addGeometry(triangle5);
        scene.addGeometry(triangle6);
	/*create an ImageWriter*/
       ImageWriter imageWriter = new ImageWriter("test1_israelFlag", 500, 500, 500, 500);
	/*create a Renderer*/
       Render renderer = new Render(scene, imageWriter);
       // render Image
       renderer.renderImage();
        //print Grid
      // renderer.printGrid(50);
        //print Image
       renderer.get_imageWriter().writeToimage();
       renderer.writeToImage();
    }

    @Test
    public void test2() throws Exception
    {
	/*create a Sphere and 4 Triangles*/
        Sphere sphere = new Sphere(50, new Point3D(0, 0, -50));
        Triangle triangle1 = new Triangle(new Point3D(100, 0, -49), new Point3D(0, 100, -49), new Point3D(100, 100, -49));
        Triangle triangle2 = new Triangle(new Point3D(100, 0, -49), new Point3D(0, -100, -49), new Point3D(100, -100, -49));
        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49), new Point3D(0, 100, -49), new Point3D(-100, 100, -49));
        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49), new Point3D(0, -100, -49), new Point3D(-100, -100, -49));
        triangle1.set_emmission(new Color(255,0,0));
        triangle2.set_emmission(new Color(0,0,255));
        triangle3.set_emmission(new Color(0,255,0));
        triangle4.set_emmission(new Color(250,250,0));

	/*create the Scene*/
       Scene scene = new Scene();

        scene.set_screenDistance(48.9);

        //add Geometries to the Scene
        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
	/*create an ImageWriter*/
        ImageWriter imageWriter = new ImageWriter("test2_basicColorRender", 500, 500, 500, 500);
	/*create a Renderer*/
        Render renderer = new Render(scene, imageWriter);
        //render Image
        renderer.renderImage();
        //print Grid
        renderer.printGrid(50);
        //print Image
        renderer.writeToImage();
    }
    @Test
    public void test3() throws Exception
    {

        Rectangle rectangle1 = new Rectangle(new Point3D(250, 250, -49), new Point3D(375, 375, -49));
        //Rectangle rectangle2 = new Rectangle(new Point3D(375, 375, -49), new Point3D(250, 250, -49));
        //Rectangle rectangle3 = new Rectangle(new Point3D(250, 250, -49), new Point3D(125, 125, -49));
        //Rectangle rectangle4 = new Rectangle(new Point3D(0, 0, -49), new Point3D(0, 0, -49));


        rectangle1.set_emmission(new Color(255,0,0));
       // rectangle2.set_emmission(new Color(0,0,255));
        //rectangle3.set_emmission(new Color(0,255,0));
        //rectangle4.set_emmission(new Color(250,250,0));

	/*create the Scene*/
        Scene scene = new Scene();

        scene.set_screenDistance(48.9);

        //add Geometries to the Scene

        scene.addGeometry(rectangle1);
        //scene.addGeometry(rectangle2);
        //scene.addGeometry(rectangle3);
        //scene.addGeometry(rectangle4);
	/*create an ImageWriter*/
        ImageWriter imageWriter = new ImageWriter("test2_rectangel", 500, 500, 500, 500);
	/*create a Renderer*/
        Render renderer = new Render(scene, imageWriter);
        //render Image
        renderer.renderImage();
        //print Grid
        renderer.printGrid(50);
        //print Image
        renderer.writeToImage();
    }

    @Test
    public void test4() throws Exception
    {
        Scene scene = new Scene();
        Sphere sphere1 = new Sphere(9900, new Point3D(0, 0, -10000));
        sphere1.set_emmission(new Color(255, 23, 85));
        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(200.0, 200.0, -30.0), 0.000004, 0.000004, 0.000002));
        DirectionalLight directionalLight = new DirectionalLight(new Color(10, 100, 15),new Vector(0,0,-1));

        scene.set_screenDistance(32);


        scene.addGeometry(sphere1);

        ImageWriter imageWriter = new ImageWriter("test3_pointLight", 500, 500, 500, 500);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }

    @Test
    public void testRenderImage1() throws Exception {
        //Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
        Scene scene = new Scene(/*new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100*/);
        /*Plane plane = new Plane(new Vector(0,1, 0), new Point3D(0.0, -130.0 , 0.0));
        plane.setShininess(200);
        plane.setEmmission(new Color(0,0,0));
        plane.setMaterial(new Material( 0, 0, 0, 0 ,0));*/
        Sphere sphere1 = new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0));
        sphere1.set_nShininess(35);
        sphere1.set_emmission(new Color(17,15,116));
       // sphere1.set_material(new Material());
        /*Triangle triangle = new Triangle(new Point3D(1000.0, -200.0, -600.0),new Point3D(-100.0, -200.0, -1000.0), new Point3D(400.0, 1000.0, -800.0));
        triangle.setShininess(1.0);
        triangle.setEmmission(new Color(0,0,0));
        triangle.setMaterial(new Material(0, 0, 1, 0 ,0));
        Sphere sphere2 = new Sphere(700.0, new Point3D(-200.0, 0.0 , -1500.0));
        sphere2.setShininess(35.0);
        sphere2.setEmmission(new Color(116,15,17));
        sphere2.setMaterial(new Material(0.5, 0.5, 0, 0.5,1));
        Sphere sphere3 = new Sphere(300.0, new Point3D(-200.0, 0.0 , -1500.0));
        sphere3.setShininess(35.0);
        sphere3.setEmmission(new Color(15,200,17));
        sphere3.setMaterial(new Material(1, 1, 0, 0,1));*/
        //scene.addGeometry(plane);
        scene.addGeometry(sphere1);
        /*scene.addGeometry(triangle);
        scene.addGeometry(sphere2);
        scene.addGeometry(sphere3);*/
        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(200.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));
        //scene.addLight(new SpotLight(new Color(255, 50, 50), new Point3D(200.0, 200.0, -20.0), new Vector(-200.0, -200.0, -1280.0),0.002, 0.002, 0.001));
        ImageWriter imageWriter = new ImageWriter("test4_PointLight", 500, 500, 500, 500);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
    }
    @Test
    public void HorseTest() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(50);

        Geometry [] shapes = {
                new Triangle(new Point3D(52, 20, -50),new Point3D(86, 85, -50),new Point3D(37, 94, -50)),
                new Triangle(new Point3D(12, -24, -50),new Point3D(52, 19, -50),new Point3D(37, 94, -50)),
                new Triangle(new Point3D(85, 84, -50),new Point3D(159, 99, -50),new Point3D(120, 138, -50)),
                new Triangle(new Point3D(23, 34, -50),new Point3D(37, 94, -50),new Point3D(-124, 125, -50)),
                new Triangle(new Point3D(37, 94, -50),new Point3D(21, 179, -50),new Point3D(-124, 125, -50)),
               new Triangle(new Point3D(21, 179, -50),new Point3D(-124, 125, -50),new Point3D(-86, 188, -50)),
                new Triangle(new Point3D(21, 179, -50),new Point3D(-86, 188, -50),new Point3D(-26, 267, -50))
        };

        Color [] colors = {
                new Color(32,178,170),
                new Color(60,179,119),
                new Color(87,107,47),
                new Color(87,107,47),
                new Color(34,140,34),
                new Color(0,255,0),
                new Color(255,255,0)
        };

        // x = 650 - x (picture)
        // y = y (picture) - 650
        for (int i = 0; i < shapes.length; i++)
        {
            shapes[i].set_emmission(colors[i]);
            scene.addGeometry(shapes[i]);
        }

        ImageWriter imageWriter = new ImageWriter("Horse test", 1300, 1300, 1300, 1300);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }
}
