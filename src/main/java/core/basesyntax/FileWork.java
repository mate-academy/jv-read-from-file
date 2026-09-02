package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String WORD_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String read = bufferedReader.readLine();
            List<String> stringList = new ArrayList<>();
            while (read != null) {
                read = read.toLowerCase();
                String[] words = read.split(WORD_SEPARATOR);
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringList.add(word.replaceAll("\\p{Punct}", ""));
                    }
                }
                Collections.sort(stringList);
                read = bufferedReader.readLine();
            }
            String[] stringArray = new String[stringList.size()];

            for (int i = 0; i < stringArray.length; i++) {
                stringArray[i] = stringList.get(i);
            }
            if (stringList.isEmpty()) {
                return new String[]{};
            } else {
                return stringArray;
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found exception");
        }
    }
}
