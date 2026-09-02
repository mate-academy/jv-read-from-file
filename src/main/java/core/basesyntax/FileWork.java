package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringbuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                stringbuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }

            if (stringbuilder.length() == 0) {
                return new String[0];
            }

            String[] splits = stringbuilder.toString().toLowerCase().split("\\W+");

            StringBuilder builder = new StringBuilder();

            for (String word : splits) {
                char c = word.charAt(0);
                if (c == 'w') {
                    builder.append(word).append(" ");
                }
            }

            String sentence = builder.toString();
            String[] words = sentence.split(" ");
            Arrays.sort(words);

            if (builder.length() == 0) {
                return new String[0];
            }
            return words;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file" + fileName, e);
        }
    }
}
