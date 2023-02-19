package hexlet.code;

import java.util.Map;

public class Node {

    public enum NodeStatus {
        added, deleted, changed, unchanged
    }
    private NodeStatus status;
    private Map.Entry<String, Object> data;

    private Object changedValue;

    Node(NodeStatus status, Map.Entry<String, Object> data, Object changedValue) {
        this.status = status;
        this.data = data;
        this.changedValue = changedValue;
    }
    Node(NodeStatus status, Map.Entry<String, Object> data) {
        this.status = status;
        this.data = data;
    }
    public Map.Entry<String, Object> getData() {
        return this.data;
    }

    public Object getChangedValue() {
        return this.changedValue;
    }

    public NodeStatus getStatus() {
        return this.status;
    }

}
