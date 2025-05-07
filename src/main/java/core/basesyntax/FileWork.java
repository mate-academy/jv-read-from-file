package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARARCTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            if (strings.size() == 0) {
                return new String[]{};
            }
            for (int i = 0; i < strings.size(); i++) {
                String[] s = strings.get(i).split(" ");
                for (int j = 0;j < s.length;j++) {
                    s[j] = s[j].toLowerCase();
                    if (startsWithSpecifiedCharacter(s[j])) {
                        stringBuilder.append(s[j].replaceAll("[^a-zA-Z0-9]","")).append(" ");
                    }
                }
            }
            if (stringBuilder.toString().length() == 0) {
                return new String[]{};
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file ", e);
        }
        return Arrays.stream(stringBuilder.toString().trim().split(" "))
                .sorted()
                .toArray(String[]::new);
    }

    public boolean startsWithSpecifiedCharacter(String word) {
        return word.startsWith(SPECIFIED_CHARARCTER);
    }
}
