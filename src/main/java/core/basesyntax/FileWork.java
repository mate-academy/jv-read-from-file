package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String FIRST_WORD_LETTER = "w";
    private static final String WORDS_SEPARATOR = ",";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        List<String> data;
        try {
            data = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] splitedData = data.toString().toLowerCase().split("\\W+");
        for (String word : splitedData) {
            if (word.startsWith(FIRST_WORD_LETTER)) {
                builder.append(word).append(WORDS_SEPARATOR);
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        } else {
            String[] result = builder.toString().split(WORDS_SEPARATOR);
            Arrays.sort(result);
            return result;
        }
    }
}
