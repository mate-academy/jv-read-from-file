package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder fileContent = new StringBuilder();
        StringBuilder selectedContent = new StringBuilder();

        try {
            if (file.length() != 0) {
                Files.readAllLines(file.toPath()).forEach(line
                        -> fileContent.append(line).append(System.lineSeparator()));
            } else {
                return new String[]{};
            }
        } catch (IOException e) {
            throw new RuntimeException("can`t read file:");
        }
        boolean flag = false;
        String[] arrayWithContent = fileContent.toString().split("\\W+");
        for (String word : arrayWithContent) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                selectedContent.append(word).append(" ");
                flag = true;
            }
        }
        String[] result = selectedContent.toString().toLowerCase().split(" ");
        Arrays.sort(result);
        return flag ? result : new String[]{};
    }
}
