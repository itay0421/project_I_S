package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;
import java.util.Map;

/**
 * Created by shalom on 29/03/2017.
 */
public class Sphere extends RadialGeometry{
    private Point3D _center;

    public Point3D get_center() {
        return _center;
    }

    public Sphere set_center(Point3D _center) {
        this._center = _center;
        return this;
    }

    public Sphere(){
        this._center = new Point3D();
    }

    /**
     * copy C'tor
     * @param sphere
     */
    public Sphere (Sphere sphere){
        this._radius = sphere._radius;
        this._center = new Point3D(sphere.get_center());
    }
    public Sphere(double radius, Point3D center){
        super(radius);
        this._center = new Point3D(center);
    }
    public Sphere(Map<String, String> attributes){}

    @Override
    public Vector getNormal(Point3D){
        
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray){
        return null;
    }
}
