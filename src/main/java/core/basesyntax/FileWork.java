package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        char textFilter = 'w';
        ArrayList<String> output = new ArrayList<>();
        try {
            String[] separatedText = Files.readString(path).toLowerCase().split("\n| ");
            if (Files.readString(path).isEmpty()) {
                return new String[]{};
            } else {
                for (String word : separatedText) {
                    if (word.toCharArray()[0] == textFilter) {
                        word = word.replaceAll("[^\\sa-zA-Z0-9]", "").trim();
                        output.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Collections.sort(output);
        //return output.toArray(new String[output.size()]);
        String[] unsorted = output.toArray(new String[output.size()]);
        Arrays.sort(unsorted);
        return unsorted;
    }
}
