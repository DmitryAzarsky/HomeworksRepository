package HW10;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1 {
    public void getPhoneNumbers(String path) {
        String textInFile = "";
        File file = new File(path);
        try (FileInputStream fIs = new FileInputStream(file)) {
            Scanner fileScanner = new Scanner(fIs);
            while (fileScanner.hasNext()) {
                textInFile += fileScanner.nextLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        Pattern phoneNumberPattern = Pattern.compile("(\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4})|([0-9]{3}-[0-9]{3}-[0-9]{4})");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(textInFile);
        while (phoneNumberMatcher.find()) {
            String result = phoneNumberMatcher.group();
            System.out.println(result);
        }
    }
}
