package geometries;

import primitives.*;

/**
 * Created by shalom on 29/03/2017.
 */
public class Cylinder extends RadialGeometry {

    private Point3D _axisPoint;
    private Vector _axisDirection;
    public Cylinder(){}
    public Cylinder(Cylinder cylinder){
        this._axisDirection = cylinder._axisDirection;
        this._axisPoint = cylinder._axisPoint;
    }
    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
        this._axisPoint = axisPoint;
        this._axisDirection = axisDirection;
    }

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

}
