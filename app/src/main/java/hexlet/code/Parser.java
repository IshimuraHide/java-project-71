package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import static java.nio.file.Files.readString;

public class Parser {
    public static Map<String, Object> parseFileToMap(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
       // String mypath = "\\\\wsl$\\Ubuntu\\root\\project\\java-project-71\\app\\src\\main\\resources\\file1.json";
        return mapper.readValue(readString(Path.of(filePath)), new TypeReference<>() { });
    }
}
