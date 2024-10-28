package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static  hexlet.code.Differ.generate;


//описание команды для picocli
@Command(name = "genDiff", version = "genDiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference." +
                "       \n filepath1         path to first file" +
                "       \n filepath2         path to second file")

public class App implements Callable<String> {
    //Параметры
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    //private static String filepath1 = "app/src/main/resources/file1.json";
    private static String filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;
    //Опции

    @Option(names = { "-f", "--format" }, paramLabel = "format",
            description = "output format [default: stylish]",defaultValue = "stylish")
    private String format = "stylish";


    @Override
    public String call() throws Exception {
        System.out.println(generate(filepath1,filepath2));
        return "Sucess";
    }

    public static void main(String[] args) {
        try {
            int exitCode = new CommandLine(new App()).execute(args);
           // System.out.println("Hello world!");
            System.exit(exitCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



}