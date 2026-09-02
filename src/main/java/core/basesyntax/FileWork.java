package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builderFinal = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read this file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't find this file", e);
        }
        String[] array = builder.toString().toLowerCase().split("[^A-Za-z0-9]+");
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith("w")) {
                builderFinal.append(array[i]).append(" ");
            }
        }
        String[] result = builderFinal.toString().split(" ");
        Arrays.sort(result);
        return result.length == 1 ? new String[0] : result;
    }
}

