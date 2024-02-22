package HW11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestHW11 {
    public static void main(String[] args) {
        Stream<Integer> first = Arrays.asList(1, 2, 3, 4).stream();
        Stream<Integer> second = Arrays.asList(6, 7, 8).stream();
        Stream<Integer> newStream = new Exercise5().zip(first, second);
        newStream.forEach(System.out::println);
    }
}
