package geometries;

import primitives.*;

import java.awt.*;
import java.util.List;

/**
 * Created by {Itay Amar and Shalom bloch} on 27  2017.
 */
public abstract class Geometry {

    private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);

    public abstract List<Point3D> FindIntersections (Ray ray);
    public abstract Vector getNormal(Point3D point);


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

}
