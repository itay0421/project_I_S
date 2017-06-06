package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shalom on 29/03/2017.
 */
public class Plane extends Geometry implements FlatGeometry{
    private Vector _normal;
    private Point3D _Q;

//ctor
    public Plane(Vector _normal, Point3D _Q) {
        this._normal = new Vector(_normal);
        this._Q = new Point3D(_Q);
    }
    public Plane() {
        _Q = new Point3D();
        _normal = new Vector();
    }

    /**
     * copy C'tor
     * @param plane
     */
    public Plane (Plane plane){
    this._normal = new Vector(plane._normal);
    this._Q = new Point3D(plane._Q);
    }

//seterss and geterss
    public Vector get_normal(Point3D point3D, Point3D d, Point3D point3D1) {
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


    /**
     * the purpose the function to indentification all the intersction point with the plane
     * @param ray
     * @return  list of point3D, intersections ray with Plane
     * used to build scene
     * use the vector functions:
     * dotProduct
     * add
     * subtract
     * scale
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        ArrayList list = new ArrayList();
        Vector v = new Vector(ray.get_POO());
        Vector direction = new Vector(ray.get_direction());
        v.subtract(new Vector(_Q));
        double x = _normal.dotProduct(direction);
        double t =-(_normal.dotProduct(v) / x);
            if (t >= 0) {
                direction.scale(t);
                Point3D p = new Point3D(ray.get_POO());
                p.add(direction);
                list.add(p);
            }
        return list;
    }

    /**
     *
     * @param point
     * @return vector normal to Plane,at point3D point
     */
    @Override
    public Vector getNormal(Point3D point) {
        Vector normal = new Vector(_normal);
        normal.normalize();
        return normal;
    }

}