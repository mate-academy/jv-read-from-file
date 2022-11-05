package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String value;
        String fileText;
        List<String> list;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((value = bufferedReader.readLine()) != null) {
                sb.append(value).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileText = sb.toString().toLowerCase();
        list = findMatcher(fileText, "\\bw\\w*\\b");
        return getSortedArray(list);
    }

    private static List<String> findMatcher(String text, String regex) {
        List list = new ArrayList();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    private String[] getSortedArray(List<String> list) {
        String[] arr = new String[list.size()];
        list.toArray(arr);
        Arrays.sort(arr);

        return arr;
    }
}
