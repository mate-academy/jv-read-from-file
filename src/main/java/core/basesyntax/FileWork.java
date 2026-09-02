package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String[] temp = new String[0];
    private ArrayList<String> stringsAnswer = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            if (strings.size() != 0) {
                for (String line : strings) {
                    String[] textLine = line.split("(?=\\.)|(?=!)|(?=\\?)|\\s+");
                    for (String words : textLine) {
                        if (StartWithLetter.startWithLetter(words.toLowerCase())) {
                            stringsAnswer.add(words.toLowerCase());
                        }
                    }
                }
                Collections.sort(stringsAnswer);
                String[] arr = new String[stringsAnswer.size()];
                arr = stringsAnswer.toArray(arr);
                return arr;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error read file ", e);
        }

        return temp;
    }
}
