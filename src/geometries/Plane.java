package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shalom on 29/03/2017.
 */
public class Plane extends Geometry implements FlatGeometry {
    private Vector _normal;
    private Point3D _Q;

    // ***************** Constructors ********************** //
    public Plane(Vector _normal, Point3D _Q) {
        this._normal = new Vector(_normal);
        this._Q = new Point3D(_Q);
    }
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Plane() {
        _Q = new Point3D();
        _normal = new Vector();
    }

    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Plane plane
     **************************************************/
    public Plane (Plane plane){
    this._normal = new Vector(plane._normal);
    this._Q = new Point3D(plane._Q);
    }

    // ***************** Getters/Setters ********************** //
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

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * 		FindIntersections
     * PARAMETERS
     * @param ray- ray that pass in the middle of the pixel
     * RETURN VALUE
     *		List<Point3D> of all the Intersections points
     * MEANING
     ** the purpose the function to indentification all the Intersections point with the plane
     *the size of the list will be 0<=list
     * SEE ALSO
     * getSceneRayIntersections
     * findClosesntIntersection
     * dotProduct
     * add
     * scale
     **************************************************/
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
    /*************************************************
     * FUNCTION
     * 		getNormal
     * PARAMETERS
     * @param point- Point3D
     * RETURN VALUE
     *		Normal Vector
     * MEANING
     *the function purposes to return the normal vector to Plane
     * SEE ALSO
     * normalize
     **************************************************/
    @Override
    public Vector getNormal(Point3D point) {
        Vector normal = new Vector(_normal);
        normal.normalize();
        return normal;
    }

}