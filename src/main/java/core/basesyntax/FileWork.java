
package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        String allText = null;
        try {
            allText = Files.readAllLines(path).toString();
        } catch (IOException e) {
            throw new RuntimeException("List was not created", e);
        }
        String[] words = allText.split("\\W");
        ArrayList<String> wList = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                wList.add(word.toLowerCase());
            }
        }
        if (wList.size() == 0) {
            return new String[0];
        }
        Collections.sort(wList);
        StringBuilder builder = new StringBuilder();
        String delimiter = ",";
        for (String word : wList) {
            builder.append(word).append(delimiter);
        }
        return builder.toString().split(delimiter);
    }
}
