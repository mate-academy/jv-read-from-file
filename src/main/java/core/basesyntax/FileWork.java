package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            bufferedReader.close();
            String[] words = stringBuilder.toString().toLowerCase().split("[\\W_]+");
            List<String> filteredWords = new ArrayList<>();

            for (String word : words) {
                if (word.startsWith("w")) {
                    filteredWords.add(word);
                }
            }
            String[] result = filteredWords.toArray(new String[0]);
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
