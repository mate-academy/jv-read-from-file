package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() > 0) {
            StringBuilder buffer = new StringBuilder();
            String[] fileDataArray;
            try {
                fileDataArray = Files.readAllLines(file.toPath()).toString()
                        .replaceAll("[^a-z ^A-Z]", "").split(" ");
            } catch (IOException e) {
                throw new RuntimeException("Can`t read file and list data.", e);
            }
            String[] filteredArray;
            for (String data : fileDataArray) {
                if (data.toLowerCase().toCharArray()[0] == 'w') {
                    buffer.append(data.toLowerCase()).append(" ");
                }
            }
            if (buffer.toString().length() > 0) {
                filteredArray = buffer.toString().split(" ");
                Arrays.sort(filteredArray);
                return filteredArray;
            }
        }
        return new String[]{};
    }
}

