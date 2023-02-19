package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;
import java.util.List;

public class Plain {

    public static String getPlain(Map<String, Object> map1,
                             Map<String, Object> map2,
                             TreeSet<String> uniqueKeys) {
        StringBuilder view = new StringBuilder();
        map1.entrySet()
                .forEach(e -> {
                    if (e.getValue() instanceof List<?> || e.getValue() instanceof Map<?, ?>) {
                        e.setValue("[complex value]");
                    }
                    if (e.getValue() == null) {
                        e.setValue("null");
                    }
                    if (e.getValue() instanceof String
                            && !e.getValue().equals("null")
                            && !e.getValue().equals("[complex value]")) {
                        e.setValue("'" + e.getValue() + "'");
                    }
                });
        map2.entrySet()
                .forEach(e -> {
                    if (e.getValue() instanceof List<?> || e.getValue() instanceof Map<?, ?>) {
                        e.setValue("[complex value]");
                    }
                    if (e.getValue() == null) {
                        e.setValue("null");
                    }
                    if (e.getValue() instanceof String
                            && !e.getValue().equals("null")
                            && !e.getValue().equals("[complex value]")) {
                        e.setValue("'" + e.getValue() + "'");
                    }
                });
        view.append("{\n");
        for (String key : uniqueKeys) {

            //if value  added
            if (map2.containsKey(key) && !map1.containsKey(key)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(map2.get(key).toString())
                        .append("\n");
                //if value was deleted
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was removed")
                        .append("\n");
                //if value was changed
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && !map1.get(key).equals(map2.get(key))) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(map1.get(key).toString())
                        .append(" to ")
                        .append(map2.get(key).toString())
                        .append("\n");
                //if value was unchanged
                //do nothing
            }
        }

        view.append("}");
        return view.toString();
    }
}
