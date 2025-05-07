package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final String W_CHAR = "w";

    public String[] readFromFile(String fileName) {
        String[] words;
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            words = stringBuilder.toString().toLowerCase().split("\\W+");
            Arrays.sort(words);

            for (String word : words) {
                if (word.startsWith(W_CHAR)) {
                    list.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
        return list.toArray(new String[0]);
    }
}
