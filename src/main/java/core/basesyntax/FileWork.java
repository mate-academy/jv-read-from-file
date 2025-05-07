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
        File incomeFile = new File(fileName);
        String fileLines = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(incomeFile))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            fileLines = stringBuilder.toString().toLowerCase().replaceAll("\\W+", " ");

        } catch (IOException e) {
            throw new RuntimeException("Cant read the file", e);
        }
        String[] filesWords = fileLines.split("\\W+");
        StringBuilder addWords = new StringBuilder();
        Pattern pattern = Pattern.compile("^w");
        for (String str : filesWords) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                addWords.append(str).append(" ");
            }
        }
        if (addWords.length() == 0) {
            return new String[0];
        }
        String[] result = addWords.toString().split("\\W+");
        Arrays.sort(result);
        return result;
    }
}
