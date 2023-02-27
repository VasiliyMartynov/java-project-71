package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    private static ObjectMapper mapper = null;
    public static ObjectNode parse(String fileData, String fileExtension) throws Exception {
        mapper = getFileMapper(fileExtension);
        return (ObjectNode) mapper.readTree(fileData);
    }
    static ObjectMapper getFileMapper(String fileExtension) {
        if (fileExtension.equals("yml")) {
            return new YAMLMapper();
        }
        return new ObjectMapper();
    }
    public static Map<String, Object> nodeToMap(ObjectNode node) {
        Map<String, Object> result = mapper.convertValue(node, new TypeReference<>() { });
        result.entrySet().forEach(e -> {
            if (e.getValue() == null) {
                e.setValue("null");
            }
        });
        return result;
    }

}
