package hexlet.code.formatters;

import hexlet.code.Node;


import java.util.List;
import java.util.Map;

import static hexlet.code.Node.NodeStatus.added;
import static hexlet.code.Node.NodeStatus.deleted;
import static hexlet.code.Node.NodeStatus.changed;

public class Plain {

    public static String getPlain(List<Node> nodes) {
        StringBuilder view = new StringBuilder();
        view.append("{\n");
        for (Node e : nodes) {
            Node.NodeStatus status = e.getStatus();
            String key = e.getData().getKey();
            Object changedValue = e.getChangedValue();
            Object data = e.getData().getValue();

            //if value  added
            if (status.equals(added)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was added with value: ");
                if (e.getData().getValue() instanceof List<?> || e.getData().getValue() instanceof Map<?, ?>) {
                    view.append("[complex value]");
                } else {
                    if (e.getData().getValue() instanceof String) {
                        view
                                .append("'")
                                .append(data)
                                .append("'");
                    } else {
                        view.append(data);
                    }
                }
                view.append("\n");
                //if value was deleted
            } else if (status.equals(deleted)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was removed")
                        .append("\n");
                //if value was changed
            } else if (status.equals(changed)) {
                view
                        .append("Property '")
                        .append(key)
                        .append("' was updated. From ");

                if (e.getData().getValue() instanceof List<?> || e.getData().getValue() instanceof Map<?, ?>) {
                    view.append("[complex value]");
                } else {
                    if (e.getData().getValue() instanceof String) {
                        view
                                .append("'")
                                .append(data)
                                .append("'");
                    } else {
                        view.append(data);
                    }
                }
                view.append(" to ");

                if (changedValue instanceof List<?> || e.getData().getValue() instanceof Map<?, ?>) {
                    view.append("[complex value]");
                } else {
                    if (e.getData().getValue() instanceof String) {
                        view
                                .append("'")
                                .append(changedValue)
                                .append("'");
                    } else {
                        view.append(changedValue);
                    }
                }
                view.append("\n");
            }
        }
        view.append("}");
        return view.toString();
    }
}
//
//if (e.getData().getValue() instanceof List<?> || e.getData().getValue() instanceof Map<?, ?>) {
//        view.append("[complex value]");
//        } else {
//        view.append(data);
//        }
