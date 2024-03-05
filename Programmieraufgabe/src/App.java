import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

//import FiveFifty;
//import SixFourtyNine;

public class App {
    public static void main(String[] args) {
        
        System.out.println("Für welches Spiel sollen Zahlen generiert werden?\nFür Lotto 6aus49 oder für Eurojackpot?\n");
        Scanner scanner = new Scanner(System.in);
        String gameName = scanner.nextLine();
        

        switch (gameName) {
            case "":    
                SixFourtyNine game = new SixFourtyNine();
                System.out.println("Glückszahlen für das Spiel " + gameName + " werden generiert...");
                break;
            case "Lotto 6aus49":  
                SixFourtyNine game2 = new SixFourtyNine();
                System.out.println("Glückszahlen für das Spiel " + gameName + " werden generiert...");
                break;
            case "Eurojackpot": 
                FiveFifty game3 = new FiveFifty();
                System.out.println("Glückszahlen für das Spiel " + gameName + " werden generiert...");
                break;
            default: 
                System.out.println("Kein gültiger Name angegeben.\n Die gültigen Namen sind: Lotto 6aus49 und Eurojackpot.");  
                break;
        
        }


        //Set<Integer> numbers = new TreeSet<>();
        //Random random = new Random();

        //System.out.println("Ziehung der Lottozahlen - 6 aus 49\n");
        //while(numbers.size() < 6) {
        //    int n = random.nextInt(10);
        //    if(n > 0) {
        //    	numbers.add(n);
        //    }
        //}
        //System.out.println(Arrays.toString(numbers.toArray()));
    }
}
