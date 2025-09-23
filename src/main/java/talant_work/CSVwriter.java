package talant_work;

import java.io.FileWriter;
import java.io.IOException;

public class CSVwriter{
    public static void write(String filename,int n,int comparisons, int recursion_depth){
        try (FileWriter writer = new FileWriter(filename,true)){
            writer.append(n + "," + comparisons+"," + recursion_depth + "\n");

        } catch (IOException e) {e.printStackTrace();
        }
        }
    }    
}