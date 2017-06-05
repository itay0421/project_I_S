package Elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * Created by itay0 on 05/06/2017.
 */
public class SpotLight extends PointLight {

    private Vector _direction;

    // ***************** Constructor ********************** //
    public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq) {
        super(color, position, kc, kl, kq);
        this._direction = new Vector(direction);
        _direction.normalize();
    }
    public SpotLight(Color color, Point3D position,double area,Vector direction, double kc, double kl, double kq) {
        super(color, position,area, kc, kl, kq);
        this._direction = new Vector(direction);
        _direction.normalize();
    }
    ;

    // ***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point) {
        Point3D po = new Point3D(point);
        Vector temp=new Vector(_position);
        po.subtract(temp);
        Vector D = new Vector(po);
        D.normalize();
        _direction.normalize();
        double distance = point.distance(_position);
        double dotP = D.dotProduct(_direction);
        dotP = Math.abs(dotP);
        int r = (int) ((color.getRed() * dotP) / (_Kc * _Kl * distance * _Kq * distance * distance));
        int g = (int) ((color.getGreen() * dotP) / (_Kc * _Kl * distance * _Kq * distance * distance));
        int b = (int) ((color.getBlue() * dotP) / (_Kc * _Kl * distance * _Kq * distance * distance));
        return new Color((r << 16) | (g << 8) | b);
    }

}
