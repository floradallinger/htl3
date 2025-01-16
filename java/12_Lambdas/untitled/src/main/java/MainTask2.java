import java.util.Arrays;
import java.util.List;


public class MainTask2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers);

        update(numbers, i -> i+1);
        System.out.println(numbers);
        update(numbers, i -> i*2);
        System.out.println(numbers);
        update(numbers, i -> i-2);
        System.out.println(numbers);
        update(numbers, i -> i*i);
        System.out.println(numbers);
        Integer sum = 0;
        for (Integer num: numbers){
            sum += num;
        }
        Integer avg = sum/numbers.size();
        System.out.println(avg);
        update(numbers, i -> i - avg);
        System.out.println(numbers);


    }

    public static void update(List<Integer> numbers, MyFunction function) {
        for (int i = 0; i < numbers.size(); i++) {
            int oldValue = numbers.get(i);
            int newValue = function.apply(oldValue);
            numbers.set(i, newValue);
        }
    }

}

interface MyFunction {
    Integer apply(Integer i);
}


