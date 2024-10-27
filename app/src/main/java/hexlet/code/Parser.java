package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import static java.nio.file.Files.readString;

public class Parser {
    public static Map<String, Object> parseFileToMap(String filePath) throws Exception {
        Path path = GetFullPath(filePath);
        ObjectMapper mapper = new ObjectMapper();
       // String mypath = "\\\\wsl$\\Ubuntu\\root\\project\\java-project-71\\app\\src\\main\\resources\\file1.json";
        return mapper.readValue(readString(path), new TypeReference<>() { });

        // \\wsl$\Ubuntu\root\project\java-project-71\app\src\test\resources\file1.json \\wsl$\Ubuntu\root\project\java-project-71\app\src\test\resources\file2.json
               // \\wsl$\Ubuntu\root\project\java-project-71\app\src\test\resources\file2.json

    }
    public static Path GetFullPath(String path) {
        String path1 = "src/main/resources";
        File file = new File(path1);
        String absolutePath = file.getAbsolutePath();
        Path resultPath = Path.of(path);
        if (!path.startsWith("/")) {
            resultPath = Path.of(absolutePath + "/" + path);
        }
        if (new File(resultPath.toString()).exists()) {
            return resultPath;
        }
        throw new RuntimeException("Файл: " + resultPath + " не существует");
    }
}
