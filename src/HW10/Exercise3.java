package HW10;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Exercise3 {
    public void wordsQuantity() {
        HashMap<String, Integer> wordsQuantity = new HashMap<>();
        String wholePhrase = "";
        File wordsFile = new File("./files/words.txt");
        try (FileInputStream fIs = new FileInputStream(wordsFile)){
            Scanner scanner = new Scanner(fIs);
            int counter = 0;
            while (scanner.hasNext()) {
                if (counter == 0) {
                    wholePhrase += scanner.nextLine();
                    counter++;
                }
                wholePhrase += " " + scanner.nextLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] wholePhraseArr = wholePhrase.split(" ");
        for (int i = 0; i < wholePhraseArr.length; i++) {
            String currentWord = wholePhraseArr[i];
            if (wordsQuantity.containsKey(currentWord)) {
                wordsQuantity.put(currentWord ,wordsQuantity.get(currentWord) + 1);
            } else {
                wordsQuantity.put(currentWord, 1);
            }
        }
        Pattern pattern = Pattern.compile("[a-z0-9]+=[1-9]+");
        Matcher matcher = pattern.matcher(new SortMap().sort(wordsQuantity).toString());
        while (matcher.find()) {
            String keyValue = matcher.group();
            System.out.println(keyValue.split("=")[0] + " " + keyValue.split("=")[1]);
        }
    }
}
