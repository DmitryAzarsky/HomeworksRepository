package HW11;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1 {
    public String getNamesWithOddIndex(List<String> names) {
        Stream<String> namesStream = names
                .stream()
                .mapToInt(names::indexOf)
                .filter(index -> index%2 == 0)
                .mapToObj(index -> (index +1) + ". " + names.get(index));
        return namesStream.toList().stream().collect(Collectors.joining(", "));
    }
}
