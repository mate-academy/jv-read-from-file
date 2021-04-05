package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {

                for (String word : value.split(" ")) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        result.add(word.toLowerCase().replaceAll("\\p{P}", ""));
                    }
                }
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(result);

        return result.toArray(new String[0]);
    }
}
