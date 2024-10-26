package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


//описание команды для picocli
@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference." +
                "       \n filepath1         path to first file" +
                "       \n filepath2         path to second file")

public class App implements Runnable{

    //Опции

    @Option(names = { "-f", "--format" }, paramLabel = "format",
            description = "output format [default: stylish]",defaultValue = "stylish")
    private String format;


    //Параметры в нашем случае не используются
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println("Hello world!");
        System.exit(exitCode);

    }


}