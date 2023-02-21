package hexlet.code;

//import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
//import static hexlet.code.formatters.Json.getJson;
import static hexlet.code.formatters.Plain.getPlain;
import static hexlet.code.formatters.Stylish.getStylish;

public class Formatter {
    public static String getView(List<Node> nodes,
                                 String format) {

        switch (format) {
            case "stylish" -> {
                return getStylish(nodes);
            }
            case "plain" -> {
                return getPlain(nodes);
            }
//            case "json" : {
//                try {
//                    return getJson(nodes);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            default -> {
            }
        }
        return format + " format not founded";
    }
}
