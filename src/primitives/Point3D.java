package primitives;

/**
 * Created by {Itay Amar and Shalom bloch} on 21  2017.
 */
public class Point3D extends Point2D   {

    private Coordinate _z;

    public Coordinate getZ() {
        return _z;
    }
    public Point3D setZ(Coordinate _z) {
        this._z = _z;
        return this;
    }

    public Point3D() {
        this._z = new Coordinate();
    }
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        super(_x, _y);
        this._z = _z;
    }
    public Point3D(double x, double y, double z) {
        super(new Coordinate(x),new Coordinate(y));
        this._z = new Coordinate(z);

    }
    public Point3D(Point3D point3D){
        super( point3D.getX(),point3D.getY() );
        this._z = point3D._z;

    }

    /**
     *
     * @param point3D
     * @return if points selfsame return 2, other option about distance from 'First of the contractions'.
     *
     */
    public int compareTo(Point3D point3D){
        if (this._x.compareTo(point3D.getX()) == 0 && this._y.compareTo(point3D._y) == 0 && this._z.compareTo(point3D._z) == 0)
                    return 2;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2) + Math.pow(this._z.getCoordinate(),2)) ==
                Math.sqrt(Math.pow(point3D._x.getCoordinate(),2) + Math.pow(point3D._y.getCoordinate(),2) + Math.pow(point3D._z.getCoordinate(),2)))
                    return 0;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2) + Math.pow(this._z.getCoordinate(),2)) >
                Math.sqrt(Math.pow(point3D._x.getCoordinate(),2) + Math.pow(point3D._y.getCoordinate(),2) + Math.pow(point3D._z.getCoordinate(),2)))
            return 1;
                 else return -1;
    };
    @Override
    public String toString(){
        return String.format("(%.2f,%.2f,%.2f)" , _x.getCoordinate(), _y.getCoordinate() , _z.getCoordinate() );
    }

    public void add(Vector vector){
        this._x.setCoordinate(this._x.getCoordinate() + vector.getHead().getX().getCoordinate());
        this._y.setCoordinate(this._y.getCoordinate() + vector.getHead().getY().getCoordinate());
        this._z.setCoordinate(this._z.getCoordinate() + vector.getHead().getZ().getCoordinate());
    }
    public void subtract(Vector vector){
        this._x.setCoordinate(this._x.getCoordinate() - vector.getHead().getX().getCoordinate());
        this._y.setCoordinate(this._y.getCoordinate() - vector.getHead().getY().getCoordinate());
        this._z.setCoordinate(this._z.getCoordinate() - vector.getHead().getZ().getCoordinate());
    }
    public double distance(Point3D point){
     return    Math.sqrt(Math.pow(this.getX().getCoordinate() - point._x.getCoordinate() , 2) +
                             Math.pow(this.getY().getCoordinate() - point.getY().getCoordinate(), 2)
                                + Math.pow(this.getZ().getCoordinate() - point.getZ().getCoordinate() , 2 ));
    }
}
