package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        if (fileName == null || fileName.isEmpty()) {
            return new String[0];
        }

        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(file.toPath());

            for (String line : lines) {
                String[] words = line.replaceAll("\\p{P}", "").split("\\s+");

                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        sb.append(word.toLowerCase()).append(",");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] result = sb.toString().split(",");
        Arrays.sort(result);

        return sb.isEmpty() ? new String[0] : result;
    }
}

