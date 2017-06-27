package renderer;

import Elements.*;
import geometries.*;
import geometries.Quadrangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;
import java.awt.*;

/**
 * Created by itay0 and yitzhak sud on 05/06/2017.
 */
public class RenderTest {

//
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

        //Quadrangle rectangle1 = new Quadrangle(new Point3D(250, 250, -49), new Point3D(375, 375, -49));
        //Quadrangle rectangle2 = new Quadrangle(new Point3D(375, 375, -49), new Point3D(250, 250, -49));
        //Quadrangle rectangle3 = new Quadrangle(new Point3D(250, 250, -49), new Point3D(125, 125, -49));
        //Quadrangle rectangle4 = new Quadrangle(new Point3D(0, 0, -49), new Point3D(0, 0, -49));


        //rectangle1.set_emmission(new Color(255,0,0));
       // rectangle2.set_emmission(new Color(0,0,255));
        //rectangle3.set_emmission(new Color(0,255,0));
        //rectangle4.set_emmission(new Color(250,250,0));

	/*create the Scene*/
        Scene scene = new Scene();

        scene.set_screenDistance(48.9);

        //add Geometries to the Scene

        //scene.addGeometry(rectangle1);
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
    public void HorseTest() throws Exception {

        Scene scene = new Scene();
        scene.set_screenDistance(48.5);

        Geometry [] shapes = {
                new Triangle(new Point3D(52, 20, -49),new Point3D(86, 85, -49),new Point3D(37, 94, -49)),
                new Triangle(new Point3D(12, -24, -49),new Point3D(52, 19, -49),new Point3D(37, 94, -49)),
                new Triangle(new Point3D(85, 84, -49),new Point3D(159, 99, -49),new Point3D(120, 138, -49)),
                new Triangle(new Point3D(23, 34, -49),new Point3D(37, 94, -49),new Point3D(-124, 125, -49)),
                new Triangle(new Point3D(37, 94, -49),new Point3D(21, 179, -49),new Point3D(-124, 125, -49)),
                new Triangle(new Point3D(21, 179, -49),new Point3D(-124, 125, -49),new Point3D(-86, 188, -49)),
                new Triangle(new Point3D(21, 179, -49),new Point3D(-86, 188, -49),new Point3D(-26, 267, -49))
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

        ImageWriter imageWriter = new ImageWriter("Horse test", 250, 250, 250, 250);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }
    @Test
    public void butterfly() throws Exception {

        Scene scene = new Scene();
        scene.set_backGround(new Color(255,255,255));
        scene.set_screenDistance(48.5);

        Geometry [] shapes = {

                new Triangle(new Point3D(0, 0, -49),new Point3D(-14, -14, -49),new Point3D(-23, -3, -49)),
                new Triangle(new Point3D(0, 0, -49),new Point3D(14, -14, -49),new Point3D(23, -3, -49)),

                new Triangle(new Point3D(0, 0, -49),new Point3D(-30, -5, -49),new Point3D(-13, 13,-49)),
                new Triangle(new Point3D(0, 0, -49),new Point3D(30, -5, -49),new Point3D(13, 13, -49)),

                new Triangle(new Point3D(0, 0, -49),new Point3D(-7, 13, -49),new Point3D(7, 13, -49)),

                new Triangle(new Point3D(-7, 13, -49),new Point3D(7, 13, -49),new Point3D(2, 61, -49)),

                new Triangle(new Point3D(0, 0, -49),new Point3D(-14, -14, -49),new Point3D(14, -14, -49)),
              // 7
                new Triangle(new Point3D(-14, -14, -49),new Point3D(14, -14, -49),new Point3D(-10, -34, -49)),
                new Triangle(new Point3D(-10, -34, -49),new Point3D(14, -14, -49),new Point3D(14, -34, -49)),
               //9
                new Triangle(new Point3D(14, -34, -49),new Point3D(-10, -34, -49),new Point3D(2, -59, -49)),
               //
                new Triangle(new Point3D(2, -59, -49),new Point3D(20, -83, -49),new Point3D(21, -88, -49)),
                new Triangle(new Point3D(2, -59, -49),new Point3D(-20, -83, -49),new Point3D(-21, -88, -49)),
                //12

                new Triangle(new Point3D(-10, -34, -49),new Point3D(-14, -14, -49),new Point3D(-32, -83, -49)),
                new Triangle(new Point3D(10, -34, -49),new Point3D(14, -14, -49),new Point3D(32, -83, -49)),

                //unclear triangle
                new Triangle(new Point3D(-14, -34, -49),new Point3D(-18, -22, -49),new Point3D(-36, -83,-49)),
                new Triangle(new Point3D(14, -34, -49),new Point3D(18, -22, -49),new Point3D(36, -83,-49)),

                new Triangle(new Point3D(-14, -14, -49),new Point3D(-32, -83, -49),new Point3D(-54, -38, -49)),
                new Triangle(new Point3D(14, -14, -49),new Point3D(32, -83, -49),new Point3D(54, -38, -49)),

                new Triangle(new Point3D(-54, -38, -49),new Point3D(-32, -83, -49),new Point3D(-74, -96, -49)),
                new Triangle(new Point3D(54, -38, -49),new Point3D(32, -83, -49),new Point3D(74, -96, -49)),

                new Triangle(new Point3D(-74, -96, -49),new Point3D(-32, -83, -49),new Point3D(-103, -121, -49)),
                new Triangle(new Point3D(74, -96, -49),new Point3D(32, -83, -49),new Point3D(103, -121, -49)),

                new Triangle(new Point3D(-74, -96, -49),new Point3D(-103, -121, -49),new Point3D(-150, -124, -49)),
                new Triangle(new Point3D(74, -96, -49),new Point3D(103, -121, -49),new Point3D(150, -124, -49)),

                new Triangle(new Point3D(-150, -124, -49),new Point3D(-74, -96, -49),new Point3D(-126, -95, -49)),
                new Triangle(new Point3D(150, -124, -49),new Point3D(74, -96, -49),new Point3D(126, -95, -49)),

                // 19*/

                new Triangle(new Point3D(-74, -96, -49),new Point3D(-54, -38, -49),new Point3D(-103, -35, -49)),
                new Triangle(new Point3D(74, -96, -49),new Point3D(54, -38, -49),new Point3D(103, -35, -49)),

                new Triangle(new Point3D(-74, -96, -49), new Point3D(-103, -35, -49),new Point3D(-126, -95, -49)),
                new Triangle(new Point3D(74, -96, -49), new Point3D(103, -35, -49),new Point3D(126, -95, -49)),

                new Triangle(new Point3D(-126, -95, -49),new Point3D(-150, -124, -49),new Point3D(-162, -68, -49)),
                new Triangle(new Point3D(126, -95, -49),new Point3D(150, -124, -49),new Point3D(162, -68, -49)),

                //22

                new Triangle(new Point3D(-162, -68, -49),new Point3D(-126, -95, -49),new Point3D(-130, -21, -49)),
                new Triangle(new Point3D(162, -68, -49),new Point3D(126, -95, -49),new Point3D(130, -21, -49)),

                new Triangle(new Point3D(-126, -95, -49),new Point3D(-130, -21, -49),new Point3D(-103, -35, -49)),
                new Triangle(new Point3D(126, -95, -49),new Point3D(130, -21, -49),new Point3D(103, -35, -49)),


                new Triangle(new Point3D(-130, -21, -49),new Point3D(-103, -35, -49),new Point3D(-96, -2, -49)),
                new Triangle(new Point3D(130, -21, -49),new Point3D(103, -35, -49),new Point3D(96, -2, -49)),


                new Triangle(new Point3D(-96, -2, -49),new Point3D(-103, -35, -49),new Point3D(-54, -38,-49)),
                new Triangle(new Point3D(96, -2, -49),new Point3D(103, -35, -49),new Point3D(54, -38,-49)),

                new Triangle(new Point3D(-54, -38, -49),new Point3D(-14, -14, -49),new Point3D(-23, -3, -49)),
                new Triangle(new Point3D(54, -38, -49),new Point3D(14, -14, -49),new Point3D(23, -3, -49)),


                new Triangle(new Point3D(-96, -2, -49),new Point3D(-54, -38, -49),new Point3D(-23, -3, -49)),
                new Triangle(new Point3D(96, -2, -49),new Point3D(54, -38, -49),new Point3D(23, -3, -49)),

                new Triangle(new Point3D(-96, -2, -49),new Point3D(-23, -3, -49),new Point3D(-105, 48, -49)),
                new Triangle(new Point3D(96, -2, -49),new Point3D(23, -3, -49),new Point3D(105, 48, -49)),

                new Triangle(new Point3D(-23, -3, -49),new Point3D(-105, 48, -49),new Point3D(-54, 38, -49)),
                new Triangle(new Point3D(23, -3, -49),new Point3D(105, 48, -49),new Point3D(54, 38, -49)),

                new Triangle(new Point3D(-54, 38, -49),new Point3D(-23, -3, -49),new Point3D(-7, 13, -49)),
                new Triangle(new Point3D(54, 38, -49),new Point3D(23, -3, -49),new Point3D(7, 13, -49)),

                // 31

                new Triangle(new Point3D(-96, -2, -49),new Point3D(-105, 48, -49),new Point3D(-123, 34, -49)),
                new Triangle(new Point3D(96, -2, -49),new Point3D(105, 48, -49),new Point3D(123, 34, -49)),

                new Triangle(new Point3D(-7, 13, -49),new Point3D(-54, 38, -49),new Point3D(-42, 93, -49)),
                new Triangle(new Point3D(7, 13, -49),new Point3D(54, 38, -49),new Point3D(42, 93, -49)),

                new Triangle(new Point3D(-42, 93, -49),new Point3D(-54, 38, -49),new Point3D(-105, 48, -49)),
                new Triangle(new Point3D(42, 93, -49),new Point3D(54, 38, -49),new Point3D(105, 48, -49)),

                new Triangle(new Point3D(-105, 48, -49),new Point3D(-42, 93, -49),new Point3D(-93, 109, -49)),
                new Triangle(new Point3D(105, 48, -49),new Point3D(42, 93, -49),new Point3D(93, 109, -49)),

                new Triangle(new Point3D(-42, 93, -49),new Point3D(-93, 109, -49),new Point3D(-58, 124, -49)),
                new Triangle(new Point3D(42, 93, -49),new Point3D(93, 109, -49),new Point3D(58, 124, -49)),

                new Triangle(new Point3D(-58, 124, -49),new Point3D(-93, 109, -49),new Point3D(-92, 140, -49)),
                new Triangle(new Point3D(58, 124, -49),new Point3D(93, 109, -49),new Point3D(92, 140, -49)),

                new Triangle(new Point3D(-93, 109, -49),new Point3D(-105, 48, -49),new Point3D(-123, 34, -49)),
                new Triangle(new Point3D(93, 109, -49),new Point3D(105, 48, -49),new Point3D(123, 34, -49))

                //38
                /*
                new Triangle(new Point3D(282, 0, -49),new Point3D(346, 55, -49),new Point3D(359, 53, -49)),
                new Triangle(new Point3D(282, 0, -49),new Point3D(346, -59, -49),new Point3D(359, -58, -49)),
                new Triangle(new Point3D(340, -105, -49),new Point3D(224, 38, -49),new Point3D(190, -50, -49)),

                new Triangle(new Point3D(10, 10, -49),new Point3D(-10, 10, -49),new Point3D(0, 0, -49))
// triangle 16*/

        };

        Color [] colors = {
                new Color(0,0,255),
                new Color(0,100,250),
                new Color(0,175,250),
                new Color(0,150,250),
                new Color(0,200,250),
                new Color(0,255,255),
                new Color(0,255,200),
                new Color(0,255,100),
                new Color(100,255,100),
                new Color(0,100,150),
                new Color(0,150,170),
                new Color(0,255,0),
                new Color(0,100,0),
                new Color(29,78,0),
                new Color(50,100,50),
                new Color(100,255,0),
                new Color(150,150,0),
                new Color(255,250,0),
                new Color(100,100,0),
                new Color(255,150,0),
                new Color(255,70,70),
                new Color(255,0,234),
                new Color(255,145,245),
                new Color(255,0,0),
                new Color(255,150,100),
                new Color(255,100,0),
                new Color(255,0,100),
                new Color(255,100,0),
                new Color(255,0,0),
                new Color(255,45,123),
                new Color(255,150,0),
                new Color(255,150,0),
                new Color(255,200,0),
                new Color(255,0,255),
                new Color(255,189,9),
                new Color(255,180,100),
                new Color(225,80,80)


        };

        // x = 650 - x (picture)
        // y = y (picture) - 650
        for (int i = 0; i < shapes.length; i++)
        {
            shapes[i].set_emmission(colors[i/2]);
            scene.addGeometry(shapes[i]);
        }

        ImageWriter imageWriter = new ImageWriter("butterfly test", 500, 500, 500, 500);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();

    }

}
/*
    Geometry [] shapes = {

            new Triangle(new Point3D(0, 0, -49),new Point3D(-14, -14, -49),new Point3D(-23, -3, -49)),
            new Triangle(new Point3D(0, 0, -49),new Point3D(18, -22, -49),new Point3D(30, -5, -49)),

            new Triangle(new Point3D(0, 0, -49),new Point3D(-23, -3, -49),new Point3D(-7, 13,-49)),
            new Triangle(new Point3D(0, 0, -49),new Point3D(30, -5, -49),new Point3D(13, 13, -49)),

            new Triangle(new Point3D(0, 0, -49),new Point3D(-7, 13, -49),new Point3D(13, 13, -49)),

            new Triangle(new Point3D(-7, 13, -49),new Point3D(13, 13, -49),new Point3D(2, 61, -49)),

            new Triangle(new Point3D(0, 0, -49),new Point3D(-14, -14, -49),new Point3D(18, -22, -49)),
            // 7
            new Triangle(new Point3D(-14, -14, -49),new Point3D(18, -22, -49),new Point3D(-10, -34, -49)),
            new Triangle(new Point3D(-10, -34, -49),new Point3D(18, -22, -49),new Point3D(14, -34, -49)),
            //9
            new Triangle(new Point3D(14, -34, -49),new Point3D(-10, -34, -49),new Point3D(2, -59, -49)),
            //
            new Triangle(new Point3D(2, -59, -49),new Point3D(20, -82, -49),new Point3D(21, -88, -49)),
            new Triangle(new Point3D(2, -59, -49),new Point3D(-17, -83, -49),new Point3D(-17, -88, -49)),
            //12

            new Triangle(new Point3D(-10, -34, -49),new Point3D(-3, -23, -49),new Point3D(-32, -83, -49)),
            new Triangle(new Point3D(14, -34, -49),new Point3D(18, -22, -49),new Point3D(36, -83,-49)),
            new Triangle(new Point3D(-23, -3, -49),new Point3D(-32, -83, -49),new Point3D(-54, -38, -49)),
            new Triangle(new Point3D(-54, -38, -49),new Point3D(-32, -83, -49),new Point3D(-74, -96, -49)),
            new Triangle(new Point3D(-74, -96, -49),new Point3D(-32, -83, -49),new Point3D(-103, -121, -49)),
            new Triangle(new Point3D(-74, -96, -49),new Point3D(-103, -121, -49),new Point3D(-150, -124, -49)),
            new Triangle(new Point3D(-150, -124, -49),new Point3D(-74, -96, -49),new Point3D(-126, -95, -49)),
            // 19*/
/*
            new Triangle(new Point3D(-74, -96, -49),new Point3D(-58, -38, -49),new Point3D(-103, -35, -49)),
            new Triangle(new Point3D(-74, -96, -49),new Point3D(-103, -35, -49),new Point3D(-126, -95, -49)),
            new Triangle(new Point3D(-126, -95, -49),new Point3D(-150, -124, -49),new Point3D(-162, -68, -49)),
            //22

            new Triangle(new Point3D(-162, -68, -49),new Point3D(-162, -95, -49),new Point3D(-130, -21, -49)),
            new Triangle(new Point3D(-126, -95, -49),new Point3D(-130, -21, -49),new Point3D(-103, -95, -35)),

            new Triangle(new Point3D(-130, -26, -49),new Point3D(-103, -35, -49),new Point3D(-96, -2, -49)),

            new Triangle(new Point3D(-96, -2, -49),new Point3D(-103, -35, -49),new Point3D(-54, -38,-49)),
            new Triangle(new Point3D(-54, -38, -49),new Point3D(-14, -14, -49),new Point3D(-7, 13, -49)),

            new Triangle(new Point3D(-96, -2, -49),new Point3D(-54, -38, -49),new Point3D(-7, 13, -49)),
            new Triangle(new Point3D(-96, -2, -49),new Point3D(-7, 13, -49),new Point3D(-105, 48, -49)),
            new Triangle(new Point3D(-7, 13, -49),new Point3D(-105, 48, -49),new Point3D(-54, 38, -49)),
            new Triangle(new Point3D(-54, 38, -49),new Point3D(-23, -3, -49),new Point3D(-7, 13, -49)),
            // 31

            new Triangle(new Point3D(-96, -2, -49),new Point3D(-105, 48, -49),new Point3D(-123, 34, -49)),
            new Triangle(new Point3D(30, -5, -49),new Point3D(-54, 38, -49),new Point3D(-42, 93, -49)),
            new Triangle(new Point3D(-42, 93, -49),new Point3D(-54, 38, -49),new Point3D(-105, 48, -49)),
            new Triangle(new Point3D(-105, 48, -49),new Point3D(-42, 93, -49),new Point3D(-93, 109, -49)),
            new Triangle(new Point3D(-42, 93, -49),new Point3D(-93, 109, -49),new Point3D(-58, 124, -49)),
            new Triangle(new Point3D(-58, 124, -49),new Point3D(-93, 109, -49),new Point3D(-92, 140, -49)),
            new Triangle(new Point3D(-93, 109, -49),new Point3D(-105, 48, -49),new Point3D(-96, -2, -49))
//38
                */