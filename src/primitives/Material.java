package primitives;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 03 .
 */
public class Material {

    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refraction coefficient (1 for transparent)
    private double _n; // Refraction index

    public Material() {
        this._Kd = 1;
        this._Ks = 1;
        this._Kr = 0;
        this._Kt = 0;
        this._n = 1;
    }

    public Material(Material material) {
        this._Kd = material._Kd;
        this._Ks = material._Ks;
        this._Kr = material._Kr;
        this._Kt = material._Kt;
        this._n = material._n;
    }

    public double get_Kd() {

        return _Kd;
    }

    public Material set_Kd(double _Kd) {
        this._Kd = _Kd;
        return this;
    }

    public double get_Ks() {
        return _Ks;
    }

    public Material set_Ks(double _Ks) {
        this._Ks = _Ks;
        return this;
    }

    public double get_Kr() {
        return _Kr;
    }

    public Material set_Kr(double _Kr) {
        this._Kr = _Kr;
        return this;
    }

    public double get_Kt() {
        return _Kt;
    }

    public Material set_Kt(double _Kt) {
        this._Kt = _Kt;
        return this;
    }

    public double get_n() {
        return _n;
    }

    public Material set_n(double _n) {
        this._n = _n;
        return this;
    }



}
