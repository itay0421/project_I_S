package primitives;

/**
 * Created by shalom on 22/03/2017.
 */
public class Ray {
    private Point3D _POO;
    private Vector _direction;

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
    public void set_direction() {}

    /**
     * C'tor
     */
    public Ray() {
        this._POO=new Point3D();
        this._direction=new Vector();
    }
    public Ray(Point3D _POO, Vector _direction) {
        this._POO = _POO;
        this._direction = _direction;
    }
    public Ray(Ray ray){
        this._direction = ray._direction;
        this._POO = ray.get_POO();
    }
}
