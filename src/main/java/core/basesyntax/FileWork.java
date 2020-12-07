package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] allWords = stringBuilder.toString().toLowerCase().split(" ");
            for (String word: allWords) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    arrayList.add(word.replaceAll("[.?!]", ""));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] result = arrayList.toArray(new String[arrayList.size()]);
        Arrays.sort(result);
        return result;
    }
}
