package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 */
public class Triangle extends Geometry implements FlatGeometry {

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
        this._p1 = new Point3D (triangle._p1);
        this._p2 = new Point3D (triangle._p2);
        this._p3 = new Point3D (triangle._p3);
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
    }

    //public Triangle(Map<String, String> attributes) {

    //}

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
    @Override
    public Vector getNormal(Point3D point){
        Vector u = new Vector(_p1,_p2);
        Vector v = new Vector(_p2,_p3);
        Vector N = new Vector(u.crossProduct(v));
        N.normalize();
        N.scale(-1);
        return  N;

    }

    public Vector normal_of_triangle(Point3D p1, Point3D p2, Point3D Poo){
        Vector VPoo = new Vector(Poo);
        p1.subtract(VPoo);
        p2.subtract(VPoo);
        Vector v1 = new Vector(p1);
        Vector v2 = new Vector (p2);
        Vector N = v1.crossProduct(v2);
        N.normalize();
        N.scale(-1);
        return N;
        
    }


    public List<Point3D> FindIntersections(Ray ray){

        Vector N = new Vector(this.getNormal(_p1));
        Plane planeTriangle = new Plane(this.getNormal(_p3),_p3);
        ArrayList<Point3D> list1 = new ArrayList<>(planeTriangle.FindIntersections(ray));
        if (list1.isEmpty())
            return list1;

        Point3D P0 = new Point3D (ray.get_POO());
        Vector temp = new Vector(list1.get(0));
        P0.subtract(temp);
        Vector P_P0 = new Vector(P0);

        double s1 = P_P0.dotProduct(normal_of_triangle(_p1,_p2,P0));
        double s2 = P_P0.dotProduct(normal_of_triangle(_p1,_p3,P0));
        double s3 = P_P0.dotProduct(normal_of_triangle(_p2,_p3,P0));

        if ( (s1>0 & s2>0 & s3>0)||(s1<0 & s2<0 & s3<0) )
            return list1;
        else {
            list1.clear();
            return list1;
        }

        
    }

    @Override
    public String toString() {
        return "p1:"+_p1.toString()+" "+"p2:"+_p2.toString()+" "+"p3:"+_p3.toString();
    }
}
