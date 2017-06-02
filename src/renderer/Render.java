package renderer;

import primitives.*;

import scene.Scene;
import geometries.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by itay0 on 01/06/2017.
 */
public class Render implements Comparable<Render>{

    private Scene _scene;
    private ImageWriter _imageWriter;

// ***************** Constructors ********************** //

    public Render(Scene _scene, ImageWriter _imageWriter) {
        this._scene = new Scene(_scene);
        this._imageWriter = new ImageWriter(_imageWriter);
    }

    public Render(Render r) {
        this._scene = new Scene(r._scene);
        this._imageWriter = new ImageWriter(r._imageWriter);
    }


    // ***************** Getters/Setters ********************** //

    public Scene get_scene() {
        return _scene;
    }

    public void set_scene(Scene _scene) {
        this._scene = _scene;
    }

    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }

    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = _imageWriter;
    }



    // ***************** Operations ******************** //
    @Override
    public int compareTo(Render o) {
        if ((o._imageWriter.equals(_imageWriter)) && o._scene.compareTo(_scene) == 0)
        return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return "Render{" +
                "_scene=" + _scene.toString() +
                ", _imageWriter=" + _imageWriter.toString() +
                '}';
    }

    /**
     * build imagewriter
     */
    public void renderImage(){
        for (int i = 1; i < _imageWriter.getHeight(); i++) {
            for (int j = 1; j < _imageWriter.getWidth(); j++) {
                Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(),
                        _imageWriter.getNy(), j, i,_scene.get_screenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());

                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(j,i,_scene.get_backGround());
                else {
                    Map<Geometry, Point3D> closestPoint = ( getClosestPoint(intersectionPoints));
                    //_imageWriter.writePixel(j,i,calcColor(closestPoint));
                    //how use map??
                }
                }
            }



    }

    public void printGrid(int interval){

    }
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay){

        //(Returns ambient light + emission light)
        return null;
    }
    private Color addColors(Color a, Color b){
    return null;
    }
    private Map.Entry<Geometry, Point3D> findClosesntIntersection(Ray ray){
        return null;
    }
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray){
        return null;

    }
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints){
        return null;
    }

}
