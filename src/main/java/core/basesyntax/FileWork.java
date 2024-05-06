package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
            String wordsStartsWith = filteredByStartLetter(fileContent, "w");
            String[] result = wordsStartsWith.isEmpty()
                    ? new String[0]
                    : wordsStartsWith.split(" ");
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String filteredByStartLetter(String string, String startWith) {
        StringBuilder wordsStartsWith = new StringBuilder();
        for (String word : string.toLowerCase().split("\\W+")) {
            if (word.startsWith(startWith)) {
                wordsStartsWith.append(word).append(" ");
            }
        }

        return wordsStartsWith.toString();
    }
}
