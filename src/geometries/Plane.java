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

    /**
     *
     * @return  vector _normal
     */
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


    /**
     *
     * @param ray
     * @return  list of point3D, intersections ray with Plane
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        ArrayList list = new ArrayList();
        Vector v = new Vector(ray.get_POO());
        Vector direction = new Vector(ray.get_direction());
        v.subtract(new Vector(_Q));
        double x = _normal.dotProduct(direction);
        double t = -(_normal.dotProduct(v) / x);
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