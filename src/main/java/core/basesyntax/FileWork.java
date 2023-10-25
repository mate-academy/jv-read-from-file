package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private String inputString;
    private String[] result;
    private StringBuilder stringBuilder = new StringBuilder();
    private int wordsStartsWithW = 0;

    public String[] readFromFile(String fileName) throws IOException {
        try {
            inputString = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new IOException("Can't read the file");
        }
        result = inputString.split("[^A-Za-z0-9]+");
        for (String word : result) {
            if (word.startsWith("w")
                    || word.startsWith("W")) {
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
