package Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class StaticSingleton {

    private static StaticSingleton instance = new StaticSingleton();

    private List<String> logStatic = new LinkedList();



   /*static {
        instance = new StaticSingleton();
    }*/

   private StaticSingleton() {
   }

    public static StaticSingleton getInstance() {
        return instance;
    }

    public void setLog(String newLeprecon) {
        logStatic.add(newLeprecon);
    }


    public void exportStaticSingleton()  { //

        try (FileWriter fw = new FileWriter("C:\\Users\\LENOVO\\Downloads\\leprecon.txt")) {

            for (String leprecon : logStatic) {
                fw.write(leprecon);
                fw.write("\n");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
