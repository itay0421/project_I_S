package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * Created by shalom on 29/03/2017.
 */
public class Cylinder extends RadialGeometry {

    protected Point3D _axisPoint; // the center of the Cylinder
    protected Vector _axisDirection; // the dirction of the Cylinder


    // ***************** Constructors ********************** //
// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Cylinder(){}
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Cylinder cylinder
     **************************************************/
    public Cylinder(Cylinder cylinder){
        this._axisDirection = cylinder._axisDirection;
        this._axisPoint = cylinder._axisPoint;
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      double radius, Point3D axisPoint, Vector axisDirection
     **************************************************/
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
    /*************************************************
     * FUNCTION
     * 		FindIntersections
     * PARAMETERS
     * @param ray- ray that pass in the middle of the pixel
     * RETURN VALUE
     *		List<Point3D> of all the Intersections points
     * MEANING
     *the meaning of this function its to indintifey all the Intersections point with this geometry
     *the size of the list will be 0<=list
     **************************************************/
    public List<Point3D> FindIntersections(Ray ray){
     return null;
    }
    /*************************************************
     * FUNCTION
     * 		getNormal
     * PARAMETERS
     * @param p- Point3D
     * RETURN VALUE
     *		Normal Vector
     * MEANING
     *the function purposes to return the normal vector to cylinder
     **************************************************/
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
