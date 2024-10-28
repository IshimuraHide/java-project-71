package hexlet.code;
import java.util.*;

import static hexlet.code.Parser.parseFileToMap;

public class Differ {
    public static String generate(String path1, String path2 ) throws Exception {
        Map<String, Object> file1 = parseFileToMap(path1);
        Map<String, Object> file2 = parseFileToMap(path2);
        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> allKeys = new TreeSet<>(file1.keySet());
        allKeys.addAll(file2.keySet());
        //System.out.println(Arrays.toString(allKeys.toArray(new String[0])));

        for (var key : allKeys) {
           // System.out.println(key);
            if (file1.containsKey(key) && !file2.containsKey(key)) {
                result.put("-" + key, file1.get(key));
            } else if (!file1.containsKey(key) && file2.containsKey(key)) {
                result.put("+" + key, file2.get(key));
            } else if (!file2.get(key).equals(file1.get(key))) {
                result.put("-" + key, file1.get(key));
                result.put("+" + key, file2.get(key));
            } else {
                result.put(key, file2.get(key));
            }
        }
        return result.toString();
    }

}
