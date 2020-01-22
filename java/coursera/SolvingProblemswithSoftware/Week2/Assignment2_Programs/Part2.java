
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
   public int howMany(String stringa,String stringb){
       int count=0;
       int index;
       while(true){
           index=stringb.indexOf(stringa);
           if(index==-1){
           break;}
           else{
           count++;
           stringb=stringb.substring(index+stringa.length());}
           
           
    }
    return count;
   
}
public void testHowMany(){
    System.out.println("GAA"+"      "+"ATGAACGAATTGAATC"+"      "+howMany("GAA","ATGAACGAATTGAATC"));
     System.out.println("AA"+"      "+"ATAAAA"+"      "+howMany("AA","ATAAAA"));
      //System.out.println(""+"      "+""+"      "+howMany());
    
}
}
