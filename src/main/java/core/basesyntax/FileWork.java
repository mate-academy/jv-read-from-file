package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] split = fileName.split("\\W+");

        int count = 0;
        for (String word : split) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] filteredWords = new String[count];
        int index = 0;
            for (String word : split) {
            if (word.toLowerCase().startsWith("w")) {
                filteredWords[index] = word.toLowerCase();
                index++;
            }
          }
        
        return filteredWords;
    }
}
