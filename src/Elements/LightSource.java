/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.awt.Color;

/**
 *
 */
public interface LightSource {
  public abstract Color getIntensity(Point3D point); 
  public abstract Vector getL(Point3D point); // light to point vector   
    
}
