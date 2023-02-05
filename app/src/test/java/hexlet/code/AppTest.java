package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static hexlet.code.Differ.generateDiffReport;

public class AppTest {

    @Test
    public void differTest() throws Exception {
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
        String actual = generateDiffReport(absolutePath + "/file1.json", absolutePath + "/file2.json", "");
        assertEquals(expected, actual);

    }
}
