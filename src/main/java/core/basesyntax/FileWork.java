package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder array = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }

            String string = stringBuilder.toString().toLowerCase();
            int i = 0;
            for (String word : string.split(" ")) {
                if (word.toLowerCase().toCharArray()[0] == 'w') {
                    if (word.contains("\n")) {
                        if (word.contains(",") || word.contains(".")
                                || word.contains("!") || word.contains("?")) {
                            word = word.replace(".", "")
                                       .replace(",", "");
                        }
                        String[] twoWords = word.split("\n");
                        if (twoWords.length == 2) {
                            array.append(twoWords[0].toLowerCase()).append(" ")
                                 .append(twoWords[1].toLowerCase()).append(" ");
                        } else {
                            array.append(twoWords[0].toLowerCase()).append(" ");
                        }
                    } else if (word.contains(",") || word.contains(".")
                            || word.contains("!") || word.contains("?")) {
                        while (word.contains(",") || word.contains(".")
                            || word.contains("!") || word.contains("?")) {
                            word = word.substring(0, word.length() - 1);
                        }
                        array.append(word.toLowerCase()).append(" ");

                    } else {
                        array.append(word.toLowerCase()).append(" ");
                    }
                    i++;
                }
            }
            if (array.toString().isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] sortedArray = array.toString().split(" ");
        Arrays.sort(sortedArray);
        String[] result = new String[sortedArray.length];

        return sortedArray;
    }
}
