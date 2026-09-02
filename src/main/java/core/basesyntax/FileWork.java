package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String fileContent = stringBuilder.toString().toLowerCase();
        if (fileContent.length() == 0) {
            return new String[0];
        }
        String[] parts = fileContent.split(" ");
        int arrayLength = 0;
        for (String part : parts) {
            if (part.charAt(0) == 'w') {
                arrayLength++;
            }
        }
        String[] result = new String[arrayLength];
        int count = 0;
        for (String part : parts) {
            if (part.charAt(0) == 'w') {
                result[count++] = part.replaceAll("\\p{Punct}", "");
            }
        }
        Arrays.sort(result);
        return result;
    }
}
