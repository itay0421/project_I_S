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
 * abstract class to make sure all of the sons Elements class will implement important function
 * this class make sure that every class that extend her will have a color parameter to the object
 */

public interface LightSource {
  /*************************************************
   * FUNCTION
   * 		getintensity
   * PARAMETERS Point3D point
   * RETURN VALUE
   *		new color every class have to add her change in light.
   **************************************************/
  public abstract Color getIntensity(Point3D point);
  /*************************************************
   * FUNCTION
   * 		getL
   * PARAMETERS Point3D point
   * RETURN VALUE
   *		new Vector from the Light to the geometry.
   **************************************************/
  public abstract Vector getL(Point3D point); // light to point vector   
    
}
