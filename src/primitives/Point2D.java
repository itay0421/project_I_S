package primitives;

/**
 * Created by itay amar on 19 מרץ 2017.
 * more changes 11111111
 */
public class Point2D implements Comparable<Point2D>{

    protected Coordinate _x;
    protected Coordinate _y;


    public Point2D() {

        this._x = new Coordinate();
        this._y = new Coordinate();
    }
    public Point2D(Coordinate _x, Coordinate _y) {
        this._x = _x;
        this._y = _y;
    }
    public Point2D(Point2D point2D){
        this._x = point2D._x;
        this._y = point2D._y;
    };


    public Coordinate getX() {
        return _x;
    }
    public Point2D setX(Coordinate _x) {
        this._x = _x;
        return this;
    }
    public Coordinate getY() {
        return _y;
    }
    public Point2D setY(Coordinate _y) {
        this._y = _y;
        return this;
    }

    @Override
    public int compareTo(Point2D point2D){
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2)) ==
                  Math.sqrt(Math.pow(point2D._x.getCoordinate(),2) + Math.pow(point2D._y.getCoordinate(),2))) return 0;
        if (Math.sqrt(Math.pow(this._x.getCoordinate(),2) + Math.pow(this._y.getCoordinate(),2)) >
                Math.sqrt(Math.pow(point2D._x.getCoordinate(),2) + Math.pow(point2D._y.getCoordinate(),2))) return 1;
                else return -1;

    };
}
