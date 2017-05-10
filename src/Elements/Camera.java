package Elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 05 .
 */
public class Camera {
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;
    // ***************** Constructors ********************** //

    public Camera() {
        this._P0 = new Point3D();
        this._vTo = new Vector();
        this._vUp = new Vector();
    }

    /**
     * Copy C'tor
     * @param camera
     */
    public Camera(Camera camera) {
        this._P0 = new Point3D(camera._P0);
        this._vTo = new Vector(camera._vTo);
        this._vUp = new Vector(camera._vUp);
        
    }

    public Camera(Point3D _P0, Vector _vUp, Vector _vTo) {
        this._P0 = _P0;
        this._vUp = _vUp;
        this._vTo = _vTo;
    }
    //public Camera (Map<String, String> attributes(;

            // ***************** Getters/Setters ********************** //


    public Point3D get_P0() {
        return _P0;
    }

    public void set_P0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public void set_vUp(Vector _vUp) {
        this._vUp = _vUp;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public void set_vTo(Vector _vTo) {
        this._vTo = _vTo;
    }

    // ***************** Administration ********************** //

    @Override
    public String toString() {
        return "Camera{" +
                "_P0=" + _P0 +
                ", _vUp=" + _vUp +
                ", _vTo=" + _vTo +
                '}';
    }

    // ***************** Operations ******************** //
    public Ray constructRayThroughPixel (int Nx, int Ny,double x, double y,double screenDist,
                                         double screenWidth, double screenHeight){


        return null;
    }
}
