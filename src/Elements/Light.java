package Elements;

import java.awt.*;

/**
 * Created by shalom on 24/04/2017.
 * abstract class to make sure all of the sons geometries class will implement important function
 * this class make sure that every class that extend her will have a color parameter to the object
 */
public abstract class Light {

    protected Color color;

    // ***************** Constructors ********************** //
    public Light() {

    }

    public Light(Color color) {
        this.color = new Color(color.getRGB());
    }

    // ***************** Getters/Setters ********************** //
    public Color getIntensity() {
        return new Color(color.getRGB());
    }
}
