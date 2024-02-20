import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {
        String s = "Нуддщ";
        System.out.println(Optional.ofNullable(s).orElse("string"));
//        System.out.println(Optional.of(s).orElseGet(() -> {
//            System.out.println("The string is not exists");
//            return "string";
//        }));
    }
}

