package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private String[] result;
    private StringBuilder stringBuilder = new StringBuilder();
    private int wordsStartsWithW = 0;

    public String[] readFromFile(String fileName) throws IOException {
        try {
            result = Files.readString(Path.of(fileName)).split("[^A-Za-z0-9]+");
        } catch (IOException e) {
            throw new IOException("Can't read the file");
        }
        for (String word : result) {
            if (word.startsWith(SPECIFIED_CHARACTER)
                    || word.startsWith(SPECIFIED_CHARACTER.toUpperCase())) {
                stringBuilder.append(word.toLowerCase()).append(" ");
                wordsStartsWithW++;
            }
        }
        if (wordsStartsWithW == 0) {
            return new String[0];
        } else {
            result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        }
    }
}
