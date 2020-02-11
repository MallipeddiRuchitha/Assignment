import edu.duke.*;
import java.io.*;
/**
 * Write a description of class BatchInversions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchInversions
{  public ImageResource makeInversion(ImageResource inImage){
       ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
       for(Pixel pixel:outImage.pixels()){
           Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
           
           pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
             pixel.setBlue(255-inPixel.getBlue());
           
    }
    return outImage;
}
   public void selectAndConvert(){
	    DirectoryResource dr = new DirectoryResource();
	    for (File f : dr.selectedFiles()) {
	        ImageResource image = new ImageResource(f);
	        ImageResource invertedImage=makeInversion(image);
	        String fname = image.getFileName();
	        //System.out.print(fname);
			String newName = "inverted-" + fname;
			invertedImage.setFileName(newName);
			invertedImage.draw();
			invertedImage.save();
	        
	    
	   }
}
}
