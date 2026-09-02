package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            ArrayList<String> list = new ArrayList<>();
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty() && (word.startsWith("w") || word.startsWith("W"))) {
                    list.add(word.toLowerCase());
                }
            }
            scanner.close();
            Collections.sort(list);
            return list.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("File not found: ", e);
        }
    }
}
