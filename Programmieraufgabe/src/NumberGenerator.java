import java.util.List;

interface NumberGenerator {
    public List<Integer> generateNumbers(List<Integer> UnluckyNumbers);
    public List<Integer> readNumbers();
    public boolean checkNumbers(List<Integer> UnluckyNumbers);
}