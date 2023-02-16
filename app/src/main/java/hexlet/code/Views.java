package hexlet.code;

import java.util.Map;
import java.util.TreeSet;

public class Views {
    public static String showView(Map<String, Object> map1,
                                  Map<String, Object> map2,
                                  TreeSet<String> uniqueKeys,
                                  String format) {

        StringBuilder result = new StringBuilder();
        if (format.equals("stylish")) {
            result.append("{\n");
            for (String key : uniqueKeys) {

                //value  added
                if (map2.containsKey(key) && !map1.containsKey(key)) {
                    result
                            .append("  + ")
                            .append(key)
                            .append(": ")
                            .append(map2.get(key).toString())
                            .append("\n");
                    //value was deleted
                } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                    result
                            .append("  - ")
                            .append(key)
                            .append(": ")
                            .append(map1.get(key).toString())
                            .append("\n");
                    //value was changed
                } else if (map1.containsKey(key) && map2.containsKey(key)
                        && !map1.get(key).equals(map2.get(key))) {
                    result
                            .append("  - ")
                            .append(key)
                            .append(": ")
                            .append(map1.get(key).toString())
                            .append("\n");
                    result
                            .append("  + ")
                            .append(key)
                            .append(": ")
                            .append(map2.get(key).toString())
                            .append("\n");
                    //value was unchanged
                } else if (map1.containsKey(key) && map2.containsKey(key)
                        && map1.get(key).equals(map2.get(key))) {
                    result
                            .append("  ")
                            .append(key)
                            .append(": ")
                            .append(map1.get(key).toString())
                            .append("\n");
                }
            }

            result.append("}");
            return result.toString();
        }
        return format + " format not founded";
    }
}
