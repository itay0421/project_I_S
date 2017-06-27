package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itay0 on 08/06/2017.
 */
public class Quadrangle extends Geometry{

    protected Triangle _tri1;
    protected Triangle _tri2;

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Quadrangle(){
     _tri1 = new Triangle();
     _tri2 = new Triangle();
    }

    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Point3D bottomLeft, Point3D topRight
     **************************************************/
    public Quadrangle(Point3D P1, Point3D P2, Point3D P3, Point3D P4)
    {
        _tri1 = new Triangle(P1, P2, P4);
        _tri2 = new Triangle(P2, P3, P4);
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Quadrangle copy
     **************************************************/
    public Quadrangle(Quadrangle copy)
    {
        _tri1 = new Triangle(copy._tri1);
        _tri2 = new Triangle(copy._tri2);

    }

    // ***************** Getters/Setters ********************** //

    public Triangle get_tri1() {
        return _tri1;
    }

    public void set_tri1(Triangle _tri1) {
        this._tri1 = _tri1;
    }

    public Triangle get_tri2() {
        return _tri2;
    }

    public void set_tri2(Triangle _tri2) {
        this._tri2 = _tri2;
    }


    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * 		getNormal
     * PARAMETERS
     * @param - Point3D
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
        Vector u = new Vector(_tri1.getP2(),_tri1.getP2());
        Vector v = new Vector(_tri1.getP3(),_tri1.getP1());
        Vector N = new Vector(u.crossProduct(v));
        N.normalize();
        N.scale(-1);
        return  N;

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

        /**ArrayList<Point3D> list = new ArrayList<>();
        Vector N1 = new Vector(this.getNormal(_tri1.getP1()));
        Plane planeTriangle1 = new Plane(N1,_tri1.getP1());
        ArrayList<Point3D> list1 = new ArrayList<>(planeTriangle1.FindIntersections(ray));

        Vector N2 = new Vector(this.getNormal(_tri2.getP1()));
        Plane planeTriangle2 = new Plane(N2,_tri2.getP1());
        ArrayList<Point3D> list2 = new ArrayList<>(planeTriangle2.FindIntersections(ray));

        if (list2.isEmpty() && list1.isEmpty() )
            return list;




            Point3D P0 = new Point3D(ray.get_POO());
            Vector temp = new Vector(list1.get(0));
            P0.subtract(temp);
            Vector P_P0 = new Vector(P0);


            double s1 = P_P0.dotProduct(new Vector(normal_of_triangle(new Point3D(_p1), new Point3D(_p2), new Point3D(ray.get_POO()))));
            double s2 = P_P0.dotProduct(new Vector(normal_of_triangle(new Point3D(_p2), new Point3D(_p3), new Point3D(ray.get_POO()))));
            double s3 = P_P0.dotProduct(new Vector(normal_of_triangle(new Point3D(_p3), new Point3D(_p1), new Point3D(ray.get_POO()))));

            if ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0))
                return list1;
            else {
                list1.clear();
                return list1;
            }
        */
        ArrayList<Point3D> list = new ArrayList<>();
        ArrayList<Point3D> list1 = new ArrayList<>(_tri1.FindIntersections(ray));
        ArrayList<Point3D> list2 = new ArrayList<>(_tri2.FindIntersections(ray));

        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

}