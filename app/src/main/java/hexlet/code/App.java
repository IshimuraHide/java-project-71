package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

//описание команды для picocli
@Command(name = "gendiff", version = "App 1.0", mixinStandardHelpOptions = true)


public class App implements Runnable{

    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

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