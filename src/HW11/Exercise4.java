package HW11;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise4 {
    public static void main(String[] args) {
        long a = 25214903917l;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        System.out.println("m = " + m);
        Stream<Long> longStream = Stream.iterate(1l, next -> (a * next + c)%m);

        List<Long> collect = longStream.distinct().limit(25).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("collect.size() = " + collect.size());

    }
}
