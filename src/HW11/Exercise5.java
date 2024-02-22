package HW11;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5 {
    public <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstlist = first.collect(Collectors.toList());
        List<T> secondlist = second.collect(Collectors.toList());
        Stream.Builder<T> builder = Stream.builder();
        for (int i = 0; i < Math.min(firstlist.size(), secondlist.size()); i++) {
            builder.accept(firstlist.get(i));
            builder.accept(secondlist.get(i));
        }
        return builder.build();
    }
}
