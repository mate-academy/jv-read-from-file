package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static int onceChar = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error file is not found", e);
        }
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(" ");
            }
            String contentString = content.toString();
            String[] tokens = contentString.split("[^A-Za-z]+");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i].toLowerCase().trim();
                if (!token.isEmpty() && token.charAt(onceChar) == 'w') {
                    list.add(token);
                }
            }
            list.sort(String::compareTo);
            return list.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException("File is not found", e);
        }
    }
}
