package primitives;

/**
 * Created by itay amar on 19 מרץ 2017.
 */
public class Point2D implements Comparable <Point2D>   {

    protected Coordinate _x;
    protected Coordinate _y;
// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * default constructor
     **************************************************/
    public Point2D() {
        this._x = new Coordinate();
        this._y = new Coordinate();
    }

    /**
     *
     * contractor - get 2 coordinate 
     * @param _x
     * @param _y
     */
    public Point2D(Coordinate _x, Coordinate _y) {
        this._x = new Coordinate(_x);
        this._y = new Coordinate(_y);
    }

    /*************************************************
     * FUNCTION
     * copy constructor
     * PARAMETERS
     * Point2D point2D
     **************************************************/
    public Point2D(Point2D point2D){
        this._x = new Coordinate(point2D.getX());
        this._y = new Coordinate(point2D.getY());
    };

// ***************** Getters/Setters ********************** //
    /**
     *
     * @return  Coordinate x
     */
    public Coordinate getX() {
        return _x;
    }

    /**
     *
     * @param _x
     * @return   set Coordinate x
     */
    public void setX(Coordinate _x) {
        this._x = _x;
    }

    /**
     *
     * @return set Coordinate y
     */
    public Coordinate getY() {
        return _y;
    }

    /**
     *
     * @param _y
     * @return set set Coordinate y
     */
    public Point2D setY(Coordinate _y) {
        this._y = _y;
        return this;
    }

    /**
     *
     * @param point2D
     * @return if points selfsame return 2, other option about distance from 'First of the contractions'.
     *
     */
    @Override
    public int compareTo(Point2D point2D){
        if (this._x.compareTo(point2D.getX()) == 0 && this._y.compareTo(point2D._y) == 0)
            return 2;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2)) ==
                  Math.sqrt(Math.pow(point2D._x.getCoordinate(),2) + Math.pow(point2D._y.getCoordinate(),2))) return 0;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2)) >
                Math.sqrt(Math.pow(point2D._x.getCoordinate(),2) + Math.pow(point2D._y.getCoordinate(),2))) return 1;
                else return -1;

    };


}

