package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;
import java.util.Map;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 */
public class Triangle extends Geometry {

    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    // ***************** Constructors ********************** //

    public Triangle(){
        Point3D _p1 = new Point3D();
        Point3D _p2 = new Point3D();
        Point3D _p3 = new Point3D();

    }
    public Triangle(Triangle triangle){
        this._p1 = triangle._p1;
        this._p2 = triangle._p2;
        this._p3 = triangle._p3;
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    public Triangle(Map<String, String> attributes) {

    }

    // ***************** Getters/Setters ********************** //
    public Point3D getP1() {
        return _p1;
    }
    public Triangle setP1(Point3D _p1) {
        this._p1 = _p1;
        return this;
    }

    public Point3D getP2() {
        return _p2;
    }

    public Triangle setP2(Point3D _p2) {
        this._p2 = _p2;
        return this;
    }

    public Point3D getP3() {
        return _p3;
    }

    public Triangle setP3(Point3D _p3) {
        this._p3 = _p3;
        return this;
    }


    // ***************** Operations ******************** //
    public Vector getNormal(Point3D point){
        
    }
    public List<Point3D> FindIntersections(Ray ray);
}
