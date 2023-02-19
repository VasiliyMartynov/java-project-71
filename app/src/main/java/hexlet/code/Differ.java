package hexlet.code;

import java.util.TreeSet;
import java.util.Map;


import static hexlet.code.Formatter.getView;
import static hexlet.code.Parser.parse;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var file1 = parse(filePath1);
        var file2 = parse(filePath2);
        TreeSet<String> keys = getKeys(file1, file2);
        return getView(file1, file2, keys, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        var file1 = parse(filePath1);
        var file2 = parse(filePath2);
        TreeSet<String> keys = getKeys(file1, file2);
        return getView(file1, file2, keys, "stylish");
    }

    public static TreeSet<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> keysOfMaps = new TreeSet<>();
        keysOfMaps.addAll(data1.keySet());
        keysOfMaps.addAll(data2.keySet());
        return keysOfMaps;
    }
}
