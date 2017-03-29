
package primitives;

import java.text.DecimalFormat;

/**
 * Created by  on 19 מרץ 2017.
 */
public class Coordinate implements Comparable<Coordinate> {

    DecimalFormat df = new DecimalFormat("#.##");

    private double _coordinate;

    public Coordinate(){
        _coordinate= 0.0;
    };
    public Coordinate(double coordinate){
        this._coordinate = coordinate;
    };
    public Coordinate(Coordinate coordinate){
        this._coordinate = coordinate._coordinate;
    };



    public double getCoordinate() {
        return _coordinate;
    }
    public Coordinate setCoordinate(double _coordinate) {
        this._coordinate = _coordinate;
        return this;
    }

    @Override
    public int compareTo(Coordinate coordinate){
        if(this.getCoordinate() == coordinate._coordinate) return 0;
        if(this.getCoordinate() > coordinate._coordinate) return 1;
        else return -1;
    };

    public void add (Coordinate coordinate){
        this._coordinate += coordinate._coordinate;
    };
    public void subtract (Coordinate coordinate){
        this._coordinate -= coordinate._coordinate;
    };


}
