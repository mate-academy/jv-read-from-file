package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String fileContent = getContentFromFile(fileName);
        if (fileContent.length() == 0) {
            return new String[]{};
        }

        Pattern pattern = Pattern.compile("\\b[wW]\\w+\\b");

        Matcher matcher = pattern.matcher(fileContent);
        String[] result = new String[(int) matcher.results().count()];

        matcher = pattern.matcher(fileContent);
        int counter = 0;
        while (matcher.find()) {
            result[counter++] = matcher.group().toLowerCase();
        }
        Arrays.sort(result);
        return result;
    }

    private String getContentFromFile(String fromFileName) {
        File file = new File(fromFileName);
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                result.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file" + fromFileName, e);
        }
        return result.toString();
    }
}
