package geometries;

import primitives.*;

import java.awt.*;
import java.util.List;

/**
 * Created by {Itay Amar and Shalom bloch} on 27  2017.
 * abstract class to make sure all of the sons geometries class will implement important function
 * all the geometry shapes are implements those function
 */
public abstract class Geometry {
// any shep have to use in the next parameters to discover they color and lightness
    private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0); //  default color - black


    // ***************** Getters/Setters ********************** //
    public Material get_material() {
        return _material;
    }
    public void set_material(Material _material) {
        this._material = _material;
    }
    public double get_nShininess() {
        return _nShininess;
    }
    public void set_nShininess(double _nShininess) {
        this._nShininess = _nShininess;
    }
    public Color get_emmission() {
        return _emmission;
    }
    public void set_emmission(Color _emmission) {
        this._emmission = _emmission;
    }
//************ Setters of material************** //
    public void setKs(double ks){
        _material.set_Ks( ks);
    }
    public void setKd(double kd){
        _material.set_Kd(kd);
    }
    public void setKr(double kr){
        _material.set_Kr(kr);
    }
    public void setKt(double kt){
        _material.set_Kt(kt);
    }

    // ***************** Operations ******************** //
    /**
     * every shep  have to implement function the inditify all the Intersections points with
     * the geometry
     * @param ray
     * @return list of intersction points
     * implemnt by evre geometry,  and use in every scene
     */
    public abstract List<Point3D> FindIntersections (Ray ray);

    /**
     * every shep  have to implement function the find  the normal vector with a point in the scene
     * @param point
     * @return normal Vector
     * can be use in build scene.
     */
    public abstract Vector getNormal(Point3D point);

}
