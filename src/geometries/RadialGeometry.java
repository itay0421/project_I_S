package geometries;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 */
public abstract class RadialGeometry extends Geometry {

    protected double _radius;

    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

    public RadialGeometry() {
        this._radius = 0;
    }

    public double getRadius() {
        return _radius;
    }
    public RadialGeometry setRadius(double _radius) {
        this._radius = _radius;
        return this;
    }
}
