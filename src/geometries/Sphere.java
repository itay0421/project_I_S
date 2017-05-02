package geometries;

import primitives.*;

/**
 * Created by shalom on 29/03/2017.
 */
public class Sphere {
    private Point3D _center;


    public Sphere(){}
    public Sphere (Sphere sphere){
        this._center = sphere._center;
    }
    public Sphere(double radius, Point3D center){
        this._center = center;
    }
    public Sphere(Map<String, String> attributes){}
}
