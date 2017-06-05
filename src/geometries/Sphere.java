package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */
/**public class Sphere extends RadialGeometry{
    private Point3D _center;

    public Point3D get_center() {
        return _center;
    }

    public Sphere set_center(Point3D _center) {
        this._center = _center;
        return this;
    }

    public Sphere(){
        this._center = new Point3D();
    }

    /**
     * copy C'tor
     * @param sphere
     */
/**
    public Sphere (Sphere sphere){
        this._radius = sphere._radius;
        this._center = new Point3D(sphere.get_center());
    }
    public Sphere(double radius, Point3D center){
        super(radius);
        this._center = new Point3D(center);
    }
    public Sphere(Map<String, String> attributes){}


    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        ArrayList<Point3D> list =new ArrayList<Point3D>();
        Vector L=new Vector(_center);
        L.subtract(new Vector(ray.get_POO()));
        double tm=L.dotProduct(ray.get_direction());
        double d=Math.sqrt(L.dotProduct(L)-tm*tm);
        if(d>_radius)return list;
        double th=Math.sqrt(_radius*_radius-d*d);
        double t1=tm-th;
        double t2=tm+th;
        Vector V=new Vector(ray.get_direction());
        if(t1>=0){
            Point3D p1=new Point3D(ray.get_POO());
            V.scale(t1);
            p1.add(V);
            list.add(p1);}
        if(t2>=0){
            Point3D p2=new Point3D(ray.get_POO());
            V=new Vector(ray.get_direction());
            V.scale(t2);
            p2.add(V);
            list.add(p2);}
        return list;
    }

    @Override
    public Vector getNormal(Point3D p) {
        Point3D po=new Point3D(p);
        Vector temp=new Vector(_center);
        po.subtract(temp);
        Vector v=new Vector(po);
        v.normalize();
        return new Vector(v);
    }
}
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Sphere extends RadialGeometry {

    private Point3D center;

    public Point3D getCenter() {
        return new Point3D(center);
    }

    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }

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
        //this.set_Emmission(new Color(copy.get_Emmission().getRGB()));
       // this.setnShininess(copy.getnShininess());
       // this.setMaterial(new Material(copy.getMaterial()));
    }

    @Override
    public String toString() {
        return "radious: "+_radius+" center: "+center;
    }



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
     *
     * @param ray
     * @return
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
