package Elements;

import primitives.Coordinate;
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
    private Vector _vRight;
    // ***************** Constructors ********************** //

    public Camera() {
        this._P0 = new Point3D();
        this._vUp = new Vector(new Point3D(new Coordinate(),new Coordinate(1),new Coordinate()));
        this._vTo = new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-1)));
        this._vRight = new Vector(new Point3D(new Coordinate(1),new Coordinate(),new Coordinate()));
    }

    /**
     * Copy C'tor
     * @param camera
     */
    public Camera(Camera camera) {
        this._P0 = new Point3D(camera._P0);
        this._vTo = new Vector(camera._vTo);
        this._vUp = new Vector(camera._vUp);
        this._vRight = new Vector(_vUp.crossProduct(_vTo));
        
    }

    public Camera(Point3D _P0, Vector _vUp, Vector _vTo) {
        this._P0 = _P0;
        this._vUp = _vUp;
        this._vTo = _vTo;
        this._vRight = new Vector(_vUp.crossProduct(_vTo));
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
        return  "P0 : " + _P0 + " up Vector: " + _vUp + " right vector: " + _vRight + " fowards vector: " + _vTo;

    }

    // ***************** Operations ******************** //
    /**
     *
     * @param Nx- number of pixels from right to left
     * @param Ny-number of pixels from up to down
     * @param x- the index of pixel in the line
     * @param y- the index of pixel in column
     * @param screenDist- the distance between the camera and the screen view
     * @param screenWidth
     * @param screenHeight
     * @return point p of hit on screen
     */
    public Ray constructRayThroughPixel (int Nx, int Ny,double x, double y,double screenDist,
                                         double screenWidth, double screenHeight){
        double Rx = screenWidth/Nx;
        double Ry = screenHeight/Ny;

        Vector vTo = new Vector(_vTo);
        vTo.scale(screenDist);
        Point3D pc = new Point3D(_P0);
        pc.add(vTo);

        Vector vRight = new Vector(_vRight);
        vRight.scale((x - Nx/2.0)*Rx + Rx/2 );
        Vector vUp = new Vector(_vUp);
        vUp.scale((y - Ny/2.0)*Ry +Ry/2);
        vRight.subtract(vUp);
        pc.add(vRight);

        Vector tmp = new Vector(_P0);
        pc.subtract(tmp);

        Vector rayVector = new Vector(pc);
        rayVector.normalize();
        return new Ray(new Point3D(_P0), rayVector);

    }
}
