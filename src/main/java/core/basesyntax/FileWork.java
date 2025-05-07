package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER_ONE = 'w';
    private static final char SPECIFIED_CHARACTER_TWO = 'W';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] splits = stringBuilder.toString().split("\\W+");
            StringBuilder newStringBuilder = new StringBuilder();
            for (String split : splits) {
                if (!split.isEmpty() && (split.charAt(0) == SPECIFIED_CHARACTER_ONE
                        || split.charAt(0) == SPECIFIED_CHARACTER_TWO)) {
                    newStringBuilder.append(split).append(" ");
                }
            }
            if (newStringBuilder.length() == 0) {
                return new String[] {};
            }
            String[] fileText = newStringBuilder.toString().split(" ");
            for (int i = 0; i < fileText.length; i++) {
                fileText[i] = fileText[i].toLowerCase();
            }
            Arrays.sort(fileText);
            return fileText;
        } catch (Exception e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
    }
}
