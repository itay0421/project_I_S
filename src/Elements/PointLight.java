package Elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by itay0 on 05/06/2017.
 */
public class PointLight extends Light implements LightSource {
    double area;
    Point3D[] _position = new Point3D[81];
    double _Kc, _Kl, _Kq;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
        for ( int j = 1; j<11; j++) {
            _position[0+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate() + j/area),
                    new Coordinate(_position[0].getY().getCoordinate()),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[10+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate() - j/area),
                    new Coordinate(_position[0].getY().getCoordinate()),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[20+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate()),
                    new Coordinate(_position[0].getY().getCoordinate() + j/area),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[30+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate()),
                    new Coordinate(_position[0].getY().getCoordinate() - j/area),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[40+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate() + j/area),
                    new Coordinate(_position[0].getY().getCoordinate() + j/area),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[50+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate() - j/area),
                    new Coordinate(_position[0].getY().getCoordinate() + j/area),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[60+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate() - j/area),
                    new Coordinate(_position[0].getY().getCoordinate() - j/area),
                    new Coordinate(_position[0].getZ().getCoordinate()));
            _position[70+j] = new Point3D(new Coordinate(_position[0].getX().getCoordinate() + j/area),
                    new Coordinate(_position[0].getY().getCoordinate() - j/area),
                    new Coordinate(_position[0].getZ().getCoordinate()));
        }

    }

    public Point3D getPosition() {
        return new Point3D(_position[0]);
    }

    public void setPosition(Point3D position) {
        this._position[0] = new Point3D(position);
    }

    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
        this.color = new Color(color.getRGB());
        this._position[0] = new Point3D(position);
        this._Kc = kc;
        this._Kl = kl;
        this._Kq = kq;
        area=0;

    }
    public PointLight(Color color, Point3D position,double area, double kc, double kl, double kq) {
        this.color = new Color(color.getRGB());
        this._position[0] = new Point3D(position);
        this._Kc = kc;
        this._Kl = kl;
        this._Kq = kq;
        this.area = area;
        setArea(area);
    }

    // ***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point) {
        double d = point.distance(_position[0]);
        double temp = _Kc+_Kl*d+_Kq*d*d;
        int r = (int) (color.getRed() /temp);
        int g = (int) (color.getGreen() / temp);
        int b = (int) (color.getBlue() / temp);
        if(r>255)r=255;
        if(g>255)g =255;
        if(b>255)b=255;
        return new Color(r,g,b);
    }

    @Override
    public Vector getL(Point3D point) {
        Point3D point2=new Point3D(point);
        Vector temp=new Vector(_position[0]);
        point2.subtract(temp);
        Vector v=new Vector(point2);
        v.normalize();
        return v;
    }

    public Vector getL(Point3D point, int i) {
        Point3D point2=new Point3D(point);
        Vector temp=new Vector(_position[i]);
        point2.subtract(temp);
        Vector v=new Vector(point2);
        v.normalize();
        return v;
    }
}