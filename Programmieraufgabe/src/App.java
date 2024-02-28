import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {

        Set<Integer> numbers = new TreeSet<>();
        Random random = new Random();

        System.out.println("Ziehung der Lottozahlen - 6 aus 49\n");
        while(numbers.size() < 6) {
            int n = random.nextInt(10);
            if(n > 0) {
            	numbers.add(n);
            }
        }
        System.out.println(Arrays.toString(numbers.toArray()));
    }
}
