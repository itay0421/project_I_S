package scene;

import Elements.AmbientLight;
import Elements.*;
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
    protected Color _backGround;//Background color.
    protected AmbientLight _ambientLight;
    protected Camera _camera;
    protected double _screenDistance;
    public List<Geometry> _geometries;//List of bodies Geometry that describe the scene
    public List<LightSource> _lights;

    // ***************** Constructors ********************** //

    /*************************************************
     * FUNCTION
     *      default constructor
     * * MEANING
     *       default _backGround color is black.
     *       default _screenDistance is 100.
     **************************************************/
    public Scene() {
        this._sceneName = null;
        this._backGround = new Color(0,0,0);
        this._ambientLight = new AmbientLight();
        this._camera = new Camera();
        this._screenDistance = 100;
        _geometries = new ArrayList<Geometry>();
        _lights = new ArrayList<LightSource>();
    }
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      String _sceneName, Color _backGround, AmbientLight _ambientLight,
     *      Camera _camera, double _screenDistance, List<Geometry> _geometries
     **************************************************/
    public Scene(String _sceneName, Color _backGround, AmbientLight _ambientLight,
                        Camera _camera, double _screenDistance, List<Geometry> _geometries) {
        this._sceneName = _sceneName;
        this._backGround = _backGround;
        this._ambientLight = new AmbientLight(_ambientLight);
        this._camera = new Camera(_camera);
        this._screenDistance = _screenDistance;
        this._geometries = new ArrayList<Geometry>();
        _lights = new ArrayList<LightSource>();
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Vector head
     **************************************************/
    public Scene(Scene s){
        this._sceneName = s._sceneName;
        this._backGround = s._backGround;
        this._ambientLight = new AmbientLight(s._ambientLight);
        this._camera = new Camera(s._camera);
        this._screenDistance = s._screenDistance;
        this._geometries = new ArrayList<Geometry>(s._geometries);
        this._lights = new ArrayList<LightSource>(s._lights);


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

    public List<LightSource> get_lights() {
        return _lights;
    }

    public void set_lights(List<LightSource> _lights) {
        this._lights = _lights;
    }

    // ***************** Operations ******************** //



    /*************************************************
     * FUNCTION
     * 		CompareTo
     * PARAMETERS
     *		Scene o
     * RETURN VALUE
     *		int - '0' if equal, else '1'
     * MEANING
     * 		This function compare between two Scene
     * 		and return '0' if they equals and '1' if they
     * 		don't
     **************************************************/
    @Override
    public int compareTo(Scene o) {
        if(( o._ambientLight.compareTo(_ambientLight)==0) && (o._backGround == _backGround)
                && (o._camera.equals(_camera)) && (o._sceneName ==_sceneName) &&
                (o._geometries.equals(_geometries)))
            return 0;
        return 1;
    }
    /*************************************************
     * FUNCTION
     * 		toString

     * RETURN VALUE
     *		"Scene{"sceneName" , backGround=" , ambientLight=" ,
     *		camera=", screenDistance=" , geometries=" }'
     **************************************************/
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
    /*************************************************
     * FUNCTION
     * 		addGeometry
     * MEANING
     *	    This function add  geometry to list
     **************************************************/
    public void addGeometry(Geometry g){
        _geometries.add(g);
    }
    public void addLight(LightSource l){ _lights.add(l);}

    /*************************************************
     * FUNCTION
     * 		Iterator
     * MEANING
     *	    A function that returns an iterator to go through the list
     **************************************************/
    public Iterator<Geometry> getGeometriesIterator(){
        return _geometries.iterator();
    }
    /*************************************************
     * FUNCTION
     * 		Iterator
     * MEANING
     *	    A function that returns an iterator to go through the list
     **************************************************/
    public Iterator<LightSource> getLightsIterator(){
        return _lights.iterator();
    }
}
