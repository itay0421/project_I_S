package renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

    private int _imageWidth;//Image width (defined in pixels)
    private int _imageHeight;//Image height (defined in pixels)
    private int _Ny, _Nx; //Number of squares per row / column/
    final String PROJECT_PATH = System.getProperty("user.dir");//path where the file will be saved with the image
    private BufferedImage _image;
    //The name of the image that is actually the name of the file where the image will be saved
    private String _imageName;

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *      constructor from given parameter
     * PARAMETERS
     *      String imageName, int width, int height, int Ny, int Nx
     **************************************************/
    public ImageWriter(String imageName, int width, int height, int Ny, int Nx){

        _Nx = Nx;
        _Ny = Ny;

        _imageWidth = width;
        _imageHeight = height;

        _imageName = imageName;

        _image = new BufferedImage(
                _imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
    }
    /*************************************************
     * FUNCTION
     *      copy constructor
     * PARAMETERS
     *      Vector head
     **************************************************/
    public ImageWriter (ImageWriter imageWriter){
        _Nx = imageWriter._Nx;
        _Ny = imageWriter._Ny;

        _imageWidth = imageWriter.getWidth();
        _imageHeight = imageWriter.getHeight();

        _imageName = imageWriter._imageName;

        _image = new BufferedImage(
                _imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
    }

    // ***************** Getters/Setters ********************** //

    public int getWidth()  { return _imageWidth;  }
    public int getHeight() { return _imageHeight; }

    public int getNy() { return _Ny; }
    public int getNx() { return _Nx; }

    public void setNy(int _Ny) { this._Ny = _Ny; }
    public void setNx(int _Nx) { this._Nx = _Nx; }

    // ***************** Operations ******************** //

    /*************************************************
     * FUNCTION
     * 		writeToimage
     * PARAMETERS
     *		Map<Geometry, List<Point3D>> intersectionPoints -
     *				a map with all geometries in the scene and
     *				their list of intersection points
     * RETURN VALUE
     * 		file with image
     * MEANING
     *	    Write the image that was built by writePixel to a file whose
     *	    name is defined by the field
            ImageName _ saved in the folder defined by the projectPath_ field
     **************************************************/
    public void writeToimage(){

        File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");

        try {
            ImageIO.write(_image, "jpg", ouFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*************************************************
     * FUNCTION
     * 		writePixel
     * PARAMETERS
     *		int xIndex, int yIndex,
     *	    color -	int r, int g, int b

     * MEANING
     *	    This function write Pixel by color
     **************************************************/
    public void writePixel(int xIndex, int yIndex, int r, int g, int b){

        int rgb = new Color(r, g, b).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);

    }
    /*************************************************
     * FUNCTION
     * 		writePixel
     * PARAMETERS
     *		int xIndex, int yIndex,
     *	    color -	int[] rgbArray

     * MEANING
     *	    This function write Pixel by color
     **************************************************/
    public void writePixel(int xIndex, int yIndex, int[] rgbArray){

        int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);

    }
    /*************************************************
     * FUNCTION
     * 		writePixel
     * PARAMETERS
     *		int xIndex, int yIndex,
     *	    color -	color

     * MEANING
     *	    This function write Pixel by color
     **************************************************/
    public void writePixel(int xIndex, int yIndex, Color color){

        _image.setRGB(xIndex, yIndex, color.getRGB());

    }

}
