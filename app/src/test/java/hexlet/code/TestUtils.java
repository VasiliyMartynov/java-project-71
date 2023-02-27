package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.Files.readString;

public class TestUtils {
    public static String getAbsolutePath(String fileName) {
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        return absolutePath + "/" + fileName;
    }

    public static String getExpectedFile(String fileName) throws IOException {
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected", fileName);
        return readString(expectedFilePath);
    }
}
