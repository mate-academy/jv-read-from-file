package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SHOULD_BE_REPLACED = "[?!.,]";
    private static final String SHOULD_BE_REPLACED_BY = "";
    private static final char TRIGGER_LETTER = 'w';
    private final ArrayList<String> listWithTriggerStart = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String refactored = line
                        .replaceAll(SHOULD_BE_REPLACED, SHOULD_BE_REPLACED_BY)
                        .toLowerCase();
                String[] wordsFromSentence = refactored.split(" ");
                for (String word : wordsFromSentence) {
                    if (word.charAt(0) == TRIGGER_LETTER) {
                        listWithTriggerStart.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("didn't work", e);
        }
        Collections.sort(listWithTriggerStart);
        return listWithTriggerStart.toArray(new String[0]);
    }
}
