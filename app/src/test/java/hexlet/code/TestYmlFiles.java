package hexlet.code;

import static hexlet.code.TestUtils.getAbsolutePath;
import static hexlet.code.TestUtils.getExpectedFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;

public class TestYmlFiles {
    @Test
    public void differYmlFormatEmpty() throws Exception {
        String file1 = getAbsolutePath("correctFile1.yml");
        String file2 = getAbsolutePath("correctFile2.yml");
        String expected = getExpectedFile("YmlFormatStylish.txt");
        String actual = generate(file1, file2);
        assertEquals(expected, actual);
    }

    @Test
    public void differYmlFormatStylish() throws Exception {
        String file1 = getAbsolutePath("correctFile1.yml");
        String file2 = getAbsolutePath("correctFile2.yml");
        String expected = getExpectedFile("YmlFormatStylish.txt");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differYmlFormatPlain() throws Exception {
        String file1 = getAbsolutePath("correctFile1.yml");
        String file2 = getAbsolutePath("correctFile2.yml");
        String expected = getExpectedFile("YmlFormatPlain.txt");
        String actual = generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void differYmlFormatYml() throws Exception {
        String file1 = getAbsolutePath("correctFile1.yml");
        String file2 = getAbsolutePath("correctFile2.yml");
        String expected = getExpectedFile("YmlFormatYml.txt");
        String actual = generate(file1, file2, "yml");
        assertEquals(expected, actual);
    }

    @Test
    public void differYmlFirstFileIsEmptyFormatStylish() throws Exception {
        String file1 = getAbsolutePath("emptyFile1.yml");
        String file2 = getAbsolutePath("correctFile2.yml");
        String expected = getExpectedFile("YmlFirstFileIsEmptyFormatStylish.txt");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differYmlSecondFileIsEmptyFormatStylish() throws Exception {
        String file1 = getAbsolutePath("correctFile1.yml");
        String file2 = getAbsolutePath("emptyFile2.yml");
        String expected = getExpectedFile("YmlSecondFileIsEmptyFormatStylish.txt");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differYmlBothFilesIsEmptyFormatStylish() throws Exception {
        String expected = "{"
                + "\n}";
        String file1 = getAbsolutePath("emptyFile1.yml");
        String file2 = getAbsolutePath("emptyFile2.yml");
        String actual = generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }
}
