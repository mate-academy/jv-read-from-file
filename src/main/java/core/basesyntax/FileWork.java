package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private List<String> wordsFromInputFile = new ArrayList<>();
    private String fileContent = null;

    public String[] readFromFile(String fileName) {
        try {
            fileContent = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            String[] splitFile = fileContent.trim().split("\\W+");
            for (String word : splitFile) {
                word = word.toLowerCase();
                if (!word.isBlank() && word.charAt(0) == SPECIFIED_CHARACTER) {
                    wordsFromInputFile.add(word);
                }
            }
            wordsFromInputFile.sort(Comparator.naturalOrder());
        }
        return wordsFromInputFile.toArray(new String[0]);
    }
}
