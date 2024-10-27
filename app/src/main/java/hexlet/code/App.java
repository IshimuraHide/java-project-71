package hexlet.code;

import hexlet.code.Parser.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.concurrent.Callable;

import static  hexlet.code.GenDiff.generateDifferences;


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
        String mypath = "\\\\wsl$\\Ubuntu\\root\\project\\java-project-71\\app\\src\\main\\resources\\file1.json";

        //System.out.println(hexlet.code.Parser.parseFileToMap(mypath).toString());
        System.out.println(generateDifferences(filepath1,filepath2));

        return "Sucess";
    }

    public static void main(String[] args) {
        try {
            int exitCode = new CommandLine(new App()).execute(args);
            System.out.println("Hello world!");
            System.exit(exitCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



}