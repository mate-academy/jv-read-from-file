package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(fileName)))) {
            int value = bufferedReader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            ArrayList<String> list = new ArrayList<>(Arrays.asList(stringBuilder.toString()
                            .replaceAll("\\p{Punct}", " ").replaceAll("\n", " ")
                            .toLowerCase().split(" ")));
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).startsWith("w")) {
                    list.remove(i);
                    i--;
                }
            }
            String[] result = new String[list.size()];
            result = list.toArray(result);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Have some problems with file: ", e);
        }
    }
}
