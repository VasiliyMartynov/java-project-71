package hexlet.code;

public final class Node {

    public enum NodeStatus {
        ADDED, DELETED, CHANGED, UNCHANGED
    }

    private final NodeStatus status;
    private final String key;
    private final Object data;
    private Object changedData;


    Node(NodeStatus nodeStatus, String nodeKey, Object nodeData, Object nodeChangedData) {
        this.key = nodeKey;
        this.status = nodeStatus;
        this.data = nodeData;
        this.changedData = nodeChangedData;
    }

    Node(NodeStatus nodeStatus, String nodeKey, Object nodeData) {
        this.key = nodeKey;
        this.status = nodeStatus;
        this.data = nodeData;
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


