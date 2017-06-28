/**
 * Created by shalom on 25/06/2017.
 */

import Elements.*;
import geometries.Geometry;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import javafx.application.Application;
import javafx.stage.Stage;

import primitives.*;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.util.Collection;
import java.io.*;
import java.awt.*;
import java.util.*;

public class run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



int r , g ,b , Angle , t = 0,  _switch, lighttemp;
 double itensity;
        String file_name;
        LightSource ligt = null;

        while (t != 4 ) {
            System.out.println("for hourse test press 1\n" +
                    "for shadow test press 2\n" +
                    "for recursive test print 3 \n" +
                    "for exit press 4");
            Scanner s;
    s = new Scanner(System.in);
    _switch = s.nextInt();

switch (_switch) {
    case 1:
        System.out.println("enter file name:");
        file_name = s.next();
        System.out.println("enter intensity Color number between 0-10:");
        itensity = s.nextDouble();
        System.out.println("rendering");

        System.out.println(1);
        Scene scene = new Scene();
        scene.set_backGround(new Color(255,255,255));
        scene.set_screenDistance(48.5);

        Geometry[] shapes = {

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
        scene.set_ambientLight(new AmbientLight(scene.get_ambientLight().get_color(), itensity));
        ImageWriter imageWriter = new ImageWriter(file_name, 500, 500, 500, 500);
        Render renderer = new Render(scene, imageWriter);
        renderer.renderImage();
        renderer.writeToImage();
        System.out.println("finished render");
        break;
    case 2:
        System.out.println("enter file name:");
        file_name = s.next();
        System.out.println("enter RGB Colors:");
        r = s.nextInt();
        g = s.nextInt();
        b = s.nextInt();
        System.out.println("enter Angle:");
        Angle = s.nextInt();
        System.out.println("enter itensity Color number between 0-100:");
        itensity = s.nextDouble();
        itensity /= 100;
        System.out.println("enter 1 to DirctionLight, enter 2 for pointLight, enter 3 for spot Light");
        lighttemp = s.nextInt();
        switch (lighttemp) {
            case 1: ligt = new DirectionalLight(new Color(r,g,b),new Vector(new Point3D(Math.sin(Angle)*-200,Math.cos(Angle)*-200,-200))) ;
                break;
            case 2: ligt = new PointLight(new Color(r,g,b),new Point3D(Math.sin(Angle)*-200,Math.cos(Angle)*-200,-200), 0.1, 0.00001, 0.000005);
                break;
            case 3: ligt =  (new SpotLight(new Color(255, 100, 100), new Point3D(Math.sin(Angle)*-200 , Math.cos(Angle)*-200, -200),
                    new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
                break;
        }





        System.out.println("rendering");
        Scene scene2 = new Scene(null, new Color(0,0,0), new AmbientLight(255,255,255), new Camera(), 250,null);
        scene2.set_ambientLight(new AmbientLight(scene2.get_ambientLight().get_color(), itensity));
        ImageWriter imageWriter2 = new ImageWriter(file_name, 500, 500, 500, 500);
        Plane plane = new Plane(new Vector(0,0,1), new Point3D(0,0,-520));
        plane.set_nShininess(200);
        Sphere sph1 = new Sphere(120, new Point3D(0,0,-400));
       // PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(200,-50,-20), 0.000005, 0.000005, 0.000006);
        scene2.addLight(ligt);
        sph1.set_nShininess(35);
        sph1.set_emmission(new Color(17,15,116));
        scene2.addGeometry(plane);
        scene2.addGeometry(sph1);
       // scene2.addLight(pointLight);
        Render renderer2 = new Render(scene2, imageWriter2);
        renderer2.renderImage();
        renderer2.writeToImage();
        System.out.println("finished render");
        break;



    case 3:
        System.out.println("enter file name:");
        file_name = s.next();
        System.out.println("enter RGB Colors:");
        r = s.nextInt();
        g = s.nextInt();
        b = s.nextInt();
        System.out.println("enter Angle:");
        Angle = s.nextInt();
        System.out.println("enter itensity Color number between 0-10:");
        itensity = s.nextDouble();
        itensity /= 100;
        System.out.println("enter 1 to DirctionLight, enter 2 for pointLight, enter 3 for spot Light");
        lighttemp = s.nextInt();
        switch (lighttemp) {
            case 1: ligt = new DirectionalLight(new Color(r,g,b),new Vector(new Point3D(Math.sin(Angle)*-200,Math.cos(Angle)*-200,-200))) ;
                break;
            case 2: ligt = new PointLight(new Color(r,g,b),new Point3D(Math.sin(Angle)*-200,Math.cos(Angle)*-200,-200), 0.1, 0.00001, 0.000005);
                //((PointLight)ligt).setArea(10.0);
            break;
            case 3: ligt =  (new SpotLight(new Color(255, 100, 100), new Point3D(Math.sin(Angle)*-200 , Math.cos(Angle)*-200, -200),
                    new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
                break;
        }






        System.out.println("recursive test now runing");
        Scene scene3 = new Scene();
        scene3.set_screenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000)) ;
        sphere.set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        sphere.setKt(0.85);
        //sphere.setKd(0.8);
        scene3.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.set_nShininess(20);
        sphere2.set_emmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene3.addGeometry(sphere2);
        scene3.addLight(ligt);

        ImageWriter imageWriter3 = new ImageWriter(file_name, 500, 500, 500, 500);

        Render renderer3 = new Render(scene3, imageWriter3);
        renderer3.renderImage();
        renderer3.writeToImage();
        System.out.println("finished render");
        break;

    case 4:
        t=4;
        System.out.println("progrem ended");
        break;

}

}
return;
    }
}
