package hexlet.code;

//import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

//import static hexlet.code.formatters.Json.getJson;
import static hexlet.code.formatters.Plain.getPlain;
import static hexlet.code.formatters.Stylish.getStylish;

public class Formatter {
    public static String getView(List<Node> nodes,
                                 String format) {

        if (format.equals("stylish")) {
            return getStylish(nodes);
        } else if (format.equals("plain")) {
            return getPlain(nodes);
//        } else if (format.equals("json")) {
//            try {
//                return getJson(nodes);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
        }
        return format + " format not founded";
    }
}
