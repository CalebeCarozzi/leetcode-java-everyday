import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            String sorted = sortWord(word);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

