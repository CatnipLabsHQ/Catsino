import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveSystem {
  public static void save(double money) {

    try {
       BufferedWriter writer = new BufferedWriter(new FileWriter("SaveData.txt"));
       writer.write(String.valueOf(money));
       writer.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
   


  }

  public static double load () {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("SaveData.txt"));
      String line = reader.readLine();

      if (line != null) {
        return Double.parseDouble(line);
      }
    } 
    catch (IOException e) {
      e.printStackTrace();
    }

    return 0.0;
  }
}
