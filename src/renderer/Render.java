package renderer;

import Elements.Lightsource;
import primitives.*;

import primitives.Vector;
import scene.Scene;
import geometries.*;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by itay0 on 01/06/2017.
 */
public class Render implements Comparable<Render> {

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
    public void renderImage() {
        for (int i = 1; i < _imageWriter.getHeight(); i++) {
            for (int j = 1; j < _imageWriter.getWidth(); j++) {
                Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(),
                        _imageWriter.getNy(), j, i, _scene.get_screenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());

                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(j, i, _scene.get_backGround());
                else {
                    Point3D closestPoint = (Point3D) (getClosestPoint(intersectionPoints));
                    _imageWriter.writePixel(j, i, calcColor(closestPoint));
                    //how use map??
                }
            }
        }
    }


    private Color calcColor(Geometry geometry, Point3D point, Ray inRay) {
        //(Returns ambient light + emission light)
        return null;
    }

    private Color calcColor(Point3D point) {
        return _scene.get_ambientLight().getIntensity();
    }

    private Color addColors(Color a, Color b) {
        return null;
    }

    private Map.Entry<Geometry, Point3D> findClosesntIntersection(Ray ray) {
        return null;
    }

    /**
     * @param ray
     * @return map list of intersction between the scene ans ray
     */
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<>();
        Geometry geometry = null;
        while (geometries.hasNext())
            geometry = geometries.next();
        List<Point3D> geometryinstersections =
                geometry.FindIntersections(ray);
        if (!intersectionPoints.isEmpty()) {
            intersectionPoints.put(geometry, geometryinstersections);
        }
        return  intersectionPoints;
    }

    /**
     * find the closest point between the insterctionPoint to the viwe point
     */
    private Point3D getClosestPoint(List<Point3D> insterctionPoints) {
        double dist = Double.MAX_VALUE;
        Point3D p0 = _scene.get_camera().get_P0();
        Point3D mindistPoint = null;

        for (Point3D point : insterctionPoints) {
            if (p0.distance(point) < dist)
                mindistPoint = new Point3D(point);
            dist = p0.distance(point);
        }
        return mindistPoint;
    }

    public void printGrid(int interval) {
        for (int i = 0; i < _imageWriter.getHeight(); i += interval)
            for (int j = 0; j < _imageWriter.getHeight(); j++)
                _imageWriter.writePixel(i, j, Color.WHITE);
        for (int i = 0; i < _imageWriter.getWidth(); i += interval)
            for (int j = 0; j < _imageWriter.getWidth(); j++)
                _imageWriter.writePixel(j, i, Color.WHITE);
    }

/**
    private Color calcColor(Geometry geometry, Point3D point) {
        Color ambientLight = _scene.get_ambientLight().getIntensity(point);
        Color emissionLight = geometry.get_emmission();
        Iterator<Lightsource> lights = _scene.getLightsIterator();
        while (lights.hasNext()) {
            if (!occluded(light, point, geometry)){
                Color diffuseLight = calcDiffusiveComp(geometry.material.Kd,
                  geometry.getNormal(point),
                        light.getL(point),
                         lightIntensity);
                  Color specularLight = calcSpecularComp(geometry.material.Ks,
                        new Vector(point, _scene. 
                                getCamera().getP0()),
                        geometry.getNormal(point),
                        light.getL(point),
                        geometry.getShininess(),
                        lightIntensity); }
        }
        return new Color(ambientLight + emissionLight + diffuseLight + specularLight)
    }
*/
    private boolean occluded(Lightsource light, Point3D point, Geometry geometry) {
        Vector lightDirection = light.getL(point);
    lightDirection.scale(-1);
    Point3D geometryPoint = new Point3D(point);
    Vector epsVector = new Vector(geometry.getNormal(point));
    epsVector.scale(2);    geometryPoint.add(epsVector);
    Ray lightRay = new Ray(geometryPoint, lightDirection);
    Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
    // Flat geometry cannot self intersect  if (geometry instanceof FlatGeometry){
    // intersectionPoints.remove(geometry); }
    // return !intersectionPoints.isEmpty();
        return  false;
     }

    private Map<Geometry, Point3D>	getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.get_camera().get_P0();
        Map<Geometry, Point3D> minDistancePoint =
                new HashMap<Geometry, Point3D>();
        for (Map.Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
            for (Point3D point: entry.getValue())
            {
                if (P0.distance(point) < distance)
                    minDistancePoint.clear();
                minDistancePoint.put(entry.getKey(), new Point3D(point));
                distance = P0.distance(point);
            }
        return minDistancePoint;
    }

}