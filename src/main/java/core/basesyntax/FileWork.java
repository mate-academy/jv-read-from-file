package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> strings;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String string : strings) {
            String[] split = string.split("\\W+");
            for (String s : split) {
                String lowerCase = s.toLowerCase();
                if (lowerCase.charAt(0) == 119) {
                    stringBuilder.append(lowerCase).append(" ");
                }
            }
        }

        String[] split = {};
        if (!stringBuilder.isEmpty()) {
            split = stringBuilder.toString().split(" ");
            Arrays.sort(split);
        }

        return split;
    }
}
