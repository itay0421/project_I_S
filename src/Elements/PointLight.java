package Elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * Created by itay0 on 05/06/2017.
 */
public class PointLight extends Light implements LightSource {
    double area;
    Point3D _position;
    double _Kc, _Kl, _Kq;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Point3D getPosition() {
        return new Point3D(_position);
    }

    public void setPosition(Point3D _position) {
        this._position = new Point3D(_position);
    }

    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
        this.color = new Color(color.getRGB());
        this._position = new Point3D(position);
        this._Kc = kc;
        this._Kl = kl;
        this._Kq = kq;
        area=1;
    }
    public PointLight(Color color, Point3D position,double area, double kc, double kl, double kq) {
        this.color = new Color(color.getRGB());
        this._position = new Point3D(position);
        this.area=area;
        this._Kc = kc;
        this._Kl = kl;
        this._Kq = kq;
    }

    // ***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point) {
        double distance = point.distance(_position);
        int r = (int) (color.getRed() / (_Kc * _Kl * distance * _Kq * distance * distance));
        int g = (int) (color.getGreen() / (_Kc * _Kl * distance * _Kq * distance * distance));
        int b = (int) (color.getBlue() / (_Kc * _Kl * distance * _Kq * distance * distance));
        if(r>255)r=255;
        if(g>255)g =255;
        if(b>255)b=255;
        return new Color((r << 16) | (g << 8) | b);
    }

    @Override
    public Vector getL(Point3D point) {
        Point3D point2=new Point3D(point);
        Vector temp=new Vector(_position);
        point2.subtract(temp);
        Vector v=new Vector(point2);
        v.normalize();
        return v;
    }
}