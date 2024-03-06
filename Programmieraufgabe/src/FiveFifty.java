import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

public class FiveFifty extends Game implements NumberGenerator {
    List<Integer> UnluckyNumbers;
    List<Integer> LuckyNumbers;
    List<Integer> LuckyNumbersEuro;

    public FiveFifty() {
        
        System.out.println("Ziehung der Lottozahlen 5 aus 50\n");
        UnluckyNumbers = new ArrayList<>();
        LuckyNumbers = new ArrayList<>();
        
        System.out.println("\nDie folgende Liste enthält die Unglückszahlen, die nicht in den generierten Zahlen vorkommen\nListe:");
        //TODO: Zahlen ändern ja oder nein als Abfrage, wenn nein nichts weiter, wenn ja methode aufrufen
        for(int unluckyNumber: this.LoadNumbers()){
            System.out.println(unluckyNumber +" ");
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
    List<Integer> LuckyNumbersEuro = new ArrayList<>();
    
    Integer [] colm1 = new Integer[50];
    for (int i=0;i <50;++i){
      colm1[i]=i+1;
    }

    Integer [] colm2 = new Integer[10];
    for (int i=0;i <10;++i){
      colm2[i]=i+1;
    }

    

    final List<Integer> ints1 = new ArrayList<Integer>(Arrays.asList(colm1));
    Iterator<Integer> iterator1 = ints1.iterator();
    while (iterator1.hasNext()) {
        Integer num = iterator1.next();
        if (UnluckyNumbers.contains(num)) {
            iterator1.remove(); // Removes the current element from ints1
        }
    }


    final List<Integer> ints2 = new ArrayList<Integer>(Arrays.asList(colm2));
    Iterator<Integer> iterator2 = ints2.iterator();
    while (iterator2.hasNext()) {
        Integer num = iterator2.next();
        if (UnluckyNumbers.contains(num)) {
        iterator2.remove();
        }
    }




    for(int i = 0; (i<5) && (ints1.size() > 0); i ++) {
      Integer random = ints1.get(new Random().nextInt(ints1.size()));
      this.LuckyNumbers.add(random);
      ints1.remove(random);
    } 
    
    for(int i = 0; (i<2) && (ints2.size() > 0); i ++) {
        Integer random = ints2.get(new Random().nextInt(ints2.size()));
        LuckyNumbersEuro.add(random);
        ints2.remove(random);
      } 
    
    LuckyNumbers.sort((int1, int2) -> int1.compareTo(int2));
    LuckyNumbersEuro.sort((int1, int2) -> int1.compareTo(int2));
    for(Integer num: LuckyNumbersEuro){
        LuckyNumbers.add(num);

    }
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
