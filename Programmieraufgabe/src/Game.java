import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
  public Game() {
    
  }  

  public void ChangeNumbers(List<Integer> UnluckyNumbers) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("UnluckyNumbers.txt"))) {
      for (Integer unluckyNumber : UnluckyNumbers) {
          writer.write(unluckyNumber.toString());
          writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Integer> LoadNumbers(){
    List<Integer> UnluckyNumbers = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("UnluckyNumbers.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        UnluckyNumbers.add(Integer.parseInt(line));
      }
  } catch (IOException e) {
      e.printStackTrace();
  }
  return UnluckyNumbers;

  }

  
}
