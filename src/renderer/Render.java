package renderer;

import Elements.Camera;

import primitives.*;

import primitives.Vector;
import scene.*;
import geometries.*;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by itay0 on 01/06/2017.
 */
public class Render implements Comparable<Render> {

    private Scene _scene;
    private ImageWriter _imageWriter; // for output

// ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      Scene _scene, ImageWriter _imageWriter
     **************************************************/
    public Render(Scene _scene, ImageWriter _imageWriter) {
        this._scene = new Scene(_scene);
        this._imageWriter = new ImageWriter(_imageWriter);
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Vector head
     **************************************************/
    public Render(Render r) {
        this._scene = new Scene(r._scene);
        this._imageWriter = new ImageWriter(r._imageWriter);
    }


    // ***************** Getters/Setters ********************** //

    public Scene get_scene() {
        return _scene;
    }
    public void set_scene(Scene _scene) {
        this._scene = _scene;
    }

    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }
    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = _imageWriter;
    }


    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * 		CompareTo
     * PARAMETERS
     *		Render o
     * RETURN VALUE
     *		int - '0' if equal, else '1'
     * MEANING
     * 		This function compare between two Renders
     * 		and return '0' if they equals and '1' if they
     * 		don't
     **************************************************/
    @Override
    public int compareTo(Render o) {
        if ((o._imageWriter.equals(_imageWriter)) && o._scene.compareTo(_scene) == 0)
            return 0;
        else return 1;
    }
    /*************************************************
     * FUNCTION
     * 		toString

     * RETURN VALUE
     *		"Render{" + "_scene=" + _scene.toString() + ", _imageWriter=" +
     *		_imageWriter.toString() + '}'
     **************************************************/
    @Override
    public String toString() {
        return "Render{" +
                "_scene=" + _scene.toString() +
                ", _imageWriter=" + _imageWriter.toString() +
                '}';
    }

    /*************************************************
     * FUNCTION
     * 		renderImage
     * MEANING
     *	    This function actualy render our image.
     *		It gets list of the closest point we see on the screen
     *		and calculate the right color for each point
     *SEE ALSO
     *		findClosesntIntersection and calcColor.
     **************************************************/
    public void renderImage() throws Exception
    {
        for(int i = 0; i < _imageWriter.getWidth(); i++)
        {	for(int j = 0; j <_imageWriter.getHeight(); j++)
        {
            Ray ray = new Ray(_scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(),
                    _imageWriter.getNy(), j, i,_scene.get_screenDistance(), _imageWriter.getWidth(),
                    _imageWriter.getHeight()));

            Map.Entry<Geometry, Point3D> entry = findClosesntIntersection(ray);
            if(entry==null || entry.getValue() == null)
                _imageWriter.writePixel( j , i , _scene.get_backGround() );
            else
                _imageWriter.writePixel( j , i , calcColor(entry.getKey(), entry.getValue(), ray) );
        }
        }
    }



    /*************************************************
     * FUNCTION
     * 		printGrid
     * PARAMETERS
     *		int interval - the number of squares we want to split the screen
     * RETURN VALUE
     * 		print grid on image.
     * MEANING
     *	    This function divides the screen to squares
     *		for its width and height by the given number(internal)
     **************************************************/
    public void printGrid(int interval)
    {
        for(int i = 0; i < _imageWriter.getWidth(); i++)
        {
            for(int j = 0; j  < _imageWriter.getHeight(); j++)
            {
                if(i % interval == 0 || i == _imageWriter.getWidth()-1
                        || j % interval == 0 || j == _imageWriter.getHeight() -1)
                    _imageWriter.writePixel(i, j, new Color(255,255,255));
            }
        }
    }
    /*************************************************
     * FUNCTION
     * 		writeToImage

     * MEANING
     *	    This function help write To image acoordingto
     *	    our
     *	    render
     *
     **************************************************/
    public void writeToImage()
    {
        _imageWriter.writeToimage();
    }

    /*************************************************
     * FUNCTION
     * 		calcColor
     * PARAMETERS
     *		Geometry geometry - the geometry in the front of the screen
     *		Point3D point - the exact point we want to calculate its color
     *		Ray inRay
     * RETURN VALUE
     * 		Color
     * MEANING
     *	    This function calculate the color in the given point
     *SEE ALSO
     *		addColors
     **************************************************/
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay)
    {
        Color color = new Color(0);
        color = addColors(geometry.get_emmission(), _scene.get_ambientLight().getIntensity());
        return color;

    }

    /*************************************************
     * FUNCTION
     * 		getClosestPoint
     * PARAMETERS
     *		Map<Geometry, List<Point3D>> intersectionPoints -
     *				a map with all geometries in the scene and
     *				their list of intersection points
     * RETURN VALUE
     * 		Entry<Geometry, Point3D>
     * MEANING
     *      Finds out from a list of the closest  points is
     *      that the distance from the PO projection point is minimal
     *	    This function return the closest geometry to screen
     *		and its list of intersection points in an Entry of the map
     **************************************************/
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = new Point3D(_scene.get_camera().get_P0());
        Map<Geometry,Point3D> minDistancePoint = new HashMap<Geometry,Point3D>();
        for (Map.Entry<Geometry,List<Point3D>> entry : intersectionPoints.entrySet())
        {
            for (Point3D point : entry.getValue())
            {
                if( P0.distance(point) < distance )
                {
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(),new Point3D(point));
                    distance = P0.distance(point);
                }
            }
        }
        return minDistancePoint;

    }

    /*************************************************
     * FUNCTION
     * 		findClosesntIntersection
     * PARAMETERS
     *		Ray ray - a ray that trough in the view plan
     * RETURN VALUE
     * 		Entry<Geometry, Point3D>
     * MEANING
     *	    This function return an entry to map with the closest points
     *		that the given ray intersect. the closest points will be seen
     *		on the screen
     *SEE ALSO
     *		getSceneRayIntersections and getClosestPoint
     **************************************************/
    private Map.Entry<Geometry, Point3D> findClosesntIntersection(Ray ray) throws Exception
    {
        Map<Geometry, List<Point3D>>intersectionPoints = new HashMap<Geometry,List<Point3D>>();
        intersectionPoints = getSceneRayIntersections(ray);
        Map<Geometry, Point3D> closestPoints = new HashMap<Geometry, Point3D>();
        closestPoints = getClosestPoint(intersectionPoints);
        if( closestPoints.isEmpty() )
            return null;
        Iterator<Map.Entry<Geometry, Point3D>> newMapIt = closestPoints.entrySet().iterator();
        Map.Entry<Geometry, Point3D> result = newMapIt.next();
        return result;
    }


    /*************************************************
     * FUNCTION
     * 		getSceneRayIntersections
     * PARAMETERS
     *		Ray ray - a ray that trough in the view plan
     * RETURN VALUE
     * 		Map<Geometry, List<Point3D>>
     * MEANING
     *      The function receives a ray  and needs to find its point
     *      of intersection with all the geometries in the scene.
     *	    This function return a map with all geometries
     *		that the given ray intersect.
     **************************************************/
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) throws Exception
    {
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        while(geometries.hasNext())
        {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = new ArrayList<Point3D>();
            geometryIntersectionPoints = geometry.FindIntersections(ray);
            intersectionPoints.put(geometry, geometryIntersectionPoints);
        }
        return intersectionPoints;

    }
    /*************************************************
     * FUNCTION
     * 		addColors
     * PARAMETERS
     *		Color a, Color b - the colors we want to add together
     * RETURN VALUE
     *		Color
     * MEANING
     * 		This function add between two Colors and returns new
     * 	    calculate color	.
     **************************************************/
    private Color addColors(Color a, Color b)
    {
        int rc,gc,bc;
        rc = a.getRed() + b.getRed();
        gc = a.getGreen() + b.getGreen();
        bc = a.getBlue() + b.getBlue();
        if (rc > 255)
            rc = 255;
        if(gc > 255)
            gc = 255;
        if(bc > 255)
            bc = 255;
        Color color = new Color(rc, gc, bc);

        return color;
    }
}