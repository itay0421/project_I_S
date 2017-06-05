package Elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * Created by itay0 on 05/06/2017.
 */
public class DirectionalLight extends Light implements LightSource{
    private Vector direction;
    // ***************** Constructors ********************** //
    public DirectionalLight(Color color, Vector direction)
    {
        this.color=new Color(color.getRGB());
        this.direction=new Vector(direction);
    }
// ***************** Getters/Setters ********************** //

    public Vector getDirection() {
        return new Vector(direction);
    }
    // ***************** Getters/Setters ********************** //
    public void setDirection(Vector _direction) {
        this.direction = new Vector(direction);
    }

    @Override
    public Color getIntensity(Point3D point){return new Color(color.getRGB());}

    @Override
    public Vector getL(Point3D point){return new Vector(direction);}


}