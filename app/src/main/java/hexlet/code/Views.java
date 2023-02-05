package hexlet.code;

import java.util.Map;
import java.util.TreeSet;

public class Views {
    public static String showDefaultView(Map<String, Object> d1, Map<String, Object> d2, TreeSet<String> diff) {
        StringBuilder result = new StringBuilder();
        //List<Map<String, Map<String, Object>>> advancedJSON = new LinkedList<Map<String, Map<String, Object>>>();
        result.append("{\n");
        for (String key : diff) {
            if (d2.containsKey(key) && !d1.containsKey(key)) { //added
                result.append("\t+ ").append(key).append(": ").append(d2.get(key)).append("\n");
            } else if (d1.containsKey(key) && !d2.containsKey(key)) { //deleted
                result.append("\t- ").append(key).append(": ").append(d1.get(key)).append("\n");
            } else if (d1.containsKey(key) && d2.containsKey(key) && !d1.get(key).equals(d2.get(key))) { //changed
                result.append("\t- ").append(key).append(": ").append(d1.get(key)).append("\n");
                result.append("\t+ ").append(key).append(": ").append(d2.get(key)).append("\n");
            } else if (d1.containsKey(key) && d2.containsKey(key) && d1.get(key).equals(d2.get(key))) { // unchanged
                result.append("\t  ").append(key).append(": ").append(d1.get(key)).append("\n");
            }
        }
        result.append("\n}");
        return result.toString();
    }
}
