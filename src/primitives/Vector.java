package primitives;


public class Vector {

    protected Point3D _head;

// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      default constructor
     **************************************************/
    public Vector() {
        _head = new Point3D();
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Point3D head
     **************************************************/
    public Vector(Point3D head) {
        this._head = new Point3D(head);
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Vector head
     **************************************************/
    public Vector(Vector head) {
        this._head = new Point3D(head._head);
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      double xHead, double yHead, double zHead
     **************************************************/
    public Vector(double xHead, double yHead, double zHead) {
       this._head = new Point3D(xHead,yHead,zHead);
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Point3D p1, Point3D p2
     * MEANING
     *      this c'tor create vector by substact p2
     *      from p1
     **************************************************/
    public Vector(Point3D p1, Point3D p2){
                this._head = new Point3D(p1.getX().getCoordinate() - p2.getX().getCoordinate(),
                                            p1.getY().getCoordinate() - p2.getY().getCoordinate(),
                                                p1.getZ().getCoordinate() - p2.getZ().getCoordinate() );
                this.normalize();
    }
// ***************** Getters/Setters ********************** //

    /*************************************************
     * FUNCTION
     * 		get _head value
     **************************************************/
    public Point3D getHead() {
        return _head;
    }

    /*************************************************
     * FUNCTION
     * 		set _head value
     **************************************************/
    public void  setHead(Point3D _head) {
        this._head = _head;
    }

    // ***************** Operations ******************** //

    /*************************************************
     * FUNCTION
     * 		CompareTo
     * PARAMETERS
     *		Coordinate coordinate
     * RETURN VALUE
     *		int - '0' if equal
     *
     **************************************************/
    public int compareTo(Vector vector){
       if (this.length() > vector.length())
        return 1;
       if(this.length() < vector.length())
           return -1;
       else return 0;
    }
    /*************************************************
     * FUNCTION
     * 		toString
     **************************************************/
    @Override
    public String toString(){
        return this._head.toString();
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
    public void add(Vector vector) {
       this._head.add(vector);
    };

    /*************************************************
     * FUNCTION
     * 		subtract
     * PARAMETERS
     *		Vector vector
     * RETURN VALUE
     *		none
     * MEANING
     * 		 subtract vector from vector
     **************************************************/
    public void subtract(Vector vector) {
        this._head.subtract(vector);

    }

    /**
     *  scaling Factor
     * @param scalingFactor
     */
    /*************************************************
     * FUNCTION
     * 		scale
     * PARAMETERS
     *		double scalingFactor
     * RETURN VALUE
     *		none
     * MEANING
     * 		 scaling Factor with vector
     **************************************************/
    public void scale(double scalingFactor){
        this._head = new Point3D(this._head.getX().getCoordinate()*scalingFactor , this._head.getY().getCoordinate()*scalingFactor ,
                this._head.getZ().getCoordinate()*scalingFactor);
    }

    /*************************************************
     * FUNCTION
     * 		crossProduct
     * PARAMETERS
     *		Vector vector
     * RETURN VALUE
     *		Vector Normal
     * MEANING
     * 		 crossProduct Factor with vector
     **************************************************/
    public Vector crossProduct(Vector vector){
        Vector a =  new Vector(this._head._y.getCoordinate()*vector._head.getZ().getCoordinate() -
                                            this._head.getZ().getCoordinate()*vector._head._y.getCoordinate(),
                                -1*(this._head.getX().getCoordinate()*vector._head.getZ().getCoordinate() -
                                            this._head.getZ().getCoordinate()*vector._head.getX().getCoordinate()),
                                this._head.getX().getCoordinate()*vector._head.getY().getCoordinate() -
                                            vector._head.getX().getCoordinate()*this._head.getY().getCoordinate());
        return a;
    }


    /*************************************************
     * FUNCTION
     * 		length
     * RETURN VALUE
     *		double length
     * MEANING
     * 		 return length of normal
     **************************************************/
    public double length(){
        double a =  Math.sqrt(Math.pow(this._head._x.getCoordinate(),2) + Math.pow(this._head._y.getCoordinate(),2) +
                                                                                        Math.pow(this._head.getZ().getCoordinate(),2));
        return  a;
    }

    /*************************************************
     * FUNCTION
     * 		normalize
     * MEANING
     * 		 normalize vector.
     * 		 if length is 0, returm ArithmeticException("length is 0 ")
     **************************************************/
    public void normalize(){
        if(this.length() ==  0)
            throw new ArithmeticException("length is 0 ");

        this.scale(1/this.length());
    }


    /*************************************************
     * FUNCTION
     * 		dotProduct
     * PARAMETERS
     *		Vector  vector
     * RETURN VALUE
     *		double - dotProduct of vector
     **************************************************/
    public double dotProduct(Vector  vector){
        return  this._head.getX().getCoordinate() * vector._head.getX().getCoordinate()+
                this._head.getY().getCoordinate() * vector._head.getY().getCoordinate()+
                this._head.getZ().getCoordinate() * vector._head.getZ().getCoordinate();
    }
}




