package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */

public class Sphere extends RadialGeometry {
// the center of the sphere
    private Point3D center;
// ***************** Getters/Setters ********************** //
    public Point3D getCenter() {
        return new Point3D(center);
    }
    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }
    // ***************** Constructors ********************** //
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Sphere() {
        this.center=new Point3D();
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      double radius , Point3D center
     **************************************************/
    public Sphere( double radius , Point3D center) {
        super(radius);
        this.center = new Point3D(center);
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Sphere copy
     **************************************************/
    public Sphere(Sphere copy) {
        this._radius=copy._radius;
        this.center = new Point3D(copy.getCenter());
        this.set_emmission(new Color(copy.get_emmission().getRGB()));
        this.set_nShininess(copy.get_nShininess());
        this.set_material(new Material(copy.get_material()));
    }

    // ***************** Operations ******************** //

    /*************************************************
     * FUNCTION
     * 		toString
     * 	abstract function of print format
     **************************************************/
    @Override
    public String toString() {
        return "radious: "+_radius+" center: "+center;
    }

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
     * subtract
     **************************************************/
    @Override
    public Vector getNormal(Point3D p) {
        Point3D po=new Point3D(p);
        Vector temp=new Vector(center);
        po.subtract(temp);
        Vector v=new Vector(po);
        v.normalize();
        return new Vector(v);
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
     * getSceneRayIntersections
     * findClosesntIntersection
     * dotProduct
     * add
     * scale
     **************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        ArrayList<Point3D> list =new ArrayList<Point3D>();
        Vector L=new Vector(center);
        L.subtract(new Vector(ray.get_POO()));
        double tm=L.dotProduct(ray.get_direction());
        double d=Math.sqrt(L.dotProduct(L)-tm*tm);
        if(d>_radius)return list;
        double th=Math.sqrt(_radius*_radius-d*d);
        double t1=tm-th;
        double t2=tm+th;//המצלמה עלולה להמצא בנקודה אחרת ולכן בודקים את החיתוך עם כל נקודות השפה
        Vector V=new Vector(ray.get_direction());
        if(t1>=0){
            Point3D p1=new Point3D(ray.get_POO());
            V.scale(t1);
            p1.add(V);
            list.add(p1);}
        if(t2>=0){//למרות שאין טעם לבדוק את הנקודה הקודמת אם הנוכחיצ לא מתאימה כך הקוד יותר קריא
            Point3D p2=new Point3D(ray.get_POO());
            V=new Vector(ray.get_direction());
            V.scale(t2);
            p2.add(V);
            list.add(p2);}
        return list;
    }
}
