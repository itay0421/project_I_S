package renderer;

import Elements.AmbientLight;
import Elements.Camera;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
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

    //    Sphere sphere = new Sphere(50, new Point3D(0, 0, -49));
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
     //   sphere.set_emmission(new Color(255, 255, 255));
	/*create the Scene*/

        Scene scene = new Scene(); //template Scene
        scene.set_screenDistance(48.5);

      //  scene.light.add(new PointLight());
      //  scene.lights.add(new SpotLight());
     //   scene.lights.add(new DirectionalLight());

        //add Geometries to the Scene
    //    scene.addGeometry(sphere);
       //scene.addGeometry(plane);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        scene.addGeometry(triangle5);
        scene.addGeometry(triangle6);
	/*create an ImageWriter*/
       ImageWriter imageWriter = new ImageWriter("test1_basicRender", 500, 500, 500, 500);
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

 /**   @Test
    public void test2() throws Exception
    {
	/*create a Sphere and 4 Triangles*/
 /**       Sphere sphere = new Sphere(50, new Point3D(0, 0, -50));
        Triangle triangle1 = new Triangle(new Point3D(100, 0, -49), new Point3D(0, 100, -49), new Point3D(100, 100, -49));
        Triangle triangle2 = new Triangle(new Point3D(100, 0, -49), new Point3D(0, -100, -49), new Point3D(100, -100, -49));
        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49), new Point3D(0, 100, -49), new Point3D(-100, 100, -49));
        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49), new Point3D(0, -100, -49), new Point3D(-100, -100, -49));
        triangle1.set_emmission(new Color(255,0,0));
        triangle2.set_emmission(new Color(0,0,255));
        triangle3.set_emmission(new Color(0,255,0));
        triangle4.set_emmission(new Color(255,255,0));

	/*create the Scene*/
  /**     Scene scene = new Scene();
        scene.set_screenDistance(48.9);

        //add Geometries to the Scene
        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
	/*create an ImageWriter*/
  /**      ImageWriter imageWriter = new ImageWriter("test2_basicColorRender", 500, 500, 500, 500);
	/*create a Renderer*/
 /**       Render renderer = new Render(scene, imageWriter);
        //render Image
        renderer.renderImage();
        //print Grid
        renderer.printGrid(50);
        //print Image
        renderer.writeToImage();
    }
*/

}