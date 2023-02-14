package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    static Map<String, Object> parse(String filePath) throws Exception {
        String fileExtention = getFileExtention(filePath);
        ObjectMapper mapper = getMapper(fileExtention);
        assert mapper != null;
        return mapper.readValue(getFileData(filePath), new TypeReference<>() { });
    }

    static ObjectMapper getMapper(String s) {
        if (s.equals("json")) {
            return new ObjectMapper();
        } else if (s.equals("yaml")) {
            return new YAMLMapper();
        }
        return null;
    }

    static String getFileData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return Files.readString(path);
    }

    static String getFileExtention(String filePath) {
        int i = filePath.lastIndexOf('.');
        String extension = null;
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }
}


