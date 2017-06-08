package primitives;

/**
 * Created by shalom on 22/03/2017.
 */
public class Ray {
    protected Point3D _POO;
    protected Vector _direction;


// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * default constructor
     **************************************************/
    public Ray() {
        this._POO=new Point3D();
        this._direction=new Vector();
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Point3D _POO, Vector _direction
     **************************************************/
    public Ray(Point3D _POO, Vector _direction) {
        this._POO = new Point3D(_POO);
        this._direction = new Vector(_direction);
    }
    /*************************************************
     * FUNCTION
     * copy constructor
     * PARAMETERS
     * Ray ray
     **************************************************/
    public Ray(Ray ray){
        this._direction = new Vector (ray._direction);
        this._POO = new Point3D( ray.get_POO());
    }

// ***************** Getters/Setters ********************** //
    /*************************************************
     * FUNCTION
     * 		get _POO value
     **************************************************/
    public Point3D get_POO() {
        return _POO;
    }

    /*************************************************
     * FUNCTION
     * 		set _POO value
     **************************************************/
    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    /*************************************************
     * FUNCTION
     * 		get _direction value
     **************************************************/
    public Vector get_direction() {
        return _direction;
    }

    /*************************************************
     * FUNCTION
     * 		set _direction value
     **************************************************/
    public void set_direction(Vector d) {
        this._direction = new Vector(d);
    }
}
