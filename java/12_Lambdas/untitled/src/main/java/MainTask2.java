import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainTask2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers);

        System.out.println(filterNumbers(numbers, i -> i % 2 == 0)); // gerade Zahlen
        System.out.println(filterNumbers(numbers, i -> i % 2 != 0)); // ungerade Zahlen
        System.out.println(filterNumbers(numbers, i -> i % 4 == 0)); // Vielfache von 4
        System.out.println(filterNumbers(numbers, i -> { // Primzahlen
            if(i == 0 || i == 1){
                return false;
            }
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    return false;
                }
            }
            return true;
        }));



    }

    public static List<Integer> filterNumbers(List<Integer> numbers,  Predicate<Integer> condition) {
        List<Integer> testedNumbers = new ArrayList();
        for (int i = 0; i < numbers.size(); i++) {
            int valueToTest = numbers.get(i);
            if(condition.test(valueToTest)){
                testedNumbers.add(valueToTest);
            }
        }
        return testedNumbers;
    }

}



