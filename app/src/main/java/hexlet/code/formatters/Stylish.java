package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;

public class Stylish {

    public static String getStylish(Map<String, Object> map1,
                             Map<String, Object> map2,
                             TreeSet<String> uniqueKeys) {
        StringBuilder view = new StringBuilder();
        view.append("{\n");
        for (String key : uniqueKeys) {

            //value  added
            if (map2.containsKey(key) && !map1.containsKey(key)) {
                view
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(map2.get(key).toString())
                        .append("\n");
                //value was deleted
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                view
                        .append("  - ")
                        .append(key)
                        .append(": ")
                        .append(map1.get(key).toString())
                        .append("\n");
                //value was changed
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && !map1.get(key).equals(map2.get(key))) {
                view
                        .append("  - ")
                        .append(key)
                        .append(": ")
                        .append(map1.get(key).toString())
                        .append("\n");
                view
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(map2.get(key).toString())
                        .append("\n");
                //value was unchanged
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && map1.get(key).equals(map2.get(key))) {
                view
                        .append("    ")
                        .append(key)
                        .append(": ")
                        .append(map1.get(key).toString())
                        .append("\n");
            }
        }

        view.append("}");
        return view.toString();
    }
}
