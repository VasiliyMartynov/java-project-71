package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;
import java.util.TreeSet;

import static hexlet.code.formatters.Json.getJson;
import static hexlet.code.formatters.Plain.getPlain;
import static hexlet.code.formatters.Stylish.getStylish;

public class Formatter {
    public static String getView(Map<String, Object> map1,
                                 Map<String, Object> map2,
                                 TreeSet<String> uniqueKeys,
                                 String format) {

        if (format.equals("stylish")) {
            return getStylish(map1, map2, uniqueKeys);
        } else if (format.equals("plain")) {
            return getPlain(map1, map2, uniqueKeys);
        } else if (format.equals("json")) {
            try {
                return getJson(map1, map2, uniqueKeys);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return format + " format not founded";
    }

    public static String getView(Map<String, Object> map1,
                                 Map<String, Object> map2,
                                 TreeSet<String> uniqueKeys) {
        String format = App.getFormat();
        if (format.equals("stylish")) {
            return getStylish(map1, map2, uniqueKeys);
        } else if (format.equals("plain")) {
            return getPlain(map1, map2, uniqueKeys);
        } else if (format.equals("json")) {
            try {
                return getJson(map1, map2, uniqueKeys);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return format + " format not founded";
    }
}
