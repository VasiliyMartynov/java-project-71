package hexlet.code;

public class Node {

    public enum NodeStatus {
        ADDED, DELETED, CHANGED, UNCHANGED
    }

    private final NodeStatus status;
    private final String key;
    private final Object data;
    private Object changedData;

    Node(NodeStatus status, String key, Object data, Object changedData) {
        this.key = key;
        this.status = status;
        this.data = data;
        this.changedData = changedData;
    }

    Node(NodeStatus status, String key, Object data) {
        this.status = status;
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return this.key;
    }

    public NodeStatus getStatus() {
        return this.status;
    }

    public Object getData() {
        return this.data;
    }

    public Object getChangedData() {
        return this.changedData;
    }
}


