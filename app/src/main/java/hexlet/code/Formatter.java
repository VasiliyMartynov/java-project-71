package hexlet.code;

import java.util.Map;
import java.util.TreeSet;

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
        }
        return format + " format not founded";
    }
}
