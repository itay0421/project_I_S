package primitives;

/**
 * Created by איתי ומוריה on 21 מרץ 2017.
 */
public class Point3D extends Point2D implements Comparable<Point2D> {

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


    public int compareTo(Point3D point3D){
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
        return  "x = "+this.getX() + "\ny = " + this.getY() + "\nz = " +this.getZ();
    }

    public void add(Vector vector){};
    public void subtract(Vector vector){};
    public double distance(Point3D point){
     return    Math.sqrt(Math.pow(this.getX().getCoordinate() - point._x.getCoordinate() , 2) +
             Math.pow(this.getY().getCoordinate() - point.getY().getCoordinate(), 2)
        + Math.pow(this.getZ().getCoordinate() - point.getZ().getCoordinate() , 2 ));
    };



}