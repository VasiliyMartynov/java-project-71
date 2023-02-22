package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Node;
import java.util.List;
import static hexlet.code.FileOperations.mapper;

public class Json {

    public static String getJson(List<Node> nodes) throws JsonProcessingException {
        return mapper.writeValueAsString(nodes);
    }
}
