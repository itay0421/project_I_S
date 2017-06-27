package renderer;

import Elements.Camera;

import Elements.LightSource;
import Elements.PointLight;
import com.sun.javafx.collections.MappingChange;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;



import primitives.Vector;
import scene.*;
import geometries.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map;


/**
 * Created by itay0 on 01/06/2017.
 */
public class Render implements Comparable<Render> {

    private final int RECURSION_LEVEL = 4;
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
    private Color calcColor(Geometry geometry, Point3D point, Ray ray) throws Exception {
        return calcColor(geometry, point, ray, 0);
    }
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) throws Exception {

        if (RECURSION_LEVEL == level) { //condition for stop recursive
            return new Color(0, 0, 0);
        }
        int finalR,finalG,finalB;
        int difuseR = 0,
            difuseG = 0,
            difuseB = 0,
            specularR = 0,
            specularG = 0,
            specularB = 0;


        Iterator<LightSource>lights = _scene.getLightsIterator();
        while (lights.hasNext()){

            LightSource light = lights.next();
            double s = occluded(light, point, geometry);// 0 if tottaly shadow

            Color diffuse_t = new Color(calcDiffusiveComp(geometry.get_material().get_Kd(),
                                            geometry.getNormal(point),
                                            light.getL(point),
                                            light.getIntensity(point)).getRGB());
                difuseR += diffuse_t.getRed()* s;
                difuseB += diffuse_t.getBlue()* s;
                difuseG += diffuse_t.getGreen()* s;

                Color specular_t = new Color(calcSpecularComp(geometry.get_material().get_Ks(),
                                             new Vector(point, _scene.get_camera().get_P0()),
                                             geometry.getNormal(point),
                                             light.getL(point),
                                             geometry.get_nShininess(),
                                             light.getIntensity(point)).getRGB());
                specularR += specular_t.getRed()*s;
                specularB += specular_t.getBlue()*s;
                specularG += specular_t.getGreen()*s;


        }

        //reflected Light

        int reflectR = 0;
        int reflectG = 0;
        int reflectB = 0;

        if(geometry.get_material().get_Kr() != 0) {//for reduce useless checks
            Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
            Map<Geometry, Point3D> reflectedEntry =  getClosestPoint(getSceneRayIntersections(reflectedRay), reflectedRay);
            if (!reflectedEntry.isEmpty()) {

            Color reflectedColor = calcColor( reflectedEntry.entrySet().iterator().next().getKey(),
                    reflectedEntry.entrySet().iterator().next().getValue(), reflectedRay, level + 1);
            double kr = geometry.get_material().get_Kr();
            reflectR += (int) (kr * reflectedColor.getRed());
            reflectG += (int) (kr * reflectedColor.getGreen());
            reflectB += (int) (kr * reflectedColor.getBlue());
            }
        }
        Color reflectedLight = new Color(reflectR, reflectG, reflectB);

        int refractedR = 0;
        int refractedG = 0;
        int refractedB = 0;

        if(geometry.get_material().get_Kt() != 0) {//for reduce useless checks
            Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
            Map<Geometry, Point3D> refractedEntry =  getClosestPoint(getSceneRayIntersections(refractedRay), refractedRay);
            if (!refractedEntry.isEmpty()) {

                Color refractedColor = calcColor( refractedEntry.entrySet().iterator().next().getKey(),
                        refractedEntry.entrySet().iterator().next().getValue(), refractedRay, level + 1);
                double kt = geometry.get_material().get_Kt();
                refractedR += (int) (kt * refractedColor.getRed());
                refractedG += (int) (kt * refractedColor.getGreen());
                refractedB += (int) (kt * refractedColor.getBlue());
            }
        }

        Color refractedLight = new Color(refractedR, refractedG, refractedB);

        finalR =Math.min(255, _scene.get_ambientLight().getIntensity().getRed() + geometry.get_emmission().getRed() + difuseR + specularR + reflectedLight.getRed() + refractedLight.getRed());
        finalG =Math.min(255, _scene.get_ambientLight().getIntensity().getGreen() + geometry.get_emmission().getGreen() + difuseG + specularG + reflectedLight.getGreen() + refractedLight.getGreen());
        finalB =Math.min(255, _scene.get_ambientLight().getIntensity().getBlue() + geometry.get_emmission().getBlue() + difuseB + specularB + reflectedLight.getBlue() + refractedLight.getBlue());
        Color IO = new Color(finalR, finalG, finalB);
        return IO;

    }

    /**private Color calcColor(Geometry geometry, Point3D point, Ray inRay)
    {
        Color color = new Color(0);
        color = addColors(geometry.get_emmission(),_scene.get_ambientLight().getIntensity(point),new Color(0),new Color(0));
        return color;

    }
*/
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
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints, Ray ray)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = new Point3D(ray.get_POO());
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
            //intersectionPoints.put(geometry, geometryIntersectionPoints);
            if (!geometryIntersectionPoints.isEmpty()) {
                intersectionPoints.put(geometry, geometryIntersectionPoints);
            }
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
    private Color addColors(Color a, Color b, Color c, Color d)
    {
        int rc,gc,bc;
        rc = a.getRed() + b.getRed() + c.getRed() + d.getRed();
        gc = a.getGreen() + b.getGreen() + c.getGreen() + c.getGreen();
        bc = a.getBlue() + b.getBlue() + c.getBlue() + d.getBlue();

        Color color = new Color(checkLimitColor(rc, gc, bc).getRGB());

        return color;
    }


    /*************************************************
     * FUNCTION
     * 		calcDiffusiveComp
     * PARAMETERS
     *      kd diffuse factor
     *      normal of the geometry at that point - N
     *      lightToPoint the vector from the light to the point - L
     *      lightIntensity the intensity of the light
     *
     * RETURN VALUE
     * 		color - final Diffusive for point
     * MEANING
     *     The function calculates the diffuse
     *     light for a specific point.
     *     The function normalizes the vectors and then calculates R.
     *     The function calculates the factor factor and then
     *     multiplies all the colors.
     * SEE ALSO
     *		calcColor
     **************************************************/
    private Color calcDiffusiveComp(double kd, Vector normal, Vector lightToPoint, Color lightIntensity) {
        normal.normalize();
        lightToPoint.normalize();
        double difuseFactor = kd * normal.dotProduct(lightToPoint);
        difuseFactor = Math.abs(difuseFactor);

        int r = Math.min(255,(int) (lightIntensity.getRed() * difuseFactor));
        int g = Math.min(255,(int) (lightIntensity.getGreen() * difuseFactor));
        int b = Math.min(255,(int) (lightIntensity.getBlue() * difuseFactor));
        return new Color(r, g, b);
    }

    /*************************************************
     * FUNCTION
     * 		calcSpecularComp
     * PARAMETERS
     *      ks -  specular factor
     *      cameraToPoint -  vector from camera to point - V
     *      normalOfPoint -  normal of geometry at point - N
     *      lightToPoint - vector from light to point - D
     *      nShininess -  the amount of shininess
     *      intensity -  the intensity of the light
     *
     * RETURN VALUE
     * 		color - final Specular for point
     * MEANING
     *     The function calculates the Specular
     *     light for a specific point.
     *     The function normalizes the vectors and then calculates R.
     *     The function calculates the factor factor and then
     *     multiplies all the colors.
     * SEE ALSO
     *		calcColor
     **************************************************/
    private Color calcSpecularComp(double ks, Vector cameraToPoint,
                                   Vector normalOfPoint, Vector lightToPoint, double nShininess, Color intensity) {
        lightToPoint.normalize();
        normalOfPoint.normalize();
        cameraToPoint.normalize();
        double scale = 2 * normalOfPoint.dotProduct(lightToPoint);//2*(D*N)
        Vector temp = new Vector(normalOfPoint);
        temp.scale(scale);
        Vector R = new Vector(lightToPoint);//R=D-...
        R.subtract(temp);
        double factor = cameraToPoint.dotProduct(R);
        if (factor >= 0)
            return new Color(0,0,0);

        factor = Math.abs(factor);
        factor = Math.pow(factor, nShininess);

        int r =Math.min(255, (int) (factor * intensity.getRed() * ks));
        int g =Math.min(255, (int) (factor * intensity.getGreen() * ks));
        int b =Math.min(255, (int) (factor * intensity.getBlue() * ks));
        return new Color(r, g, b);
    }


    /*************************************************
     * FUNCTION
     * 		checkLimitColor
     * PARAMETERS
     *		r, g, b
     * RETURN VALUE
     * 		new color
     * MEANING
     *      heck color's Values after calculate
     **************************************************/
    private Color checkLimitColor(int r, int g, int b){
        if (r >= 255) {r = 255; }
        if (r < 0) {r = 0; }

        if (g >= 255) {g = 255; }
        if (g < 0) {g = 0; }

        if (b >= 255) {b = 255; }
        if (b < 0) {b = 0; }
        return new Color(r, g, b);
    }
    /*************************************************
     * FUNCTION
     * 		occluded
     * PARAMETERS
     *		LightSource light - light that make shadow
     *	    Point3D point - point to test shadow
     *	    Geometry geometry - geometry that shadow on it
     * RETURN VALUE
     * 		double between 1 to zero
     * MEANING
     *      The function calculates the shadow for each point in the scene.
     *      The calculation is to send rays from the point to each
     *      light source, and to calculate their sum.
     *      For a completely shaded point the function returns 0.
     *      For a point that has no shadow the function will return 1.
     *      And the shadow enhancement by adding sending 10
     *      rays to each illumination source.
     *      We will also check whether the cut points found are
     *      of transparent geometries, and in fact they
     *      do not make a shadow.
     *SEE ALSO
     *		tracehadow, calcColor
     **************************************************/
    private double occluded(LightSource light, Point3D point, Geometry geometry) throws Exception {
        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.scale(2);
        geometryPoint.add(epsVector);

        if (light instanceof PointLight && ((PointLight) light).getArea() != 0) {
            Vector lightDirectionArr[] = new Vector[9];
            double sumArr[] = new double[9];

            for(int i=0; i<9; i++) {
                sumArr[i] = tracehadow(lightDirectionArr,geometryPoint,light,point, geometry,i );
            }
            int sum = 0;
            for (double d : sumArr) sum += d;
            double average =  sum / 9.0;
            if(average!=0 && average!=1){
                average++;
                average--;
            }
            return average;
        }
        else{

            Vector lightDirection = light.getL(point);
            lightDirection.scale(-1);
            Ray lightRay = new Ray(geometryPoint, lightDirection);
            Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
            // Flat geometry cannot self intersect
            if (geometry instanceof FlatGeometry) {
                intersectionPoints.remove(geometry);
            }

            if(intersectionPoints.isEmpty()){
                return 1;
            }

            //for refracted, check if all points is refcract
            for (Map.Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
                if (entry.getKey().get_material().get_Kt() == 0) {
                    return 0;
                }

            }
            return 1;
        }
    }
    /*************************************************
     * FUNCTION
     * 		tracehadow
     * PARAMETERS
     *		Vector[]lightDirectionArr
     *	    Point3D geometryPoint
     *	    LightSource light
     *	    Point3D point
     * RETURN VALUE
     * 		average double between 1 to zero
     * MEANING
     *      The function calculates an average of N rays,
     *      in order to extract a softened edge of shadow
     *SEE ALSO
     *		oclooded, calcColor
     **************************************************/
    private double tracehadow(Vector[]lightDirectionArr,Point3D geometryPoint,LightSource light,Point3D point,Geometry geometry,int i ) throws Exception {
        lightDirectionArr[i] = ((PointLight) light).getL(point, i);
        lightDirectionArr[i].scale(-1);
        Ray lightRay = new Ray(geometryPoint, lightDirectionArr[i]);
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
        if (geometry instanceof FlatGeometry) {
            intersectionPoints.remove(geometry);
        }

        if(intersectionPoints.isEmpty()){
            return 1;
        }

        //for refracted, check if all points is refcract
        for (Map.Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
            if (entry.getKey().get_material().get_Kt() == 0) {
                return 0;
            }

        }
        return 1;
    }

    /*************************************************
     * FUNCTION
     * 		constructReflectedRay
     * PARAMETERS
     *		point position of ray
     *	    inRay original ray - D
     *	    normal - N
     *
     * RETURN VALUE
     * 		ray -R, for reflected
     * MEANING
     *      The function returns the light-continuation vector
     *      after damage to any object
     *SEE ALSO
     *		oclooded, calcColor
     **************************************************/
    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {
        Vector R = inRay.get_direction();

        double scale = 2 * R.dotProduct(normal);
        Vector N = new Vector(normal);
        N.normalize();
        N.scale(scale);
        R.subtract(N);

        Vector epsVec = new Vector(normal);
        if(normal.dotProduct(R) < 0){
            epsVec.scale(-2);
        }
        else {
            epsVec.scale(2);
        }

        Point3D pointIn = new Point3D(point);
        pointIn.add(epsVec);

        return new Ray(pointIn, R);
    }

    /*************************************************
     * FUNCTION
     * 		constructRefractedRay
     * PARAMETERS
     *		point position of ray
     *	    inRay original ray - D
     *	    normal - N
     *
     * RETURN VALUE
     * 		ray -R, for reflected
     * MEANING
     *      The function returns the
     *      light-continuation vector after harming any
     *      object for the function that calculates transparency in recursion
     *SEE ALSO
     *		oclooded, calcColor
     **************************************************/
    private Ray constructRefractedRay(Vector normal, Point3D point, Ray inRay) {

        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(inRay.get_direction());
        //epsVector.scale(0.00001);
        geometryPoint.add(epsVector);
        Vector newVector = new Vector(inRay.get_direction());
        newVector.normalize();
        return new Ray(geometryPoint, newVector);
    }

}