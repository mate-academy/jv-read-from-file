package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        final String regex = "\\b[wW]\\w*";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String textFromFile = stringBuilder.toString();
        stringBuilder.setLength(0);
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(textFromFile);
        while (matcher.find()) {
            stringBuilder.append(matcher.group()).append(" ");
        }
        String[] resault = stringBuilder
                .toString()
                .toLowerCase()
                .trim()
                .replace("[!?,.]", "")
                .split(" ");
        Arrays.sort(resault);

        return resault[0].equals("") ? new String[0] : resault;
    }
}
