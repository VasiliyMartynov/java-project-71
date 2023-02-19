package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

import static hexlet.code.Node.NodeStatus.changed;
import static hexlet.code.Node.NodeStatus.added;
import static hexlet.code.Node.NodeStatus.deleted;
import static hexlet.code.Node.NodeStatus.unchanged;


public class Stylish {

    public static String getStylish(List<Node> nodes) {
        StringBuilder view = new StringBuilder();
        view.append("{\n");
        for (Node e : nodes) {
            Node.NodeStatus status = e.getStatus();
            String key = e.getData().getKey();
            Object data = e.getData().getValue();
            Object changedValue = e.getChangedValue();
            //value  added
            if (status.equals(added)) {
                view
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(data)
                        .append("\n");
                //value was deleted
            } else if (status.equals(deleted)) {
                view
                        .append("  - ")
                        .append(key)
                        .append(": ")
                        .append(data)
                        .append("\n");
                //value was changed
            } else if (status.equals(changed)) {
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
                        .append(changedValue)
                        .append("\n");
                //value was unchanged
            } else if (status.equals(unchanged)) {
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
