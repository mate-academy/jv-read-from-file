package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            if (stringBuilder.toString().length() < 1) {
                return new String[]{};
            }
            String[] data = stringBuilder.toString().split("\\W+");
            StringBuilder finalText = new StringBuilder();

            for (String datum : data) {
                if (datum.length() > 0 && (datum.charAt(0) == 'w' || datum.charAt(0) == 'W')) {
                    finalText.append(datum.toLowerCase()).append(" ");
                }
            }
            if (finalText.toString().length() < 1) {
                return new String[]{};
            }
            String[] result = finalText.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
