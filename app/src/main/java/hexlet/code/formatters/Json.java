package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;

import java.util.List;
//import java.util.Map;
//import java.util.TreeSet;

public class Json {

    public static String getJson(List<Node> nodes) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        StringBuilder view = new StringBuilder();
//        view.append("{");
//        for (String key : uniqueKeys) {
//
//            //value  added
//            if (map2.containsKey(key) && !map1.containsKey(key)) {
//                view
//                        .append("added:{")
//                        .append(key)
//                        .append(",")
//                        .append(map2.get(key).toString())
//                        .append("},");
//                //value was deleted
//            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
//                view
//                        .append("deleted:{")
//                        .append(key)
//                        .append(",")
//                        .append(map1.get(key).toString())
//                        .append("},");
//                //value was changed
//            } else if (map1.containsKey(key) && map2.containsKey(key)
//                    && !map1.get(key).equals(map2.get(key))) {
//                view
//                        .append("changed:{")
//                        .append(key)
//                        .append(",")
//                        .append(map2.get(key).toString())
//                        .append("},");
//                //value was unchanged
//            } else if (map1.containsKey(key) && map2.containsKey(key)
//                    && map1.get(key).equals(map2.get(key))) {
//                view
//                        .append("unchanged:{")
//                        .append(key)
//                        .append(",")
//                        .append(map1.get(key).toString())
//                        .append("},");
//            }
//        }
//
//        view.append("}");
//        String jsonString = view.toString().replace("},}", "}}");
//        return objectMapper.writeValueAsString(jsonString);
        return "";
    }
}
