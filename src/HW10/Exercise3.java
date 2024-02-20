package HW10;
import java.io.*;
import java.util.*;
public class Exercise3 {
    public void wordsQuantity() {
        Map<String, Integer> wordsQuantity = new HashMap<>();
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
        for (String key: wordsQuantity.keySet()) {
            System.out.println(key + " " + wordsQuantity.get(key));
        }
    }
}
