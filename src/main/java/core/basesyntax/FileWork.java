package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            String content = String.join(" ", Files.readAllLines(Paths.get(fileName)));
            String[] split = content.split("\\W+");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].toLowerCase();
            }

            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith("w")) {
                    result.add(split[i]);
                }
            }
            Collections.sort(result);
        } catch (IOException e) {
            System.out.println("Помилка");
        }
        return result.toArray(new String[0]);

    }
}
