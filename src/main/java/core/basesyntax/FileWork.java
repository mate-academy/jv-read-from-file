package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileWork {
    private final String SPECIFIED_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String fileContent;
        try {
            fileContent = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
        String[] fileContentArr = fileContent.split("\\s+");
        List<String> filteredWords = new ArrayList<>();
        for (String word : fileContentArr) {
            if (word.startsWith(SPECIFIED_CHAR)) {
                filteredWords.add(word.replaceAll("\\p{Punct}", "").toLowerCase());
            }
        }
        return filteredWords.toArray(new String[0]);
    }
}
