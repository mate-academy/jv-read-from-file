package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder textReader = new StringBuilder();
            String readByline = reader.readLine();

            while (readByline != null) {
                textReader.append(readByline).append(System.lineSeparator());
                readByline = reader.readLine();
            }
            String[] split = textReader.toString().toLowerCase(Locale.ROOT).split("\\W+");
            StringBuilder includeW = new StringBuilder();

            for (String loop : split) {
                if (loop.startsWith("w")) {
                    includeW.append(loop).append(" ");
                }
            }
            String[] sortedText = includeW.toString().split(" ");
            Arrays.sort(sortedText);
            return file.length() == 0 || sortedText.length <= 1 ? new String[0] : sortedText;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
