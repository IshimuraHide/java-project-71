package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;


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
    String filepath1 = "src/main/resources/file1.json";
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filepath2 = "src/main/resources/file2.json";

    @Override
    public void run() {
        // The business logic of the command goes here...
        String json = "src/main/resources/file1.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> map      = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // (omitted for the sake of brevity).
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println("Hello world!");
        System.exit(exitCode);

    }


}