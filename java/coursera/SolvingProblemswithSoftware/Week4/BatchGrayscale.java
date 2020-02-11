//import org.apache.commons.csv.*;
import edu.duke.*;
//import java.util.*;
import java.io.*;
/**
 * Write a description of class BatchGrayscale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchGrayscale
{
   public ImageResource makeGray(ImageResource inImage){
       ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
       for(Pixel pixel:outImage.pixels()){
           Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
           int average=(inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
           pixel.setRed(average);
            pixel.setGreen(average);
             pixel.setBlue(average);
           
    }
    return outImage;
}

	public void batchGreyscale(){
	    DirectoryResource dr = new DirectoryResource();
	    for (File f : dr.selectedFiles()) {
	        ImageResource image = new ImageResource(f);
	        ImageResource grayImage=makeGray(image);
	        String fname = image.getFileName();
	        //System.out.print(fname);
			String newName = "gray-" + fname;
			grayImage.setFileName(newName);
			grayImage.draw();
			grayImage.save();
	        
	    
	   }
}
}