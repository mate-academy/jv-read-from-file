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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("There is now such file: ", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: ", e);
        }
        String[] split = stringBuilder.toString().split("\\W+");
        int newSize = 0;
        for (int i = 0; i < split.length; i++) {
            char targetLetter = 'w';
            if (split[i].toLowerCase().startsWith(String.valueOf(targetLetter))) {
                split[newSize] = split[i].toLowerCase();
                newSize++;
            }
        }
        String[] result = Arrays.copyOf(split, newSize);
        Arrays.sort(result);
        return result;
    }
}
