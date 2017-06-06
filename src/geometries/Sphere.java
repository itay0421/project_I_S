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

    private Point3D center;
// ***************** Getters/Setters ********************** //
    public Point3D getCenter() {
        return new Point3D(center);
    }
    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }
    // ***************** Constructors ********************** //
    public Sphere() {
        this.center=new Point3D();
    }
    public Sphere( double radius , Point3D center) {
        super(radius);
        this.center = new Point3D(center);
    }
    public Sphere(Sphere copy) {
        this._radius=copy._radius;
        this.center = new Point3D(copy.getCenter());
        this.set_emmission(new Color(copy.get_emmission().getRGB()));
        this.set_nShininess(copy.get_nShininess());
        this.set_material(new Material(copy.get_material()));
    }

    // ***************** Operations ******************** //

    // print format use in every function
    // used by who went to print Sphere
    @Override
    public String toString() {
        return "radious: "+_radius+" center: "+center;
    }

    /**
     *the function purpose is to return the normal vector to sphere
     * @param p  POint3D that we went the normal between the point to the sphere
     * @return the normal vector
     * used in function to find intersction points
     */
    @Override
    public Vector getNormal(Point3D p) {
        Point3D po=new Point3D(p);
        Vector temp=new Vector(center);
        po.subtract(temp);
        Vector v=new Vector(po);
        v.normalize();
        return new Vector(v);
    }
    /**
     *
     *implement of abstract function from geometry abstract class
     * @param ray
     * @return list of intersction point of the shere and the parameter ray
     * size of the list bigger then 0.
     * used to build a scene of geometry
     * use vector function subtract, add, dotprodact. to calculate the intersection points
     */
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
