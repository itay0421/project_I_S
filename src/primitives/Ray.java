package primitives;

/**
 * Created by shalom on 22/03/2017.
 */
public class Ray {
    private Point3D _POO;
    private Vector _direction;

    public Point3D get_POO() {
        return _POO;
    }
    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }
    public Vector get_direction() {
        return _direction;
    }
    public void set_direction() {}

    public Ray(Point3D _POO, Vector _direction) {
        this._POO = _POO;
        this._direction = _direction;
    }
    public Ray(Ray ray){
        this._direction = ray._direction;
        this._POO = ray.get_POO();
    }
}
