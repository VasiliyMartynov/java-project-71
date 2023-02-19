package hexlet.code;

import java.util.List;
import java.util.TreeSet;

import static hexlet.code.Formatter.getView;
import static hexlet.code.Parser.getKeys;
import static hexlet.code.Parser.parseFile;
import static hexlet.code.Parser.createListOfNodes;



public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var file1 = parseFile(filePath1);
        var file2 = parseFile(filePath2);
        TreeSet<String> keys = getKeys(file1, file2);
        List<Node> nodes =  createListOfNodes(file1, file2, keys);
        return getView(nodes, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        var file1 = parseFile(filePath1);
        var file2 = parseFile(filePath2);
        TreeSet<String> keys = getKeys(file1, file2);
        List<Node> nodes =  createListOfNodes(file1, file2, keys);
        return getView(nodes, "stylish");
    }


}
