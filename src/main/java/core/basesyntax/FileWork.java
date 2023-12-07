package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String data;
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        data = data.replaceAll("[-.,;!?\\r\\n]", " ");
        String[] strArray = data.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (String word : strArray) {
            if (word.startsWith("w") || word.startsWith("W")) {
                result.add(word.toLowerCase());
            }
        }
        Collections.sort(result);
        System.out.println(result);
        return result.toArray(new String[0]);
    }
}
