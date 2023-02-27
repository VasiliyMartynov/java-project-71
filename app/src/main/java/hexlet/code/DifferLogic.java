package hexlet.code;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import static hexlet.code.Parser.nodeToMap;

public class DifferLogic {

    public static List<Node> generateDiff(ObjectNode node1, ObjectNode node2) {
        List<Node> nodes = new ArrayList<>();
        var map1 = nodeToMap(node1);
        var map2 = nodeToMap(node2);
        var keys = getKeys(map1, map2);

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


}
