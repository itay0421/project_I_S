package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * Created by shalom on 29/03/2017.
 */
public class Cylinder extends RadialGeometry {

    private Point3D _axisPoint; // the center of the Cylinder
    private Vector _axisDirection; // the dirction of the Cylinder


    // ***************** Constructors ********************** //
    //default ctor
    public Cylinder(){}
    // copy ctor
    public Cylinder(Cylinder cylinder){
        this._axisDirection = cylinder._axisDirection;
        this._axisPoint = cylinder._axisPoint;
    }
    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
        this._axisPoint = axisPoint;
        this._axisDirection = axisDirection;
    }
    // ***************** Getters/Setters ********************** //
    public Vector get_axisDirection() {
        return _axisDirection;
    }
    public void set_axisDirection(Vector _axisDirection) {
        this._axisDirection = _axisDirection;
    }
    public Point3D get_axisPoint() {
        return _axisPoint;
    }
    public void set_axisPoint(Point3D _axisPoint) {
        this._axisPoint = _axisPoint;
    }

    // ***************** Operations ******************** //
    /***
    the function FindIntersections are attempted to find all the intersctions
     between ray that racive as parameter to our Cylinder.
     the function racive a rsy as parametr.
     the function returns List of all the intersction points between the ray to the cylinder
    the meaning of this function its to indintifey all the intresction point with this geometrie
    the size of the list will be 0<=list
     not in use in this project level
     ***/
    public List<Point3D> FindIntersections(Ray ray){
     return null;
    }
    /**
     *the function purposeis to return the normal vector to cylinder
     * @param  p point3d that we went the normal between the point to the cylinder
     * @return the normal vector
     */
    @Override
    public Vector getNormal(Point3D p) {
        double a=p.getX().getCoordinate();
        double b=p.getY().getCoordinate();
        double c=p.getZ().getCoordinate();
        double x=_axisDirection.getHead().getX().getCoordinate();
        double y=_axisDirection.getHead().getY().getCoordinate();
        double z=_axisDirection.getHead().getZ().getCoordinate();
        double t=(a*x+b*y+c*z)/(x*x+y*y+z*z);
        Vector temp=new Vector(_axisDirection);
        temp.scale(t);
        Vector normal=new Vector(p);
        normal.subtract(temp);
        normal.normalize();
        return normal;
    }
}
