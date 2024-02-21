package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append("\n");
                value = reader.readLine();
            }
            String text = stringBuilder.toString();
            String[] splitText = text.split("\\P{Alpha}+");
            stringBuilder = new StringBuilder();
            for (String word : splitText) {
                if (word.toLowerCase().startsWith("w")) {
                    stringBuilder.append(word.toLowerCase()).append(" ");
                }
            }
            if (stringBuilder.toString().equals("")) {
                return new String[0];
            }
            String[] arrayW = stringBuilder.toString().split(" ");
            Arrays.sort(arrayW);
            return arrayW;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
