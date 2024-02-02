import HW8.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
//        public boolean doesThreePointsLieOnTheSameLine(Point firstAnotherPoint, Point secondAnotherPoint){ // поверне true, якшо три точки належать одній прямій
//            return this.getX()*firstAnotherPoint.getY()+this.getY()*secondAnotherPoint.getX()+firstAnotherPoint.getX()*secondAnotherPoint.getY()-firstAnotherPoint.getY()*secondAnotherPoint.getX()-this.getY()*firstAnotherPoint.getX()-secondAnotherPoint.getY()*this.getX() == 0;
//        }
    }
}

interface demoInterface {
    void demoVoid();
}
abstract class demoClass implements demoInterface {
//    @Override
//    public void demoVoid() {
//        System.out.println("Demo void text");
//    }
}
class WordCombine {
    public boolean canCombine(String sourceWord, String targetWord) {
        sourceWord = sourceWord.toLowerCase();
        targetWord = targetWord.toLowerCase();
        String lettersFromSource = sourceWord.substring(0, 1);
        String lettersFromTarget = targetWord.substring(0, 1);
        for (int i = 1; i < sourceWord.length(); i++) {
            boolean isLetterEquals = false;
            for (int j = 0; j < lettersFromSource.length(); j++) {
                if (sourceWord.charAt(i) == lettersFromSource.charAt(j)) {
                    isLetterEquals = true;
                }
            }
            if (!isLetterEquals) {
                lettersFromSource += sourceWord.substring(i, i+1);
            }
        }
        for (int i = 1; i < targetWord.length(); i++) {
            boolean isLetterEquals = false;
            for (int j = 0; j < lettersFromTarget.length(); j++) {
                if (targetWord.charAt(i) == lettersFromTarget.charAt(j)) {
                    isLetterEquals = true;
                }
            }
            if (!isLetterEquals) {
                lettersFromTarget += targetWord.substring(i, i+1);
            }
        }
        char[] targetLettersArr = new char[lettersFromTarget.length()];
        for (int i = 0; i < targetLettersArr.length; i++) {
            targetLettersArr[i] = lettersFromTarget.charAt(i);
        }

        char[] sourceLettersArr = new char[lettersFromSource.length()];
        for (int i = 0; i < sourceLettersArr.length; i++) {
            sourceLettersArr[i] = lettersFromSource.charAt(i);
        }
        Arrays.sort(sourceLettersArr);
        Arrays.sort(targetLettersArr);
        boolean result = false;
        for (int i = 0; i < targetLettersArr.length; i++) {
            boolean containsLetter = false;
            for (int j = 0; j < sourceLettersArr.length; j++) {
                if (targetLettersArr[i] == sourceLettersArr[j]) {
                    containsLetter = true;
                }
            }
            if (!containsLetter) {
                return false;
            }
        }
        return true;
    }
}

class AvgWordLength {
    public double count(String phrase) {
        String[] phraseArr = phrase.split(" ");
        int[] wordsLength = new int[phraseArr.length];
        double result = 0.0;
        for(int i = 0; i < phraseArr.length; i++) {
            wordsLength[i] = phraseArr[i].length();
        }
        for(int i = 0; i < wordsLength.length; i++) {
            result += (double) wordsLength[i];
            if (i == wordsLength.length-1) {
                result = result / ((double)(i+1));
            }
        }
        return result;
    }
}

class MathDetector {
    public boolean isMath(String text) {
        Pattern p1 = Pattern.compile("=");
        Pattern p2 = Pattern.compile("(\\+|-|\\*|/)");
        Pattern p3 = Pattern.compile("\\d");
        Matcher m1 = p1.matcher(text);
        Matcher m2 = p2.matcher(text);
        Matcher m3 = p3.matcher(text);
        boolean containsTwoDigits = false;
        if (m3.find()) {
            String deleteFirstDigit = m3.group();
            if (m3.find()){
                containsTwoDigits = true;
            }
        }
        return m1.find() && m2.find() && containsTwoDigits;
    }
}

class WordDeleter {
    public String remove(String phrase, String[] words) {
        String result = "";
        String[] wordsToCompare = phrase.split(" ");
        for (int i = 0; i < wordsToCompare.length; i++) {
            boolean isBannedWord = false;
            for (int j = 0; j < words.length; j++) {
                if (wordsToCompare[i].equals(words[j])) {
                    isBannedWord = true;
                }
            }
            if (!isBannedWord) {
                result += wordsToCompare[i] + " ";
            }
        }
        Pattern p = Pattern.compile("\\s$");
        Matcher m = p.matcher(result);
        if (m.find()) {
            result = result.substring(0, result.length()-1);
        }
        return result;
    }
}

class UniqueCharCounter {
    public int count(String phrase) {
        int result = 0;
        String clearedPhrase = "";
        Pattern p = Pattern.compile("[a-zA-Z0-9]");
        Matcher m = p.matcher(phrase);
        Pattern p2 = Pattern.compile(" ");
        Matcher m2 = p2.matcher(phrase);
        if(m2.find()) {
            result++;
        }
        while (m.find()) {
            String temp = m.group();
            clearedPhrase += temp;
        }
        String uniquePhrase = "";
        uniquePhrase += clearedPhrase.charAt(0);
        for (int i = 1; i < clearedPhrase.length(); i++) {
            boolean b = false;
            for (int j = 0; j < uniquePhrase.length(); j++) {
                if (clearedPhrase.charAt(i) == uniquePhrase.charAt(j)) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                uniquePhrase += clearedPhrase.charAt(i);
                b=true;
            }
        }
        result += uniquePhrase.length();
        return result;
    }
}

class PalindromeCounter {
    public int count(String phrase) {
        phrase = phrase.toLowerCase();
        String[] phraseArr = new String[phrase.split(" ").length];
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(phrase);
        int tempCounter = 0;
        while (m.find()) {
            String temp = m.group();
            phraseArr[tempCounter] = temp;
            tempCounter++;
        }
        int result = 0;
        for (int i = 0; i < phraseArr.length; i++) {
            boolean b = true;
            for (int j = 0; j < phraseArr[i].length(); j++) {
                if (phraseArr[i].charAt(j) == phraseArr[i].charAt(phraseArr[i].length()-(j+1))) {
                    continue;
                }
                b = false;
            }
            if (b) result++;
        }
        return result;
    }
}