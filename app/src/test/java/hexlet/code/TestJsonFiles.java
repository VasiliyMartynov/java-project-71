package hexlet.code;

import static hexlet.code.TestUtils.getAbsolutePath;
import static hexlet.code.TestUtils.getExpectedFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;

public class TestJsonFiles {
    @Test
    public void differJsonFormatEmpty() throws Exception {
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String expected = getExpectedFile("JsonFormatStylish.txt");
        String actual = generate(file1, file2);
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonFormatStylish() throws Exception {
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String expected = getExpectedFile("JsonFormatStylish.txt");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonFormatPlain() throws Exception {
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String expected = getExpectedFile("JsonFormatPlain.txt");
        String actual = generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonFormatJson() throws Exception {
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String expected = getExpectedFile("JsonFormatJson.txt");
        String actual = generate(file1, file2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonFormatYml() throws Exception {
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String expected = getExpectedFile("JsonFormatYml.txt");
        String actual = generate(file1, file2, "yml");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonFirstFileIsEmptyFormatStylish() throws Exception {
        String file1 = getAbsolutePath("emptyFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String expected = getExpectedFile("JsonFirstFileIsEmptyFormatStylish.txt");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonSecondFileIsEmptyFormatStylish() throws Exception {
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("emptyFile2.json");
        String expected = getExpectedFile("JsonSecondFileIsEmptyFormatStylish.txt");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonBothFilesIsEmptyFormatStylish() throws Exception {
        String expected = "{"
                + "\n}";
        String file1 = getAbsolutePath("emptyFile1.json");
        String file2 = getAbsolutePath("emptyFile2.json");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }
}
