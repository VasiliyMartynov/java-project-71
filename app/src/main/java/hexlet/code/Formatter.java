package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import static hexlet.code.formatters.Json.getJson;
import static hexlet.code.formatters.Plain.getPlain;
import static hexlet.code.formatters.Stylish.getStylish;
import static hexlet.code.formatters.Yaml.getYaml;

public class Formatter {
    public static String getView(List<Node> nodes,
                                 String format) throws JsonProcessingException {

        switch (format) {
            case "stylish" -> {
                return getStylish(nodes);
            }
            case "plain" -> {
                return getPlain(nodes);
            }
            case "json"  -> {
                return getJson(nodes);
            }
            case "yml"  -> {
                return getYaml(nodes);
            }
            default -> {
            }
        }
        return format + " format not founded";
    }
}
