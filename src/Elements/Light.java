package Elements;

import java.awt.*;

/**
 * Created by shalom on 24/04/2017.
 */
public class Light {
    protected Color _color;
    // ***************** Constructors ********************** //
    public Light(){_color = new Color(0,0,0);};
    public Light(Color color) {
        this._color = new Color(color.getRGB());
    }
    public Color getIntensity() {
        return new Color(_color.getRGB());
    }
}
