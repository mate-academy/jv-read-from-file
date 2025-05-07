package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
            String text = stringBuilder.toString().replaceAll("[^a-zA-Z ]"," ").toLowerCase();
            String[] result = text.split(" ");

            int count = 0;
            for (String results : result) {
                if (results.startsWith("w")) {
                    count++;
                }
            }
            String[] filteredWords = new String[count];
            int index = 0;
            for (String results : result) {
                if (results.startsWith("w")) {
                    filteredWords[index] = results;
                    index++;
                }
            }
            Arrays.sort(filteredWords);
            return filteredWords;
        } catch (IOException e) {
            throw new RuntimeException("Can`t rad file" + e);
        }
    }
}
