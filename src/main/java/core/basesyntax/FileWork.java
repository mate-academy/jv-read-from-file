package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        final String fileContent;
        try {
            fileContent = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
        String[] fileContentArr = fileContent.split("\\s+");
        List<String> filteredWords = new ArrayList<>();
        for (String word : fileContentArr) {
            String cleanedWord = word.replaceAll("\\p{Punct}", "").toLowerCase();
            if (word.toLowerCase().startsWith(SPECIFIED_CHAR)) {
                filteredWords.add(cleanedWord);
            }
        }
        String[] naturalOrderedWords = filteredWords.toArray(new String[0]);
        Arrays.sort(naturalOrderedWords);
        return naturalOrderedWords;
    }
}
