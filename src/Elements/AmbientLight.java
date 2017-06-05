package Elements;

import primitives.Point3D;

import java.awt.*;

/**
 * Created by shalom on 24/04/2017.
 */
public class AmbientLight extends Light implements Comparable<AmbientLight> {

    private Color _color;
    private double _Ka;

    // ***************** Constructors ********************** //
    public AmbientLight() {
        this._color = new Color(255,255,255);
        this._Ka = 1.0;
    }
    public AmbientLight(Color _Color ,double _Ka ){
        this._color = new Color(_Color.getRGB());
        this._Ka = _Ka;
    };
    public AmbientLight(int r, int g, int b){
        this._color = new Color(r,b,g);
        this._Ka = 0.1;
    };
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

    /**
     * Compare two ambieant light
     * @param o
     * @return if equal return 0. else return 1.
     */
    @Override
    public int compareTo(AmbientLight o) {
        if ((o._Ka == _Ka)&&(o._color == _color))return 0;
        return 1;
    }

    @Override
    public String toString() {
        return "AmbientLight{" +
                "_color=" + _color +
                ", _Ka=" + _Ka +
                '}';
    }

    /**
     *
     * @return new color according to calculate intensity
     */
    public Color getIntensity(){
        int r=_color.getRed();
        int g=_color.getGreen();
        int b=_color.getBlue();
        r*=_Ka;
        g*=_Ka;
        b*=_Ka;
        return new Color(r ,b ,g ) ;
    }

    //@Override
    public Color getIntensity(Point3D point)
    {
        return (new Color((int)(_Ka*_color.getRed()),(int)( _Ka*_color.getGreen()),(int)( _Ka*_color.getBlue())));
    }
    //public AmbientLight(Map<String, String> attributes){};
}
