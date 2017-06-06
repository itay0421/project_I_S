
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
    /*************************************************
     * FUNCTION
     * constructor from given parameter
     * PARAMETERS
     * double coordinate
     **************************************************/
    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

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
    /*************************************************
     * FUNCTION
     * 		get _coordinate value
     **************************************************/
    public double getCoordinate() {
        return _coordinate;
    }

    /*************************************************
     * FUNCTION
     * 		set _coordinate value
     **************************************************/
    public Coordinate setCoordinate(double _coordinate) {
        this._coordinate = _coordinate;
        return this;
    }

    /*************************************************
     * FUNCTION
     * 		CompareTo
     * PARAMETERS
     *		Coordinate coordinate
     * RETURN VALUE
     *		int - '1' if equal, else '0'
     * MEANING
     * 		This function compare between two Coordinates
     * 		and return '0' if they equals and '1' if they
     * 		don't
     **************************************************/
    @Override
    public int compareTo(Coordinate coordinate){
        if(this.getCoordinate() == coordinate._coordinate) return 0;
        if(this.getCoordinate() > coordinate._coordinate) return 1;
        else return -1;
    };
    /*************************************************
     * FUNCTION
     * 		toString

     * RETURN VALUE
     *		Double -  _coordinate value
     **************************************************/
    @Override
    public String toString() {
        return Double.toString(_coordinate);
    }

    /*************************************************
     * FUNCTION
     * 		add
     * PARAMETERS
     *		Coordinate coordinate
     * RETURN VALUE
     *		none
     * MEANING
     * 		 add a Coordinate to our Coordinate
     **************************************************/
    public void add (Coordinate coordinate){
        this._coordinate += coordinate._coordinate;
    };

    /*************************************************
     * FUNCTION
     * 		subtract
     * PARAMETERS
     *		Coordinate coordinate
     * RETURN VALUE
     *		none
     * MEANING
     * 		 subtract a Coordinate from our Coordinate
     **************************************************/
    public void subtract (Coordinate coordinate){
        this._coordinate -= coordinate._coordinate;
    };


}
