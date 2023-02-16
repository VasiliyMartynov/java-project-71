package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static hexlet.code.Differ.generate;

public class AppTest {

    @Test
    public void differJSONTestOK() throws Exception {
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
    public void differJSONFirstFileIsEmpty() throws Exception {
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
    public void differJSONSecondFileIsEmpty() throws Exception {
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
    public void differJSONBothFilesIsEmpty() throws Exception {
        String expected = """
                {
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.json", absolutePath + "/emptyFile2.json", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLTestOK() throws Exception {
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
                + "/correctFile1.yaml", absolutePath
                + "/correctFile2.yaml", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLFirstFileIsEmpty() throws Exception {
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
        String actual = generate(absolutePath + "/emptyFile1.yaml", absolutePath + "/correctFile2.yaml", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLSecondFileIsEmpty() throws Exception {
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
        String actual = generate(absolutePath + "/correctFile1.yaml", absolutePath + "/emptyFile1.yaml", "stylish");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLBothFilesIsEmpty() throws Exception {
        String expected = """
                {
                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.yaml", absolutePath + "/emptyFile2.yaml", "stylish");
        assertEquals(expected, actual);

    }
}
