package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String NONALPHANUMERICCHARS = "\\W+";

    public String[] readFromFile(String fileName) {
        return filterData(getInfoFromFile(fileName));
    }

    public String getInfoFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can not find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can not read file", e);
        }
        return stringBuilder.toString();
    }

    public String[] filterData(String data) {
        String[] words = data.toLowerCase().split(NONALPHANUMERICCHARS);
        List<String> wwords = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith("w")) {
                wwords.add(word.toLowerCase());
            }
        }
        String[] result = wwords.toArray(new String[0]);
        Arrays.sort(result);
        return result;

    }
}
