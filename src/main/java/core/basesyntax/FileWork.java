package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> fileStrings;
        try {
            fileStrings = Files.readAllLines(Path.of(fileName));
            System.out.println(fileStrings);
        } catch (IOException e) {
            throw new RuntimeException("Could not read strings from file",e);
        }

        StringBuilder parsedString = new StringBuilder();
        for (String separateString : fileStrings) {
            for (String separateWord : separateString.split("\\W+")) {
                if (separateWord.startsWith("W") || separateWord.startsWith("w")) {
                    parsedString.append(separateWord.toLowerCase()).append(" ");
                }
            }
        }

        if (parsedString.length() == 0) {
            return new String[0];
        }

        String[] returningString = parsedString.toString().split(" ");
        Arrays.sort(returningString);
        return returningString;
    }
}
