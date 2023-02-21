package hexlet.code;

import static hexlet.code.FileOperations.getData;
import static hexlet.code.Formatter.getView;
import static hexlet.code.Parser.generateDiff;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var map1 = getData(filePath1);
        var map2 = getData(filePath2);
        var diff =  generateDiff(map1, map2);

        return getView(diff, format);
        //return "";
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
