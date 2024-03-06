import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SixFourtyNine extends Game implements NumberGenerator{
  List<Integer> UnluckyNumbers;
  List<Integer> LuckyNumbers;
  
  public SixFourtyNine() {
    System.out.println("Ziehung der Lottozahlen - 6 aus 49\n");
    UnluckyNumbers = new ArrayList<>();
    LuckyNumbers = new ArrayList<>();   
    System.out.println("\nDie folgende Liste enthält die Unglückszahlen, die nicht in den generierten Zahlen vorkommen\nListe:");
    //TODO: Zahlen ändern ja oder nein als Abfrage, wenn nein nichts weiter, wenn ja methode aufrufen
    for(int unluckyNumber: this.LoadNumbers()){
        System.out.println(unluckyNumber + " ");
    }
      
    UnluckyNumbers = this.readNumbers();
    if(this.checkNumbers(UnluckyNumbers)){
      this.ChangeNumbers(UnluckyNumbers);
      LuckyNumbers = generateNumbers(UnluckyNumbers);
      System.out.println("Das sind Ihre Glückszahlen");
      for (int luckyNumber: LuckyNumbers){
        System.out.println(luckyNumber + " ");
      }
    } else{
      System.out.println("Zahlen nicht im richtigen Bereich");
    }
  }  

  public List<Integer> generateNumbers(List<Integer> UnluckyNumbers){
    Integer [] colm = new Integer[49];
    for (int i=0;i <49;++i){
      colm[i]=i+1;
    }

    

    final List<Integer> ints = new ArrayList<Integer>(Arrays.asList(colm));
    Iterator<Integer> iterator = ints.iterator();
    while (iterator.hasNext()) {
        Integer num = iterator.next();
        if (UnluckyNumbers.contains(num)) {
            iterator.remove(); // Removes the current element from ints1
        }
    }


    for(int i = 0; (i<6) && (ints.size() > 0); i ++) {
      Integer random = ints.get(new Random().nextInt(ints.size()));
      this.LuckyNumbers.add(random);
      ints.remove(random);
    }    
    LuckyNumbers.sort((int1, int2) -> int1.compareTo(int2));
    return LuckyNumbers;
  }

    public List<Integer> readNumbers(){
        System.out.println("Geben Sie Ihre Unglückszahlen ein");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        String[] tokens = input.split("\\s+"); // Split input by whitespace
        List<Integer> UnluckyNumbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                UnluckyNumbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalide Eingabe: " + token + " ist keine Zahl.");
            }
        }

        System.out.println("List of numbers:");
        for (Integer num : UnluckyNumbers) {
            System.out.println(num);
        }

        return UnluckyNumbers;
    }

    public boolean checkNumbers(List<Integer> UnluckyNumbers){
        return true;
    }
}
