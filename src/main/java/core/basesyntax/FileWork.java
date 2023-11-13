package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final String regEx = new String("\\b");

    public String[] readFromFile(String fileName) {
        List<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str).append("\n");
            }
            String[] tempArray = sb.toString().toLowerCase().split(regEx);
            if (tempArray.length != 1) {
                for (String temp : tempArray) {
                    if (temp.charAt(0) == 'w') {
                        strings.add(temp);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
        strings.sort(Comparator.naturalOrder());
        return strings.toArray(new String[strings.size()]);
    }
}
