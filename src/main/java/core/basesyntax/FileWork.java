package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder1.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String dataFromFile = stringBuilder1.toString();
        if (dataFromFile.isEmpty()) {
            return new String[0];
        }
        String[] dataArray = dataFromFile.split("\\W+");
        for (String data : dataArray) {
            data = data.toLowerCase();
            if (startWithLetter(data)) {
                stringBuilder2.append(data).append(" ");
            }
        }

        String[] result = stringBuilder2.toString().split(" ");
        Arrays.sort(result, Comparator.naturalOrder());
        if (result.length == 1) {
            return new String[0];
        }

        return result;
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
