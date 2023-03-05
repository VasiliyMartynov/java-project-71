package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String fileData, String fileExtension) throws Exception {
        ObjectMapper mapper = getFileMapper(fileExtension);
        return mapper.convertValue(mapper.readTree(fileData), new TypeReference<>() { });
    }

    private static ObjectMapper getFileMapper(String fileExtension) {
        if (fileExtension.equals("yml")) {
            return new YAMLMapper();
        }
        return new ObjectMapper();
    }
}
