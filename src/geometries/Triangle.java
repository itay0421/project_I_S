
package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 */

public class Triangle extends Geometry {
    // triangle build from 3 point that conecting with 3 vectors
    // with 3 points we can build any triangle.
    // those variables are 3D points that we have to build triangle
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;



    // ***************** Constructors ********************** //

    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Triangle(){
        Point3D _p1 = new Point3D();
        Point3D _p2 = new Point3D();
        Point3D _p3 = new Point3D();
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Triangle triangle
     **************************************************/
    public Triangle(Triangle triangle){
        this._p1 = new Point3D (triangle._p1);
        this._p2 = new Point3D (triangle._p2);
        this._p3 = new Point3D (triangle._p3);

        this.set_emmission(new Color(triangle.get_emmission().getRGB()));

    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Point3D _p1, Point3D _p2, Point3D _p3
     **************************************************/
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
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
    /*************************************************
     * FUNCTION
     * 		getNormal
     * PARAMETERS
     * @param p- Point3D
     * RETURN VALUE
     *		Normal Vector
     * MEANING
     *the function purposes to return the normal vector to sphere
     * SEE ALSO
     * normalize
     * scale
     **************************************************/
    @Override
    public Vector getNormal(Point3D point){
        Vector u = new Vector(_p2,_p1);
        Vector v = new Vector(_p3,_p1);
        Vector N = new Vector(u.crossProduct(v));
        N.normalize();
        N.scale(-1);
        return  N;

    }

    /**
     * create vectors like vectors for a new triangle and return is normal vector(of the "triangle")
     * @param p1 point3d
     * @param p2 point3d
     * @param Poo point3d
     * @return normal of new triangle,
     * this function used in "findintresction" function
     * the function use basic functions of vector include  scale, subtract, dotprodact
     */
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

    /*************************************************
     * FUNCTION
     * 		FindIntersections
     * PARAMETERS
     * @param ray- ray that pass in the middle of the pixel
     * RETURN VALUE
     *		List<Point3D> of all the Intersections points
     * MEANING
     * the purpose the function to indentification all the Intersections point with the sphere
     * used to find the place of geometry in scene
     *the size of the list will be 0<=list
     * SEE ALSO
     * this function base on the plane FindIntersections
     * getSceneRayIntersections
     * findClosesntIntersection
     **************************************************/
    public List<Point3D> FindIntersections(Ray ray){

        Vector N = new Vector(this.getNormal(_p1));
        Plane planeTriangle = new Plane(N,_p1);
        ArrayList<Point3D> list1 = new ArrayList<>(planeTriangle.FindIntersections(ray));
        if (list1.isEmpty())
            return list1;

        Point3D P0 = new Point3D (ray.get_POO());
        Vector temp = new Vector(list1.get(0));
        P0.subtract(temp);
        Vector P_P0 = new Vector(P0);


        double s1 = P_P0.dotProduct(new Vector(normal_of_triangle(new Point3D(_p1), new Point3D(_p2), new Point3D(ray.get_POO()))));
        double s2 = P_P0.dotProduct(new Vector(normal_of_triangle(new Point3D(_p2), new Point3D(_p3), new Point3D(ray.get_POO()))));
        double s3 = P_P0.dotProduct(new Vector(normal_of_triangle(new Point3D(_p3), new Point3D(_p1), new Point3D(ray.get_POO()))));

        if ( (s1>0 && s2>0 && s3>0)||(s1<0 && s2<0 && s3<0) )
            return list1;
        else {
            list1.clear();
            return list1;
        }


    }

    /*************************************************
     * FUNCTION
     * 		toString
     * 	abstract function of print format
     **************************************************/
    @Override
    public String toString() {
        return "p1:"+_p1.toString()+" "+"p2:"+_p2.toString()+" "+"p3:"+_p3.toString();
    }
}

