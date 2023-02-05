package hexlet.code;

import java.util.TreeSet;
import java.util.Map;

import static hexlet.code.FilesOperations.readFile;
import static hexlet.code.Views.showDefaultView;

public class Differ {
    public static void generate(String filePath1, String filePath2, String format) throws Exception {
        System.out.println(generateDiffReport(filePath1, filePath2, format));
    }

    static String generateDiffReport(String filePath1, String filePath2, String format) throws Exception {
        var file1 = readFile(filePath1);
        var file2 = readFile(filePath2);
        TreeSet<String> keys = getKeys(file1, file2);
        if (format == null) {
            return showDefaultView(file1, file2, keys);
        }
        return "";
    }

    public static TreeSet<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> keysOfMaps = new TreeSet<>();
        keysOfMaps.addAll(data1.keySet());
        keysOfMaps.addAll(data2.keySet());
        return keysOfMaps;
    }
}
