package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String value = getValueFile(fileName);
        if (value.isEmpty()) {
            return new String[0];
        }

        List<String> matchers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[wW][A-Za-z0-9]*\\b");
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            matchers.add(matcher.group().toLowerCase());
        }

        Comparator<String> naturalOrderComparator = (s1, s2) -> {
            String chunk1 = Pattern.compile("(\\d+)").matcher(s1)
                    .replaceAll(m -> String.format("%09d", Integer.parseInt(m.group())));
            String chunk2 = Pattern.compile("(\\d+)").matcher(s2)
                    .replaceAll(m -> String.format("%09d", Integer.parseInt(m.group())));
            return chunk1.compareTo(chunk2);
        };
        return matchers.stream().sorted(naturalOrderComparator).toArray(String[]::new);
    }

    public String getValueFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                stringBuilder.append(value).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't be read: " + fileName, e);
        }
        return stringBuilder.toString();
    }
}
