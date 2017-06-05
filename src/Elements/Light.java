package Elements;

import java.awt.*;

/**
 * Created by shalom on 24/04/2017.
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
