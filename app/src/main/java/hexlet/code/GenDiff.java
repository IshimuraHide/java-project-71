package hexlet.code;
import java.io.IOException;
import java.util.Map;

import static hexlet.code.Parser.parseFileToMap;

public class GenDiff {
    public static String generateDifferences(String path1, String path2 ) throws Exception {
        Map<String, Object> file1 = parseFileToMap(path1);
        Map<String, Object> file2 = parseFileToMap(path2);
        return "ParsedFile1 = " + file1.toString() + "\n" +   "ParsedFile2 = " + file2.toString();
    }

}
