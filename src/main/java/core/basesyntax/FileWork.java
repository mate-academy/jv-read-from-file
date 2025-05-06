package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String notSortedString = "";
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            String[] array = lines.toArray(new String[0]);
            String[][] splitWords = new String[array.length][];
            for (int i = 0; i < splitWords.length; i++) {
                splitWords[i] = array[i].split("\\s+");
            }
            for (int i = 0; i < splitWords.length;i++) {
                for (int j = 0; j < splitWords[i].length;j++) {
                    String result = splitWords[i][j].replaceAll("[^a-zA-Z]", "");
                    result = result.toLowerCase(Locale.ROOT);
                    char firstChar = result.charAt(0);
                    if (firstChar == 'w') {
                        notSortedString = notSortedString + result + " ";
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
        if (notSortedString.length() > 0) {
            String[] words = notSortedString.split(" ");
            Arrays.sort(words);
            return words;
        }
        return new String[0];
    }
}

