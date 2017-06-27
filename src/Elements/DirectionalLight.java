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

    /*************************************************
     * FUNCTION
     * 		getIntensity
     * PARAMETERS Point3D point
     * RETURN VALUE
     *		new Color that including the Dirctional light.
     **************************************************/
    @Override
    public Color getIntensity(Point3D point){return new Color(color.getRGB());}

    /*************************************************
     * FUNCTION
     * 		getL
     * PARAMETERS Point3D point
     * RETURN VALUE
     *		new Vector from the Light to the geometry.
     **************************************************/
    @Override
    public Vector getL(Point3D point){return new Vector(direction);}


}