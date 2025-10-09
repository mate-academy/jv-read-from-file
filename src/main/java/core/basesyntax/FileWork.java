package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String contentText = reader.readLine();
            while (contentText != null) {
                content.append((contentText)).append(" ");
                contentText = reader.readLine();
            }
            String text = content.toString();
            String[] words = text.toLowerCase().split("[^a-z]+");
            List<String> resultList = new ArrayList<>();

            for (String word : words) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    resultList.add(word);
                }
            }

            if (resultList.isEmpty()) {
                return new String[0];
            }

            Collections.sort(resultList);
            return resultList.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
