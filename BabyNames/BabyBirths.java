import edu.duke.*;
import org.apache.commons.csv.*;


public class BabyBirths{
    
    public void printNames(){
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100){
            System.out.println("Name " + rec.get (0) + " Gender " + rec.get(1) + " Num Born " + rec.get(2));
            }
            
        }
    }
    
    public int totalBirths (FileResource fr){
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
        }
        return totalBirths;
    }
    
    public int birthsByGender (FileResource fr, String gender){
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            }
        }
        return totalBirths;
    }
    
    public void testTotalBirths (){
        FileResource fr = new FileResource();
        int totalBirths = totalBirths(fr);
        System.out.println("total births ="  + totalBirths);
        int femaleBirths = birthsByGender (fr,"F");
        System.out.println("total female births = "  + femaleBirths);
        int maleBirths = birthsByGender (fr,"M");
        System.out.println("total male births = "  + maleBirths);
}
    
}