 


/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
  public boolean  twoOccurrences(String stringa ,String stringb){
      int curindex=stringb.indexOf(stringa);
      int count=0;
      while(curindex!=-1){
          count++;
          curindex=stringb.indexOf(stringa,curindex+stringa.length());
        
}
if(count>=2) 
 return true;
 else return false;
 

}
public String lastPart(String stringa ,String stringb){
    int index=stringb.indexOf(stringa);
    if(index!=-1)
    return stringb.substring(index+stringa.length());
    else return stringb;
    
}
    
public void testing(){
    System.out.println("a"+"  "+"abc defg "+twoOccurrences("a","abc defg"));
    System.out.println("a"+" "+"abc adefg "+twoOccurrences("a","abc adefg"));
    System.out.println("a"+" "+"bc defg "+twoOccurrences("a","bc defg"));
    System.out.println("a"+" "+"baac daaefg "+twoOccurrences("a","baac daaefg"));
    System.out.println("an"+" "+"banana  "+lastPart("an","banana"));
    System.out.println("zoo"+" "+"forest  "+lastPart("zoo","forest"));
    
    
}

}