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
// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Camera() {
        this._P0 = new Point3D();
        this._vUp = new Vector(new Point3D(new Coordinate(),new Coordinate(1),new Coordinate()));
        this._vTo = new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-1)));
        this._vRight = new Vector(_vTo.crossProduct(_vUp));
    }
/**
    public Camera() {
        this._P0 = new Point3D(0,0,10);
        this._vUp = new Vector(new Point3D(new Coordinate(1),new Coordinate(0.0),new Coordinate(0.0)));
        this._vTo = new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)));
        this._vRight = new Vector(_vTo.crossProduct(_vUp));
    }
*/
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Camera camera
     **************************************************/
    public Camera(Camera camera) {
        this._P0 = new Point3D(camera._P0);
        this._vTo = new Vector(camera._vTo);
        this._vUp = new Vector(camera._vUp);
        this._vRight = new Vector(_vTo.crossProduct(_vUp));
        
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Point3D _P0, Vector _vUp, Vector _vTo
     **************************************************/
    public Camera(Point3D _P0, Vector _vUp, Vector _vTo) {
        this._P0 = new Point3D(_P0);
        this._vUp = new Vector(_vUp);
        this._vTo = new Vector(_vTo);
        this._vRight = new Vector(_vTo.crossProduct(_vUp));
    }
    //public Camera (Map<String, String> attributes(;
    // ***************** Getters/Setters ********************** //

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
    public Vector vRight() {
        return _vRight;
    }
    public void vRight(Vector _vRight) {
        this._vRight = _vRight;
    }



    // ***************** Administration ********************** //
    /*************************************************
     * FUNCTION
     * 		toString
     * 	abstract function of print format
     **************************************************/
    @Override
    public String toString() {
        return  "P0 : " + _P0 + " up Vector: " + _vUp + " right vector: " + _vRight + " fowards vector: " + _vTo;

    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * 		constructRayThroughPixel
     * PARAMETERS
     * @param Nx- number of pixels from right to left
     * @param Ny-number of pixels from up to down
     * @param x- the index of pixel in the line
     * @param y- the index of pixel in column
     * @param screenDist- the distance between the camera and the screen view
     * @param screenWidth
     * @param screenHeight
     * RETURN VALUE
     *		new ray
     * MEANING
     * 		the function construct Ray Through Pixel we use in this function
     * 	as start to find a intersctions points with geometry, its make new ray who pass in the middle of the pixel
     * 	* SEE ALSO
     *     FindIntersections,
     *     scale
     *     subtract
     **************************************************/
    public Ray constructRayThroughPixel (int Nx, int Ny,double x, double y,double screenDist,
                                         double screenWidth, double screenHeight){

        double Rx = screenWidth/Nx;
        double Ry = screenHeight/Ny;

        Vector vTo = new Vector(_vTo);
        vTo.scale(screenDist);
        Point3D pc = new Point3D(_P0);
        pc.add(vTo);

        Vector vRight = new Vector(_vRight);
        vRight.scale((x - Nx/2.0)*Rx + Rx/2 );// we have to check option that the right code is  (x - Nx/2.0)*Rx - Rx/2 )
        Vector vUp = new Vector(_vUp);
        vUp.scale((y - Ny/2.0)*Ry + Ry/2); // we have to check option that the right code is (y - Ny/2.0)*Ry - Ry/2)
        vRight.subtract(vUp);
        pc.add(vRight);
        Point3D p = new Point3D(pc);

        Vector tmp = new Vector(_P0);
        p.subtract(tmp);

        Vector rayVector = new Vector(p);
        rayVector.normalize();
        return new Ray(new Point3D(pc), rayVector);

    }



}
