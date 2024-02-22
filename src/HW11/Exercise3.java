package HW11;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise3 {
    public static void main(String[] args) {
        String[] numbers = {"1, 2, 0", "4, 5"};
        numbers = Arrays.asList(numbers).stream().collect(Collectors.joining(", ")).split(", ");
        String result = Arrays.asList(numbers).stream().sorted((a,b) -> a.compareTo(b)).collect(Collectors.joining(", "));
        System.out.println(result);

    }
}
