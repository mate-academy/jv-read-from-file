package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    private static final String START_WORLD = "w";
    private StringBuilder stringBuilder;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        String[] test = stringBuilder.toString().split("\\W+");
        int countForArray = 0;
        int count = 0;
        for (int i = 0; i < test.length; i++) {
            if (test[i].toLowerCase().startsWith(START_WORLD)) {
                countForArray++;
            }
        }

        String[] result = new String[countForArray];
        for (int j = 0; j < test.length; j++) {
            if (test[j].toLowerCase().startsWith(START_WORLD)) {
                result[count] = test[j].toLowerCase();
                count++;
            }
        }
        Arrays.sort(result);
        return result;

    }
}
