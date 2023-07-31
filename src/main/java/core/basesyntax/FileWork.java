package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            return null;
        }

        File file = new File(fileName);
        List<String> words = new ArrayList<>();

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create a file", e);
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] values = value.split("[^a-zA-Z]");
                for (int i = 0; i < values.length; i++) {
                    if (values[i].startsWith("w") || values[i].startsWith("W")) {
                        words.add(values[i].toLowerCase());
                    }
                }
                value = bufferedReader.readLine();
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file", e);
        }

        if (words == null || words.size() == 0) {
            return new String[0];
        }

        return words.stream().sorted().collect(Collectors.toList()).toArray(new String[0]);
    }
}
