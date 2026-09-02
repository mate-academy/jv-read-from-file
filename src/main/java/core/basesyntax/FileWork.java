package core.basesyntax;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) throws Exception {
        try {
            if (fileName == null || fileName.length() == 0) {
                return new String[0];
            }
        } catch (Exception e) {
            throw new NullPointerException("no file");
        }
        String s = Files.readString(Paths.get(fileName));
        String[] splitted = s.split("\\W+");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < splitted.length; i++) {
            String name = splitted[i].toLowerCase();
            if (!name.isEmpty() && name.charAt(0) == 'w') {
                result.add(name);
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}



