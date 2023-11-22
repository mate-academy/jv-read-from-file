package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> stringList = new ArrayList<>();
        String value = null;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(fileName)))) {
            value = bufferedReader.readLine();
            while (value != null) {
                for (String word : value.toLowerCase().split(" ")) {
                    if (word.charAt(0) == 'w') {
                        stringList.add(word.toLowerCase()
                                .replaceAll("[!?,.]",""));
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file ", e);
        }
        String[] res = stringList.toArray(new String[0]);
        Arrays.sort(res);
        return res;
    }
}
