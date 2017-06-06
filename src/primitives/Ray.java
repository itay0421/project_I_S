package primitives;

/**
 * Created by shalom on 22/03/2017.
 */
public class Ray {
    private Point3D _POO;
    private Vector _direction;


// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * default constructor
     **************************************************/
    public Ray() {
        this._POO=new Point3D();
        this._direction=new Vector();
    }
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
    /**
     *
     * @return P00
     */
    public Point3D get_POO() {
        return _POO;
    }

    /**
     * set P00
     * @param _POO
     */
    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    /**
     *
     * @return direction
     */
    public Vector get_direction() {
        return _direction;
    }

    /**
     * set direction
     */
    public void set_direction(Vector d) {
        this._direction = new Vector(d);
    }
}
