package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        int countWords = 0;

        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String valueSrting = bufferedReader.readLine();
            while (valueSrting != null) {
                stringBuilder.append(valueSrting).append(System.lineSeparator());
                valueSrting = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: " + fileName, e);
        }

        if (stringBuilder.toString().length() == 0) {
            return new String[0];
        } else {
            String[] words = stringBuilder.toString().toLowerCase().split("[ ,.?!\\n]+");
            for (String word : words) {
                if (SPECIFIED_CHARACTER.equals(word.substring(0, 1))) {
                    countWords++;
                }
            }
            String[] result = new String[countWords];
            int j = 0;
            for (int i = 0; i < words.length; i++) {
                if (SPECIFIED_CHARACTER.equals(words[i].substring(0,1))) {
                    result[j++] = words[i];
                }
            }
            List<String> stringList = Arrays.asList(result);
            Collections.sort(stringList);
            result = stringList.toArray(stringList.toArray(new String[0]));
            return result;
        }
    }
}
