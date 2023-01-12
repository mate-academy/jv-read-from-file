package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        int count = 0;
        try {
            String[] lines = Files.readAllLines(file.toPath()).toArray(new String[0]);
            for (int i = 0; i < lines.length; i++) {
                String[] words = lines[i].split(" ");
                for (int j = 0; j < words.length; j++) {
                    if (startWithLetter(words[j].toLowerCase())) {
                        count++;
                    }
                }
            }
            String[] result = new String[count];
            int index = 0;
            for (int i = 0; i < lines.length; i++) {
                String[] words = lines[i].split(" ");
                for (int j = 0; j < words.length; j++) {
                    if (startWithLetter(words[j].toLowerCase())) {
                        if (words[j].contains(".")) {
                            result[index] = words[j].replace(".","").toLowerCase();
                            index++;
                        } else if (words[j].contains("?")) {
                            result[index] = words[j].replace("?", "").toLowerCase();
                            index++;
                        } else if (words[j].contains("!")) {
                            result[index] = words[j].replace("!", "").toLowerCase();
                            index++;
                        } else {
                            result[index] = words[j].toLowerCase();
                            index++;
                        }
                    }
                }
            }
            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

}
