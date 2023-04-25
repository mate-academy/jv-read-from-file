package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String sentence = stringBuilder.toString();
        String[] split = sentence.toLowerCase().split("\\W+");
        ArrayList<String> words = new ArrayList();
        for (int index = 0; index < split.length; index++) {
            if (split[index].charAt(0) == 'w') {
                words.add(split[index]);
            }
        }
        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}
