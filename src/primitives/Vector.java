package primitives;

/**
 * Created by {Itay Amar and Shalom bloch} on 21 מרץ 2017.
 */
public class Vector {

    private Point3D _head;

    /**
     *
     * @return  _head
     */
    public Point3D getHead() {
        return _head;
    }

    /**
     * set
     * @param _head
     * @return
     */
    public Vector setHead(Point3D _head) {
        this._head = _head;
        return this;
    }

    public Vector(Point3D _head) {
        this._head = _head;
    }

    /**
     * default C'tor
     */
    public Vector() {
        _head = new Point3D();
    }
    public Vector(Vector vector) {
        _head = vector._head;
    }
    public Vector(double xHead, double yHead, double zHead) {
       this._head = new Point3D(xHead,yHead,zHead);
    }
    public Vector(Point3D p1, Point3D p2){
                this._head = new Point3D(p1.getX().getCoordinate() - p2.getX().getCoordinate(),
                                            p1.getY().getCoordinate() - p2.getY().getCoordinate(),
                                                p1.getZ().getCoordinate() - p2.getZ().getCoordinate() );
                this.normalize();
    }

    /**
     *
     * @param vector
     * @return 0 if equal
     */
    public int compareTo(Vector vector){
       if (this.length() > vector.length())
        return 1;
       if(this.length() < vector.length())
           return -1;
       else return 0;
    }
    @Override
    public String toString(){
        return this._head.toString();
    }

    /**
     * add vector to vector
     * @param vector
     */
    public void add(Vector vector) {
       this._head.add(vector);
    };

    /**
     * subtract vector from vector
     * @param vector
     */
    public void subtract(Vector vector) {
        this._head.subtract(vector);

    }

    /**
     *  scaling Factor
     * @param scalingFactor
     */
    public void scale(double scalingFactor){
        this._head = new Point3D(this._head.getX().getCoordinate()*scalingFactor , this._head.getY().getCoordinate()*scalingFactor ,
                this._head.getZ().getCoordinate()*scalingFactor);
    }

    /**
     *
     * @param vector
     * @return  Vector crossProduct
     */
    public Vector crossProduct(Vector vector){
        Vector a =  new Vector(this._head._y.getCoordinate()*vector._head.getZ().getCoordinate() -
                                            this._head.getZ().getCoordinate()*vector._head._y.getCoordinate(),
                                -1*(this._head.getX().getCoordinate()*vector._head.getZ().getCoordinate() -
                                            this._head.getZ().getCoordinate()*vector._head.getX().getCoordinate()),
                                this._head.getX().getCoordinate()*vector._head.getY().getCoordinate() -
                                            vector._head.getX().getCoordinate()*this._head.getY().getCoordinate());
        return a;
    }

    /**
     *
     * @return length of vector
     */
    public double length(){
        double a =  Math.sqrt(Math.pow(this._head._x.getCoordinate(),2) + Math.pow(this._head._y.getCoordinate(),2) +
                                                                                        Math.pow(this._head.getZ().getCoordinate(),2));
        return  a;
    }

    /**
     * normalize veftor
     */
    public void normalize(){
        if(this.length() ==  0)
            throw new ArithmeticException("length is 0 ");

        this.scale(1/this.length());
    }

    /**
     *
     * @param vector
     * @return dotProduct vector
     */
    public double dotProduct(Vector  vector){
        return  this._head.getX().getCoordinate() * vector._head.getX().getCoordinate()+
                this._head.getY().getCoordinate() * vector._head.getY().getCoordinate()+
                this._head.getZ().getCoordinate() * vector._head.getZ().getCoordinate();
    }
}




