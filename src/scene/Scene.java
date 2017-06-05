package scene;

import Elements.AmbientLight;
import Elements.Camera;
import geometries.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by itay0 on 29/05/2017.
 */
public class Scene implements Comparable<Scene>{

    protected String _sceneName;
    protected Color _backGround;
    protected AmbientLight _ambientLight;
    protected Camera _camera;
    protected double _screenDistance;
    public List<Geometry> _geometries;

    // ***************** Constructors ********************** //


    public Scene() {
        this._sceneName = null;
        this._backGround = new Color(255,255,255);
        this._ambientLight = new AmbientLight();
        this._camera = new Camera();
        this._screenDistance = 100;
        _geometries = new ArrayList<Geometry>();
    }

    public Scene(String _sceneName, Color _backGround, AmbientLight _ambientLight,
                        Camera _camera, double _screenDistance, List<Geometry> _geometries) {
        this._sceneName = _sceneName;
        this._backGround = _backGround;
        this._ambientLight = new AmbientLight(_ambientLight);
        this._camera = new Camera(_camera);
        this._screenDistance = _screenDistance;
        this._geometries = new ArrayList<Geometry>();
    }

    public Scene(Scene s){
        this._sceneName = s._sceneName;
        this._backGround = s._backGround;
        this._ambientLight = new AmbientLight(s._ambientLight);
        this._camera = new Camera(s._camera);
        this._screenDistance = s._screenDistance;
        this._geometries = new ArrayList<Geometry>(s._geometries);

    }
    // ***************** Getters/Setters **********************

    public String get_sceneName() {
        return _sceneName;
    }

    public void set_sceneName(String _sceneName) {
        this._sceneName = _sceneName;
    }

    public Color get_backGround() {
        return _backGround;
    }

    public void set_backGround(Color _backGround) {
        this._backGround = _backGround;
    }

    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public Camera get_camera() {
        return _camera;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    public double get_screenDistance() {
        return _screenDistance;
    }

    public void set_screenDistance(double _screenDistance) {
        this._screenDistance = _screenDistance;
    }

    public List<Geometry> get_geometries() {
        return _geometries;
    }

    public void set_geometries(List<Geometry> _geometries) {
        this._geometries = _geometries;
    }

    //******************************************************


    /**
     * Compare two scene
     * @param o
     * @return if equal return 0. else return 1.
     */
    @Override
    public int compareTo(Scene o) {
        if(( o._ambientLight.compareTo(_ambientLight)==0) && (o._backGround == _backGround)
                && (o._camera.equals(_camera)) && (o._sceneName ==_sceneName) &&
                (o._geometries.equals(_geometries)))
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "sceneName='" + _sceneName.toString() + '\'' +
                ", backGround=" + _backGround +
                ", ambientLight=" + _ambientLight.toString() +
                ", camera=" + _camera.toString() +
                ", screenDistance=" + _screenDistance +
                ", geometries=" + _geometries.toString() +
                '}';
    }

    public void addGeometry(Geometry g){
        _geometries.add(g);
    }

    public Iterator<Geometry> getGeometriesIterator(){
        return _geometries.iterator();
    }
}
