package hexlet.code.formatters;

import hexlet.code.Node;
import java.util.List;
import static hexlet.code.Node.NodeStatus.CHANGED;
import static hexlet.code.Node.NodeStatus.ADDED;
import static hexlet.code.Node.NodeStatus.DELETED;
import static hexlet.code.Node.NodeStatus.UNCHANGED;

public class Stylish {

    public static String getStylish(List<Node> nodes) {
        StringBuilder view = new StringBuilder();
        view.append("{\n");
        for (Node e : nodes) {
            Node.NodeStatus status = e.getStatus();
            String key = e.getKey();
            Object data = e.getData();
            //value  added
            if (status.equals(ADDED)) {
                view
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(data)
                        .append("\n");
                //value was deleted
            } else if (status.equals(DELETED)) {
                view
                        .append("  - ")
                        .append(key)
                        .append(": ")
                        .append(data)
                        .append("\n");
                //value was changed
            } else if (status.equals(CHANGED)) {
                view
                        .append("  - ")
                        .append(key)
                        .append(": ")
                        .append(data)
                        .append("\n");
                view
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(e.getChangedData())
                        .append("\n");
                //value was unchanged
            } else if (status.equals(UNCHANGED)) {
                view
                        .append("    ")
                        .append(key)
                        .append(": ")
                        .append(data)
                        .append("\n");
            }
        }

        view.append("}");
        return view.toString();
    }
}
