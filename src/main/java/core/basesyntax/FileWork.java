package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line = reader.readLine();
            StringBuilder allWords = new StringBuilder();

            while (line != null) {
                allWords.append(line).append(" ");
                line = reader.readLine();
            }

            String[] split = allWords.toString().toLowerCase().split("\\W+");
            String[] filtered = new String[split.length];

            int j = 0;
            for (String s : split) {
                if (s.startsWith("w")) {
                    filtered[j] = s;
                    j++;
                }
            }

            String[] result = new String[j];

            if (j == 0) {
                return result;
            }

            j = 0;
            for (String s : filtered) {
                if (s != null) {
                    result[j] = s;
                    j++;
                }
            }

            Arrays.sort(result);

            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
