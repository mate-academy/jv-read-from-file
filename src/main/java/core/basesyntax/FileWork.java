package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        final String specifiedCharacter = "w";
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] unfiltredWords = stringBuilder.toString().split("\\W+");
        ArrayList<String> filteredWords = new ArrayList();
        for (String word : unfiltredWords) {
            if (word.toLowerCase().startsWith(specifiedCharacter)) {
                filteredWords.add(word.toLowerCase());
            }
        }
        Collections.sort(filteredWords);
        String[] sortedWords = new String[filteredWords.size()];
        return filteredWords.toArray(sortedWords);
    }
}
