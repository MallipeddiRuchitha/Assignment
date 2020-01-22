 

import edu.duke.*;
/**
 * Write a description of class Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part4
{   public void findWebLinks(){
    URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
     int i;
    for (String s : ur.words()) {
        i=s.toLowerCase().indexOf("youtube.com");
        if(i!=-1){
        System.out.println(s.substring(s.indexOf("\"")+1,s.lastIndexOf("\"")));
    }
    }
     
     // print or process s
 }
    
    
}
