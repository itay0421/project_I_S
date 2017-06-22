package primitives;

import static java.sql.DriverManager.println;


public class Point3D extends Point2D  {

    protected Coordinate _z;

// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * default constructor
     **************************************************/
    public Point3D() {

        this._z = new Coordinate();
    }

    /*************************************************
     * FUNCTION
     * constructor from given parameter
     * PARAMETERS
     * Coordinate _x, Coordinate _y, Coordinate _z
     **************************************************/
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        super(_x, _y);
        this._z = new Coordinate(_z);
    }
    /*************************************************
     * FUNCTION
     * constructor from given parameter
     * PARAMETERS
     * double x, double y, double z
     **************************************************/
    public Point3D(double x, double y, double z) {
        super(new Coordinate(x),new Coordinate(y));
        this._z = new Coordinate(z);

    }

    /*************************************************
     * FUNCTION
     * copy constructor
     * PARAMETERS
     * Point3D point3D
     **************************************************/
    public Point3D(Point3D point3D){
        super(point3D);
        this._z = new Coordinate(point3D._z);

    }
// ***************** Getters/Setters ********************** //
    /*************************************************
     * FUNCTION
     * 		get _z value
     **************************************************/
    public Coordinate getZ() {
        return _z;
    }

    /*************************************************
     * FUNCTION
     * 		set _z value
     **************************************************/
    public void setZ(Coordinate _z) {
        this._z = _z;
    }
    // ***************** Operations ******************** //


    /*************************************************
     * FUNCTION
     * 		CompareTo
     * PARAMETERS
     *		Point3D point3D
     * RETURN VALUE
     *		if points selfsame return 0, other option is about distance
     *		from 'First of the contractions'.
     *
     * MEANING
     * 		This function compare between two Coordinates
     * 		and return '0' if they equals and '1' if they
     * 		don't
     **************************************************/
    public int compareTo(Point3D point3D){
        if (this._x.compareTo(point3D.getX()) == 0 && this._y.compareTo(point3D._y) == 0 && this._z.compareTo(point3D._z) == 0)
                    return 0;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2) + Math.pow(this._z.getCoordinate(),2)) ==
                Math.sqrt(Math.pow(point3D._x.getCoordinate(),2) + Math.pow(point3D._y.getCoordinate(),2) + Math.pow(point3D._z.getCoordinate(),2)))
                    return -1;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2) + Math.pow(this._z.getCoordinate(),2)) >
                Math.sqrt(Math.pow(point3D._x.getCoordinate(),2) + Math.pow(point3D._y.getCoordinate(),2) + Math.pow(point3D._z.getCoordinate(),2)))
            return 1;
                 else return -1;
    };
    /*************************************************
     * FUNCTION
     * 		toString

     * RETURN VALUE
     *		string -  format"(%.2f, %.2f, %.2f)"
     **************************************************/
    @Override
    public String toString(){

        return String.format("(%.2f, %.2f, %.2f)" , _x.getCoordinate(), _y.getCoordinate() , _z.getCoordinate() );
    }

    /*************************************************
     * FUNCTION
     * 		add
     * PARAMETERS
     *		Vector vector
     * RETURN VALUE
     *		none
     * MEANING
     * 		 add a vector to our vector
     **************************************************/
    public void add(Vector vector){
        this._x.setCoordinate(this._x.getCoordinate() + vector.getHead().getX().getCoordinate());
        this._y.setCoordinate(this._y.getCoordinate() + vector.getHead().getY().getCoordinate());
        this._z.setCoordinate(this._z.getCoordinate() + vector.getHead().getZ().getCoordinate());
    }


    /*************************************************
     * FUNCTION
     * 		subtract
     * PARAMETERS
     *		Vector vector
     * RETURN VALUE
     *		none
     * MEANING
     * 		 subtract point3D from point3D
     **************************************************/
    public void subtract(Vector vector){
        this._x.setCoordinate(this._x.getCoordinate() - vector.getHead().getX().getCoordinate());
        this._y.setCoordinate(this._y.getCoordinate() - vector.getHead().getY().getCoordinate());
        this._z.setCoordinate(this._z.getCoordinate() - vector.getHead().getZ().getCoordinate());
    }

    /*************************************************
     * FUNCTION
     * 		distance
     * PARAMETERS
     *		Point3D point
     * RETURN VALUE
     *		 double - distance between our point3D to point
     **************************************************/
    public double distance(Point3D point){
     return    Math.sqrt(Math.pow(this.getX().getCoordinate() - point._x.getCoordinate() , 2) +
                             Math.pow(this.getY().getCoordinate() - point.getY().getCoordinate(), 2)
                                + Math.pow(this.getZ().getCoordinate() - point.getZ().getCoordinate() , 2 ));
    }
    public Point3D f(Point3D point3D){
        Point3D p = new Point3D(650 - point3D.getX().getCoordinate(),point3D.getY().getCoordinate()- 650,point3D.getZ().getCoordinate());
        return p;
    }
}
