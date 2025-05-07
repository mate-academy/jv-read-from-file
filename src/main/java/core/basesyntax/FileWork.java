package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String text = bufferedReader.readLine();
            while (text != null) {
                stringBuilder.append(text).append(" ");
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String [] array = stringBuilder.toString().toLowerCase().split("[^A-Za-z0-9]+");
        String line = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith("w")) {
                line = line.concat(array[i]).concat(" ");
            }
        }
        String [] result = line.split(" ");
        if (result.length == 1) {
            return new String[0];
        }
        Arrays.sort(result);
        return result;
    }
}
