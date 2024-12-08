package hexlet.code;

import static hexlet.code.FileOperations.getData;
import static hexlet.code.Formatter.getView;
import static hexlet.code.DifferLogic.generateDiff;


public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var file1Data = getData(filePath1);
        var file2Data = getData(filePath2);
        var diff =  generateDiff(file1Data, file2Data);
        return getView(diff, format);
    }

    /**
     * This method call generate with stylish format
     */
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
