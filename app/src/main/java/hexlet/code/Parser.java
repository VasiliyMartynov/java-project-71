package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class Parser {
    static Map<String, Object> parseFile(String filePath) throws Exception {
        String fileExtension = getFileExtension(filePath);
        ObjectMapper mapper = getMapper(fileExtension);
        assert mapper != null;
        Map<String, Object> result = mapper.readValue(getFileData(filePath), new TypeReference<>() { });
        result.entrySet().stream()
                .forEach(e -> {
                    if (e.getValue() == null) {
                        e.setValue("null");
                    }
                });
        return result;
    }

    static List<Node> createListOfNodes(Map<String, Object> map1, Map<String, Object> map2, TreeSet<String> keys) {
        List<Node> nodes = new ArrayList<>();
        //value  added
        for (String key : keys) {

                //value  added
            if (map2.containsKey(key) && !map1.containsKey(key)) {
                nodes.add(new Node(Node.NodeStatus.added, Map.entry(key, map2.get(key))));
                //value was deleted
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                nodes.add(new Node(Node.NodeStatus.deleted, Map.entry(key, map1.get(key))));
                //value was changed
            } else if (map1.containsKey(key)
                    && map2.containsKey(key)
                    && !map1.get(key).equals(map2.get(key))) {
                nodes.add(new Node(Node.NodeStatus.changed, Map.entry(key, map1.get(key)), map2.get(key)));
                //nodes.add(new Node(Node.NodeStatus.changedPlus, Map.entry(key, map2.get(key))));
                //value was unchanged
            } else if (map1.containsKey(key)
                    && map2.containsKey(key)
                    && map1.get(key).equals(map2.get(key))) {
                nodes.add(new Node(Node.NodeStatus.unchanged, Map.entry(key, map1.get(key))));
            }
        }
        return nodes;
    }

    public static TreeSet<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> keysOfMaps = new TreeSet<>();
        keysOfMaps.addAll(data1.keySet());
        keysOfMaps.addAll(data2.keySet());
        return keysOfMaps;
    }

    static ObjectMapper getMapper(String s) {
        if (s.equals("json")) {
            return new ObjectMapper();
        } else if (s.equals("yaml")) {
            return new YAMLMapper();
        }
        return null;
    }

    static String getFileData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return Files.readString(path);
    }

    static String getFileExtension(String filePath) {
        int i = filePath.lastIndexOf('.');
        String extension = null;
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }
}


