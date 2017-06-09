package primitives;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 */
public class Material {

    protected double _Kd; // Diffusion attenuation coefficient
    protected double _Ks; // Specular attenuation coefficient
    protected double _Kr; // Reflection coefficient (1 for mirror)
    protected double _Kt; // Refraction coefficient (1 for transparent)
    protected double _n; // Refraction index,shinnes

// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * default constructor
     **************************************************/
    public Material() {
        this._Kd = 1;
        this._Ks = 1;
        this._Kr = 0;
        this._Kt = 0;
        this._n = 1;
    }
    /*************************************************
     * FUNCTION
     * copy constructor
     * PARAMETERS
     * Material material
     **************************************************/
    public Material(Material material) {
        this._Kd = material._Kd;
        this._Ks = material._Ks;
        this._Kr = material._Kr;
        this._Kt = material._Kt;
        this._n = material._n;
    }

// ***************** Getters/Setters ********************** //
    /*************************************************
     * FUNCTION
     * 		get _Kd value
     **************************************************/
    public double get_Kd() {

        return _Kd;
    }
    /*************************************************
     * FUNCTION
     * 		set _Kd value
     **************************************************/
    public void set_Kd(double _Kd) {
        this._Kd = _Kd;
    }
    /*************************************************
     * FUNCTION
     * 		get _Ks value
     **************************************************/
    public double get_Ks() {
        return _Ks;
    }
    /*************************************************
     * FUNCTION
     * 		set _Ks value
     **************************************************/
    public void set_Ks(double _Ks) {
        this._Ks = _Ks;
    }
    /*************************************************
     * FUNCTION
     * 		get _Kr value
     **************************************************/
    public double get_Kr() {
        return _Kr;
    }
    /*************************************************
     * FUNCTION
     * 		set _Kr value
     **************************************************/
    public void set_Kr(double _Kr) {
        this._Kr = _Kr;
    }
    /*************************************************
     * FUNCTION
     * 		get _Kt value
     **************************************************/
    public double get_Kt() {
        return _Kt;
    }
    /*************************************************
     * FUNCTION
     * 		set _Kt value
     **************************************************/
    public void set_Kt(double _Kt) {
        this._Kt = _Kt;
    }
    /*************************************************
     * FUNCTION
     * 		get _n value
     **************************************************/
    public double get_n() {
        return _n;
    }
    /*************************************************
     * FUNCTION
     * 		set _n value
     **************************************************/
    public void set_n(double _n) {
        this._n = _n;
    }



}
