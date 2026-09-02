package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_SYMBOL = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[]{};
        }
        try {
            List<String> inputText = Files.readAllLines(file.toPath());
            String[] arrayWords = inputText.toString().toLowerCase().split("\\W+");
            inputText.clear();
            for (String word : arrayWords) {
                if (word.startsWith(SPECIFIED_SYMBOL)) {
                    inputText.add(word);
                }
            }
            Collections.sort(inputText);
            return inputText.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file!", e);
        }

    }
}
