package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        List<String> resultList = new ArrayList<>();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));
            String value = buffReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                value = value.toLowerCase().replaceAll("[^\\sa-zA-Z]", "");
                String[] words = value.split(" ");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        resultList.add(word);
                    }
                }
                value = buffReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read from file.", e);
        }

        Collections.sort(resultList);

        return resultList.toArray(new String[0]);
    }
}
