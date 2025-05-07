package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_VALUE = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File has not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + file.getName(), e);
        }
        String contentFromFile = stringBuilder.toString().toLowerCase();
        String[] split = contentFromFile.split("[\\p{Punct}\\s]+");
        stringBuilder = new StringBuilder();
        for (String str : split) {
            if (str.startsWith(SPECIFIED_VALUE)) {
                stringBuilder.append(str).append(" ");
            }
        }
        if (stringBuilder.toString().length() == 0) {
            return new String[]{};
        }
        String[] resultArray = stringBuilder.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
