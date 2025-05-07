package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final char SYMBOL = 'w';
    private static final int FIRST_CHAR_INDEX = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String> listOfWords = new ArrayList<>();
            String currentLine = bufferedReader.readLine();
            if (currentLine == null) {
                return new String[]{};
            }
            while (currentLine != null) {
                String[] words = currentLine.split("\\W+");
                for (String word : words) {
                    if (word.toLowerCase().charAt(FIRST_CHAR_INDEX) == SYMBOL) {
                        listOfWords.add(word.toLowerCase());
                    }
                }
                currentLine = bufferedReader.readLine();
            }
            listOfWords.sort(Comparator.naturalOrder());
            String[] result = new String[listOfWords.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = listOfWords.get(i);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
