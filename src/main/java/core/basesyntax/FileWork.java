package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIC_FILTER_CHAR = 'w';
    private static final String CHARACTER_FILTER = "[^a-z ^A-Z]";
    private static final String SPLITTER = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() > 0) {
            StringBuilder buffer = new StringBuilder();
            String[] fileDataArray;
            try {
                fileDataArray = Files.readAllLines(file.toPath()).toString()
                        .replaceAll(CHARACTER_FILTER, "").split(SPLITTER);
            } catch (IOException e) {
                throw new RuntimeException("Can`t read file" + fileName + "and list data.", e);
            }
            String[] filteredArray;
            for (String data : fileDataArray) {
                if (data.toLowerCase().toCharArray()[0] == SPECIFIC_FILTER_CHAR) {
                    buffer.append(data.toLowerCase()).append(" ");
                }
            }
            if (buffer.toString().length() > 0) {
                filteredArray = buffer.toString().split(SPLITTER);
                Arrays.sort(filteredArray);
                return filteredArray;
            }
        }
        return new String[]{};
    }
}

