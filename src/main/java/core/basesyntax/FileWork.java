package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> list = Files.readAllLines(file.toPath());
            String strings = String.join(" ", list);
            String[] strArray = strings.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            Arrays.sort(strArray);
            List<String> arrList = new ArrayList<String>();
            for (String str : strArray) {
                if (str.startsWith("w", 0)) {
                    arrList.add(str);
                }
            }
            return arrList.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cant read from file", e);
        }
    }
}
