package hexlet.code.formatters;

import hexlet.code.Node;
import java.util.List;
import java.util.Map;
import static hexlet.code.Node.NodeStatus.ADDED;
import static hexlet.code.Node.NodeStatus.DELETED;
import static hexlet.code.Node.NodeStatus.CHANGED;

public class Plain {

    public static String getPlain(List<Node> nodes) {
        StringBuilder view = new StringBuilder();
        for (Node e : nodes) {
            Node.NodeStatus status = e.getStatus();
            String key = e.getKey();
            String data = convertObject(e.getData());
            String changedData = convertObject(e.getChangedData());
            if (status.equals(ADDED)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(data)
                        .append("\n");
            } else if (status.equals(DELETED)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was removed")
                        .append("\n");
            } else if (status.equals(CHANGED)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(data)
                        .append(" to ")
                        .append(changedData)
                        .append("\n");
            }
        }
        //view.append("}");
        return view.substring(0, view.toString().length() - 1);
    }

    private static String convertObject(Object o) {
        String s;
        if (o == null) {
            return null;
        } else {
            s = o.toString();
        }
        if (o instanceof List<?> || o instanceof Map<?, ?>) {
            s = "[complex value]";
        }
        if (o instanceof String && !o.toString().equals("null")) {
            s = "'" + o + "'";
        }
        return s;
    }
}
