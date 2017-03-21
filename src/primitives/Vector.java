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

    public Vector(){
        _head = new Point3D();
    }
    public Vector (Vector vector){
        _head = vector._head;
    }

    public Vector(double xHead, double yHead, double zHead){
        super(new Coordinate());
    }
}
