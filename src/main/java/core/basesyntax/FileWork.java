package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file!", e);
        }
        
        if (stringBuilder.toString().length() == 0) {
            return new String[0];
        }

        String textFile = stringBuilder.toString().toLowerCase();
        String [] splitResult = textFile.split("\\W+");
        StringBuilder secondBuilder = new StringBuilder();
        for (String splitter: splitResult) {
            if (splitter.charAt(0) == 'w') {
                secondBuilder.append(splitter).append(" ");
            }
        }
        String [] result = secondBuilder.toString().split(" ");
        Arrays.sort(result);

        return (stringBuilder.toString().length() == 0 || secondBuilder.toString().length() == 0)
                ? new String[0] : result;
    }
}
