package geometries;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 * * abstract class to make sure all of the sons RadialGeometry class will implement important function
 * all the Radial Geometry shapes are implements those function
 */
public abstract class RadialGeometry extends Geometry {
// radius of the Radial Geometry
    protected double _radius;
    // ***************** Constructors ********************** //
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }
    //default ctor
    public RadialGeometry() {
    }

    // ***************** Getters/Setters ********************** //
    public double getRadius() {
        return _radius;
    }
    public RadialGeometry setRadius(double _radius) {
        this._radius = _radius;
        return this;
    }
}
