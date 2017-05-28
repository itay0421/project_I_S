package Elements;

import java.awt.*;

/**
 * Created by shalom on 24/04/2017.
 */
public class AmbientLight extends Light {

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


    //public AmbientLight(Map<String, String> attributes){};
}
