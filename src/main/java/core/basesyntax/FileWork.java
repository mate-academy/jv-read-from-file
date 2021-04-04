package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().split(" ");
            StringBuilder filtersWorlds = new StringBuilder();
            for (String word : words) {
                String toLowerCaseWord = word.toLowerCase();
                if (toLowerCaseWord.startsWith("w")) {
                    toLowerCaseWord = toLowerCaseWord.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
                    filtersWorlds.append(toLowerCaseWord).append(" ");

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
