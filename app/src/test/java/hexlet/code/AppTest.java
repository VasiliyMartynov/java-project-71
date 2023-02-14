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
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true

                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.json", absolutePath
                + "/correctFile2.json", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONFirstFileIsEmpty() throws Exception {
        String expected = """
                       {
                       + host: hexlet.io
                       + timeout: 20
                       + verbose: true

                       }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.json", absolutePath + "/correctFile2.json", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONSecondFileIsEmpty() throws Exception {
        String expected = """
                {
                - follow: false
                - host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50

                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/correctFile1.json", absolutePath + "/emptyFile1.json", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differJSONBothFilesIsEmpty() throws Exception {
        String expected = """
                {

                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.json", absolutePath + "/emptyFile2.json", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLTestOK() throws Exception {
        String expected = """
                {
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true

                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath
                + "/correctFile1.yaml", absolutePath
                + "/correctFile2.yaml", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLFirstFileIsEmpty() throws Exception {
        String expected = """
                       {
                       + host: hexlet.io
                       + timeout: 20
                       + verbose: true

                       }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.yaml", absolutePath + "/correctFile2.yaml", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLSecondFileIsEmpty() throws Exception {
        String expected = """
                {
                - follow: false
                - host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50

                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/correctFile1.yaml", absolutePath + "/emptyFile1.yaml", "");
        assertEquals(expected, actual);

    }
    @Test
    public void differYAMLBothFilesIsEmpty() throws Exception {
        String expected = """
                {

                }""";
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String actual = generate(absolutePath + "/emptyFile1.yaml", absolutePath + "/emptyFile2.yaml", "");
        assertEquals(expected, actual);

    }
}
