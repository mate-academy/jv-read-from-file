package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {

    private static final char STARTS_WITH = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder infoFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            if (value == null || value.isEmpty()) {
                return new String[0];
            }
            while (value != null) {
                infoFromFile.append(value);
                infoFromFile.append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] splitInfo = infoFromFile.toString().toLowerCase().split(" ");
        ArrayList<String> wordsWithW = new ArrayList<>();
        for (String str : splitInfo) {
            if (str.charAt(0) == STARTS_WITH) {
                str = str.replaceAll("[.!?]", "");
                wordsWithW.add(str);
            }
        }
        String[] readFromFile;
        readFromFile = wordsWithW.toArray(new String[0]);
        Arrays.sort(readFromFile);
        return readFromFile;
    }
}
