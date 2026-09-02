package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

            String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
            List<String> list = new ArrayList<>();
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    list.add(word);
                }
            }

            Collections.sort(list);
            return list.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }
}
