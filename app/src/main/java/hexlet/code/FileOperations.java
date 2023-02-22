package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Parser.parse;


public class FileOperations {

    public static ObjectMapper mapper = null;
    public static ObjectNode getData(String filepath) throws Exception {
        Path path = getPath(filepath);
        String content = Files.readString(path);
        String fileExtension = getFileExtension(filepath);
        System.out.println();
        mapper = getFileMapper(fileExtension);
        return parse(content);
    }

    private static Path getPath(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return path;
    }

    public static String getFileExtension(String filePath) {
        int i = filePath.lastIndexOf('.');
        String extension = null;
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }

    public static ObjectMapper getFileMapper(String fileExtension) {
        if (fileExtension.equals("yml")) {
            return new YAMLMapper();
        }
        return new ObjectMapper();
    }
}
