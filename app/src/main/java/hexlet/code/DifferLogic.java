package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DifferLogic {

    public static List<Node> generateDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Node> nodes = new ArrayList<>();
        var keys = getKeys(fixNulls(map1), fixNulls(map2));
        for (String key : keys) {
                //value  added
            if (map2.containsKey(key) && !map1.containsKey(key)) {
                nodes.add(new Node(Node.NodeStatus.ADDED, key, map2.get(key)));
                //value was deleted
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                nodes.add(new Node(Node.NodeStatus.DELETED, key, map1.get(key)));
                //value was changed
            } else if (map1.containsKey(key)
                    && map2.containsKey(key)
                    && !map1.get(key).equals(map2.get(key))) {
                nodes.add(new Node(Node.NodeStatus.CHANGED,
                        key, map1.get(key), map2.get(key)));
                //value was unchanged
            } else if (map1.containsKey(key)
                    && map2.containsKey(key)
                    && map1.get(key).equals(map2.get(key))) {
                nodes.add(new Node(Node.NodeStatus.UNCHANGED, key, map1.get(key)));
            }
        }
        return nodes;
    }

    private static TreeSet<String> getKeys(Map<String, Object> map1, Map<String, Object>  map2) {

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        return keys;
    }

    private static Map<String, Object> fixNulls(Map<String, Object> map) {
        map.entrySet().forEach(e -> {
            if (e.getValue() == null) {
                e.setValue("null");
            }
        });
        return map;
    }
}
