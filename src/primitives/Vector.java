package primitives;

/**
 * Created by איתי ומוריה on 21 מרץ 2017.
 */
public class Vector {

    private Point3D _head;

    public Point3D getHead() {
        return _head;
    }

    public Vector setHead(Point3D _head) {
        this._head = _head;
        return this;
    }

    public Vector(Point3D _head) {
        this._head = _head;
    }

    public Vector() {
        _head = new Point3D();
    }

    public Vector(Vector vector) {
        _head = vector._head;
    }

    public Vector(double xHead, double yHead, double zHead) {
        super(new Coordinate(), new Coordinate(), new Coordinate());
    }

    public void add(Vector vector) {
        this._head = new Point3D(this._head.getX().getCoordinate() + vector._head.getX().getCoordinate(), this.getHead().getY().getCoordinate()
                + vector._head.getY().getCoordinate(), this._head.getZ().getCoordinate() + vector._head.getZ().getCoordinate());
    };
    public void subtract(Vector vector) {
        this._head = new Point3D(this._head.getX().getCoordinate() -vector._head.getX().getCoordinate(), this.getHead().getY().getCoordinate() -
    vector._head.getY().getCoordinate(), this._head.getZ().getCoordinate() - vector._head.getZ().getCoordinate());

    }
    public void scale(double scalingFactor){
        this._head = new Point3D(this._head.getX().getCoordinate()*scalingFactor , this._head.getY().getCoordinate()*scalingFactor ,
                this._head.getZ().getCoordinate()*scalingFactor);
    }
    public Vector crossProduct(Vector vector){
        Vector a =  new Vector(this._head.getY().getCoordinate()*vector._head.getY().getCoordinate() - this._head.getZ().getCoordinate()*vector._head.getX().getCoordinate(),
                -1*(this._head.getX().getCoordinate()*vector._head.getZ().getCoordinate() - this._head.getZ().getCoordinate()*vector._head.getX().getCoordinate()),
                this._head.getX().getCoordinate()*vector._head.getY().getCoordinate() - vector._head.getX().getCoordinate()*this._head.getY().getCoordinate());
        return a;
    }
    public double length(){
        double a =  Math.sqrt(Math.pow(this._head._x.getCoordinate(),2) + Math.pow(this._head._y.getCoordinate(),2) + Math.pow(this._head.getZ().getCoordinate(),2));
        return  a;
    }
    public void normalize(){
        if(this.length() ==  0)
            throw new ArithmeticException;
        this.scale((1/this.length()));
    }
    public double dotProduct(Vector vector){
        return  this._head.getX().getCoordinate()*vector._head.getX().getCoordinate()+
                this._head.getY().getCoordinate()*vector._head.getY().getCoordinate()+
                this._head.getZ().getCoordinate()*vector._head.getZ().getCoordinate();
    }
}


