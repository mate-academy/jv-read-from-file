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
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char)value);
                value = bufferedReader.read();

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("can't read file",e);
        } catch (IOException e) {
            throw new RuntimeException("cant't read ",e);
        }
        String[] values = stringBuilder.toString().split("\\W+");
        StringBuilder update = new StringBuilder();
        for (String value:values) {
            if (value.startsWith("W") || value.startsWith("w")) {
                update.append(value.toLowerCase()).append(" ");
            }
        }
        if (!update.isEmpty()) {
            String[] result = update.toString().split(" ");
            Arrays.sort(result);
            return result;
        }

        return new String[0];
    }
}
