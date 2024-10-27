package hexlet.code;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static hexlet.code.Parser.parseFileToMap;

public class GenDiff {
    public static String generateDifferences(String path1, String path2 ) throws Exception {
        Map<String, Object> file1 = parseFileToMap(path1);
        Map<String, Object> file2 = parseFileToMap(path2);
        Map<String, Object> result = new HashMap<>();
        Set<String> allKeys = new TreeSet<>(file1.keySet());
        allKeys.addAll(file2.keySet());
        for (var key : allKeys) {
            if(file1.containsKey(key) && !file2.containsKey(key)) {
                result.put(key, )
            }
        }


        return "ParsedFile1 = " + file1.toString() + "\n" +   "ParsedFile2 = " + file2.toString() + "Path" + path1;
    }

}
