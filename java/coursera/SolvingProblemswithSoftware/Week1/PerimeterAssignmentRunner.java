import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
 int count=0;
        for (Point currPt : s.getPoints()) {
            count=count+1;
        }
        return count;      
        
        
    }

    public double getAverageLength(Shape s) {
        // Put code here
double totalDist=0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalDist = totalDist+ currDist;
            prevPt = currPt;
 }
            return (totalDist/getNumPoints(s));
       
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double longest =0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(longest<currDist){
                longest=currDist;
            }
            prevPt = currPt;
        }
            return (longest);
        
    }

    public double getLargestX(Shape s) {

        // Put code here
        double largest =0.0;
         double x;
        for (Point currPt : s.getPoints()) {
            x=currPt.getX();
            if(largest<x){
                largest=x;
            }
            
        }
            return (largest);
        
    }

    public double getLargestPerimeterMultipleFiles() {
         DirectoryResource dr = new DirectoryResource();
        double largestPerimeter=0.0;
        double  perimeter=0.0;
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           Shape s = new Shape(fr);
           perimeter=getPerimeter (s);
           if(largestPerimeter<perimeter)
           largestPerimeter=perimeter;
           
           
     
 }
 return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; 
   // replace this code
 DirectoryResource dr = new DirectoryResource();
        double largestPerimeter=0.0;
        double  perimeter=0.0;
       
       for (File f : dr.selectedFiles()) {
           
           FileResource fr = new FileResource(f);
           Shape s = new Shape(fr);
           perimeter=getPerimeter (s);
           if(largestPerimeter<perimeter){
           largestPerimeter=perimeter;
           temp=f;
        }
    }
          

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
       
        
        int numPoints=getNumPoints(s);
        double avgLength=getAverageLength( s);
        double largest=getLargestSide(s);
        double largestX=getLargestX(s); 
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points = " + numPoints);
        System.out.println("Average Length= " + avgLength);
        System.out.println("Largest Side= " + largest);
        System.out.println("Largest X = " + largestX);
        
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
 System.out.println(getFileWithLargestPerimeter());
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
