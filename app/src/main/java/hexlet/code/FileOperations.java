package hexlet.code;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static hexlet.code.Parser.parse;

public class FileOperations {

    public static ObjectNode getData(String filepath) throws Exception {
        String fileExtension = getFileExtension(filepath);
        String fileContent = readFile(filepath);
        return parse(fileContent, fileExtension);
    }

    private static String readFile(String filepath) throws Exception {
        Path path = getPath(filepath);
        return Files.readString(path);
    }

    private static Path getPath(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return path;
    }

    private static String getFileExtension(String filePath) {
        int i = filePath.lastIndexOf('.');
        String extension = null;
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }
}
