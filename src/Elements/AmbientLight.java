package Elements;

import primitives.Point3D;

import java.awt.*;

/**
 * Created by shalom on 24/04/2017.
 */
public class AmbientLight extends Light implements Comparable<AmbientLight> {

    // color parameter of the object
    private Color _color;
    // _Ka is parameter to calculate the lightness of the object
    private double _Ka;

    // ***************** Constructors ********************** //
    // defulte ctor - color white
    public AmbientLight() {
        this._color = new Color(255,255,255);
        this._Ka = 0.1;
    }
    public AmbientLight(Color _Color ,double _Ka ){
        this._color = new Color(_Color.getRGB());
        this._Ka = _Ka;
    };
    public AmbientLight(int r, int g, int b){
        this._color = new Color(r,b,g);
        this._Ka = 0.1;
    };
    // copy ctor
    public AmbientLight(AmbientLight ambientLight){
        this._color = new Color(ambientLight._color.getRGB());
        this._Ka = ambientLight._Ka;
    }

    // ***************** Getters/Setters **********************
    public Color get_color() {
        return _color;
    }
    public void set_color(Color _color) {
        this._color = _color;
    }
    public double get_Ka() {
        return _Ka;
    }
    public void set_Ka(double _Ka) {
        this._Ka = _Ka;
    }
    //*********************************************************

    /*************************************************
     * FUNCTION
     * 		comperto
     * PARAMETERS AmbiantLight
     * RETURN VALUE
     *		0 if they equal 1 if they are not equal
     * MEANING
     *checking if the ambiantLight are the same
     **************************************************/
    @Override
    public int compareTo(AmbientLight o) {
        if ((o._Ka == _Ka)&&(o._color == _color))return 0;
        return 1;
    }

    /*************************************************
     * FUNCTION
     * 		Tostring
     * MEANING
     * print to the computer the date
     *  **************************************************/
    @Override
    public String toString() {
        return "AmbientLight{" +
                "_color=" + _color +
                ", _Ka=" + _Ka +
                '}';
    }

    /*************************************************
     * FUNCTION
     * 		get intensity
     * RETURN VALUE
     *		new Color that including the ambient light.
     **************************************************/
    public Color getIntensity(){
        int r=_color.getRed();
        int g=_color.getGreen();
        int b=_color.getBlue();
        r*=_Ka;
        g*=_Ka;
        b*=_Ka;
        return new Color(r ,b ,g ) ;
    }

    /*************************************************
     * FUNCTION
     * 		getIntensity
     * PARAMETERS Point3D point
     * RETURN VALUE
     *		new Color that including the ambient light.
     **************************************************/
    //@Override
    public Color getIntensity(Point3D point)
    {
        return (new Color((int)(_Ka*_color.getRed()),(int)( _Ka*_color.getGreen()),(int)( _Ka*_color.getBlue())));
    }
}
