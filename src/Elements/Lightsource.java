package Elements;


import primitives.*;
import java.awt.*;


/**
 * Created by shalom on 24/04/2017.
 */
public abstract class Lightsource {
   public abstract Color getIntensity(Point3D point);
   public abstract Vector getL(Point3D point); // light to point vector
}
