package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().toLowerCase()
                    .replaceAll("\\W", " ").split(" ");
            StringBuilder filtersWorlds = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(SPECIAL_CHARACTER)) {
                    filtersWorlds.append(words[i]).append(" ");
                }
            }
            if (filtersWorlds.length() == 0) {
                return new String[0];
            }
            String[] filterWorldResult = filtersWorlds.toString().split(" ");
            Arrays.sort(filterWorldResult);
            return filterWorldResult;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
