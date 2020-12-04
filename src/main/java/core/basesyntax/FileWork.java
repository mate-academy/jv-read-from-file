package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private String[] margeArrays(String[] firstArray, String[] secondArray) {
        String[] buffer = new String[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, buffer, 0, firstArray.length);
        System.arraycopy(secondArray, 0, buffer, firstArray.length, secondArray.length);
        return buffer;
    }

    public String[] readFromFile(String fileName) {
        File fileToRead = new File(fileName);
        List<String> readData = null;
        if (fileToRead.exists()) {
            try {
                readData = Files.readAllLines(fileToRead.toPath());
            } catch (IOException e) {
                throw new RuntimeException("I wasn't able to read the file", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String line : readData) {
            sb.append(line).append(" ");
        }
        String[] finalArray = sb.toString().trim().toLowerCase()
                .replaceAll("[^ a-zA-Z]", "").split(" ");
        return Arrays.stream(finalArray).sorted().filter(i -> i.startsWith("w")).toArray(String[]::new);
    }
}
