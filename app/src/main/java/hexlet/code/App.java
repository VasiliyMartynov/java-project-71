package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    @Option(names = { "-f", "--format" },
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    String format;

    @Parameters(paramLabel = "filePath1", description = "path to first file")
    String filePath1;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    String filePath2;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filePath1, filePath2, format));
        return 0;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
