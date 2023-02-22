package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static hexlet.code.Differ.generate;

public class AppTest {
    @Test
    public void differYmlTestOKStylish() throws Exception {
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  + numbers2: [22, 33, 44, 55]
                  - numbers2": [2, 3, 4, 5]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.yml", absolutePath
                + "/correctFile2.yml", "stylish");
        assertEquals(expected, actual);

    }

    @Test
    public void differJSONTestOKStylish() throws Exception {
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.json", absolutePath
                + "/correctFile2.json", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONFirstFileIsEmptyStylish() throws Exception {
        String expected = """
                {
                  + chars1: [a, b, c]
                  + chars2: false
                  + checked: true
                  + default: [value1, value2]
                  + id: null
                  + key2: value2
                  + numbers1: [1, 2, 3, 4]
                  + numbers2: [22, 33, 44, 55]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  + setting1: Another value
                  + setting2: 300
                  + setting3: none
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.json", absolutePath + "/correctFile2.json", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONSecondFileIsEmptyStylish() throws Exception {
        String expected = """
                {
                  - chars1: [a, b, c]
                  - chars2: [d, e, f]
                  - checked: false
                  - default: null
                  - id: 45
                  - key1: value1
                  - numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  - numbers3: [3, 4, 5]
                  - setting1: Some value
                  - setting2: 200
                  - setting3: true
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/correctFile1.json", absolutePath + "/emptyFile1.json", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONBothFilesIsEmptyStylish() throws Exception {
        String expected = """
                {
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.json", absolutePath + "/emptyFile2.json", "stylish");
        assertEquals(expected, actual);

    }

    @Test
    public void differYmlFirstFileIsEmptyStylish() throws Exception {
        String expected = """
                    {
                      + chars1: [a, b, c]
                      + chars2: false
                      + checked: true
                      + default: [value1, value2]
                      + id: null
                      + key2: value2
                      + numbers1: [1, 2, 3, 4]
                      + numbers2: [22, 33, 44, 55]
                      + numbers4: [4, 5, 6]
                      + obj1: {nestedKey=value, isNested=true}
                      + setting1: Another value
                      + setting2: 300
                      + setting3: none
                    }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.yml", absolutePath + "/correctFile2.yml", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differYmlSecondFileIsEmptyStylish() throws Exception {
        String expected = """
                {
                  - chars1: [a, b, c]
                  - chars2: [d, e, f]
                  - checked: false
                  - default: null
                  - id: 45
                  - key1: value1
                  - numbers1: [1, 2, 3, 4]
                  - numbers2": [2, 3, 4, 5]
                  - numbers3: [3, 4, 5]
                  - setting1: Some value
                  - setting2: 200
                  - setting3: true
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/correctFile1.yml", absolutePath + "/emptyFile1.yml", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differYmlBothFilesIsEmptyStylish() throws Exception {
        String expected = """
                {
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.yml", absolutePath + "/emptyFile2.yml", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONTestOkPlain() throws Exception {
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.json", absolutePath
                + "/correctFile2.json", "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void differJSONTestOkJSON() throws Exception {
        String expected = "[{\"status\":\"UNCHANGED\",\"key\":\"chars1\""
                + ",\"data\":[\"a\",\"b\",\"c\"],\"changedData\":null}"
                + ",{\"status\":\"CHANGED\",\"key\":\"chars2\",\"data\":[\"d\",\"e\",\"f\"],\"changedData\":false}"
                + ",{\"status\":\"CHANGED\",\"key\":\"checked\",\"data\":false,\"changedData\":true}"
                + ",{\"status\":\"CHANGED\",\"key\":\"default\""
                + ",\"data\":\"null\",\"changedData\":[\"value1\",\"value2\"]}"
                + ",{\"status\":\"CHANGED\",\"key\":\"id\",\"data\":45,\"changedData\":\"null\"}"
                + ",{\"status\":\"DELETED\",\"key\":\"key1\",\"data\":\"value1\",\"changedData\":null}"
                + ",{\"status\":\"ADDED\",\"key\":\"key2\",\"data\":\"value2\",\"changedData\":null}"
                + ",{\"status\":\"UNCHANGED\",\"key\":\"numbers1\",\"data\":[1,2,3,4],\"changedData\":null}"
                + ",{\"status\":\"CHANGED\",\"key\":\"numbers2\",\"data\":[2,3,4,5],\"changedData\":[22,33,44,55]}"
                + ",{\"status\":\"DELETED\",\"key\":\"numbers3\",\"data\":[3,4,5],\"changedData\":null}"
                + ",{\"status\":\"ADDED\",\"key\":\"numbers4\",\"data\":[4,5,6],\"changedData\":null}"
                + ",{\"status\":\"ADDED\",\"key\":\"obj1\""
                + ",\"data\":{\"nestedKey\":\"value\",\"isNested\":true},\"changedData\":null}"
                + ",{\"status\":\"CHANGED\",\"key\":\"setting1\""
                + ",\"data\":\"Some value\",\"changedData\":\"Another value\"}"
                + ",{\"status\":\"CHANGED\",\"key\":\"setting2\",\"data\":200,\"changedData\":300}"
                + ",{\"status\":\"CHANGED\",\"key\":\"setting3\",\"data\":true,\"changedData\":\"none\"}]";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.json", absolutePath
                + "/correctFile2.json", "json");
        assertEquals(expected, actual);

    }
    @Test
    public void differYmlTestOkYml() throws Exception {
        String expected = """
                - status: "ADDED"
                  key: "setting1"
                  data: "Another value"
                  changedData: null
                - status: "ADDED"
                  key: "setting2"
                  data: 300
                  changedData: null
                """;
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/emptyFile1.yml", absolutePath
                + "/correctFile3.yml", "yml");
        assertEquals(expected, actual);

    }
    @Test
    public void differFormatNullStylish() throws Exception {
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.json", absolutePath
                + "/correctFile2.json");
        assertEquals(expected, actual);

    }
}
