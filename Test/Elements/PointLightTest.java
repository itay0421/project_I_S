package Elements;

import org.junit.Test;
import primitives.Point3D;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by itay0 on 26/06/2017.
 */
public class PointLightTest {
    @Test
    public void setArea() throws Exception {
        PointLight pointLight = new PointLight(new Color(255, 100, 100), new Point3D(-300, -300, -150), 0.1, 0.00001, 0.000005);
        pointLight.setArea(5);


    }

}