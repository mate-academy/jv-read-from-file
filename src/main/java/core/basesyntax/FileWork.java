package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char UPPER_CHAR = 'W';
    private static final char LOWER_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                text.append((char) value);
                value = bufferedReader.read();
            }
            System.out.println(text.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (text.length() == 0) {
            return new String[]{};
        }
        return findWWords(text);
    }

    private String[] findWWords(StringBuilder stringBuilder) {
        List<String> splitedString = Arrays.asList(stringBuilder.toString().split(" |"
                + System.lineSeparator()));
        List<String> finalResult = new ArrayList<String>();
        for (int i = 0; i < splitedString.size(); i++) {
            if (splitedString.get(i).charAt(0) == UPPER_CHAR
                    || splitedString.get(i).charAt(0) == LOWER_CHAR) {
                finalResult.add(splitedString.get(i).toLowerCase().replaceAll("[^\\w]", ""));
            }
        }
        Collections.sort(finalResult);
        return finalResult.toArray(new String[]{});
    }
}
