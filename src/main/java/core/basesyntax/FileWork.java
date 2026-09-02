package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] strings = getLowerCaseStrings(fileName);
        int counter = 0;

        if (strings[0] == "") {
            return new String[]{};
        }

        for (String str : strings) {
            if (str.charAt(0) == 'w') {
                counter++;
            }
        }

        String[] result = new String[counter];
        counter = 0;

        for (String str : strings) {
            if (str.charAt(0) == 'w') {
                result[counter++] = str;
            }
        }

        Arrays.sort(result);
        return result;
    }

    public String[] getLowerCaseStrings(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String fileStr;
            while ((fileStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(fileStr).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }

        String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
        return strings;
    }
}
