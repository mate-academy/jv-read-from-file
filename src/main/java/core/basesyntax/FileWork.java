package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
        String[] fileNameArray = builder.toString().toLowerCase().split("\\W+");
        int amountWordsInW = 0;
        for (int i = 0; i < fileNameArray.length; i++) {
            if (fileNameArray[i].startsWith(SPECIFIED_CHARACTER)) {
                amountWordsInW++;
                result.append(fileNameArray[i]).append(" ");
            }
        }
        if (amountWordsInW == 0) {
            return new String[0];
        }
        String[] arrayWithWordsInW = result.toString().split(" ");
        Arrays.sort(arrayWithWordsInW);
        return arrayWithWordsInW;
    }
}
