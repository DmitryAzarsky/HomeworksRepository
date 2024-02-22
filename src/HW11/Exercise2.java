package HW11;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise2 {
    public List<String> toUpperCaseAndSort(List<String> names) {
        return names.stream().map(element -> element.toUpperCase()).sorted((a, b) -> -1 * a.compareTo(b)).collect(Collectors.toList());
    }
}
