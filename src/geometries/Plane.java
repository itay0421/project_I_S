package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;


/**
 * Created by shalom on 29/03/2017.
 */
public class Plane extends Geometry{
    private Vector _normal;
    private Point3D _Q;


    public Plane(Vector _normal, Point3D _Q) {
        this._normal = _normal;
        this._Q = _Q;
    }
    public Plane() {}
    public Plane (Plane plane){
    this._normal = plane._normal;
    this._Q = plane._Q;
    }


    public Vector get_normal() {
        return _normal;
    }
    public void set_normal(Vector _normal) {
        this._normal = _normal;
    }
    public Point3D get_Q() {
        return _Q;
    }
    public void set_Q(Point3D _Q) {
        this._Q = _Q;
    }
    public List<Point3D> FindIntersections(Ray ray){

    }

    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }

}