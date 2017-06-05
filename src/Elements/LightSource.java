package Elements;

/**
 * Created by itay0 on 05/06/2017.
 */

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;


import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * Created by itay0 on 05/06/2017.
 */
public interface LightSource {
    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point); // light to point vector

}
