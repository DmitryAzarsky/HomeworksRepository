package HW10;
import java.util.*;
import java.util.Map.Entry;

public class SortMap{
    public LinkedHashMap<String, Integer> sort(Map<String, Integer> hashMap){
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> valuesList = new ArrayList<>();
        for (int value : hashMap.values()) {
            valuesList.add(value);
        }
        Collections.sort(valuesList);
        for (int value : valuesList) {
            for (Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue().equals(value)) {
                    sortedMap.put(entry.getKey(), value);
                }
            }
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        String[] tempArr = new String[sortedMap.size()];
        int counter = tempArr.length-1;
        for (String key : sortedMap.keySet()) {
            tempArr[counter] = key;
            counter--;
        }
        for (int i = 0; i < tempArr.length; i++) {
            reverseSortedMap.put(tempArr[i], sortedMap.get(tempArr[i]));
        }
        return reverseSortedMap;
    }
}
