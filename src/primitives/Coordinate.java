
package primitives;

import java.text.DecimalFormat;

/**
 * Created by {Itay Amar and Shalom bloch} on 2017 04 .
 */
public class Coordinate implements Comparable<Coordinate> {

    DecimalFormat df = new DecimalFormat("#.##");

    private double _coordinate;

// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * default constructor
     **************************************************/
    public Coordinate(){
        _coordinate= 0.0;
    };

    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

    /**
     * C'tor
     * @param
     */

    /*************************************************
     * FUNCTION
     * copy constructor
     * PARAMETERS
     * Coordinate copy
     **************************************************/
    public Coordinate(Coordinate copy) {
        this._coordinate = copy.getCoordinate();
    }

// ***************** Getters/Setters ********************** //
    /**
     *
     * @return _coordinate
     */
    public double getCoordinate() {
        return _coordinate;
    }

    /**
     * set _coordinate
     * @param _coordinate
     * @return
     */
    public Coordinate setCoordinate(double _coordinate) {
        this._coordinate = _coordinate;
        return this;
    }

    /**
     *
     * @param coordinate
     * @return 0 if 2 coordinate is equale,
     */
    @Override
    public int compareTo(Coordinate coordinate){
        if(this.getCoordinate() == coordinate._coordinate) return 0;
        if(this.getCoordinate() > coordinate._coordinate) return 1;
        else return -1;
    };

    @Override
    public String toString() {
        return Double.toString(_coordinate);
    }

    /**
     * add coordinate to another coordinate
     * @param coordinate
     */
    public void add (Coordinate coordinate){
        this._coordinate += coordinate._coordinate;
    };

    /**
     *  subtract coordinate from another coordinate
     * @param coordinate
     */
    public void subtract (Coordinate coordinate){
        this._coordinate -= coordinate._coordinate;
    };


}
