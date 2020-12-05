package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> stringList = Files.readAllLines(file.toPath());
            if (stringList.size() == 0) {
                return new String[0];
            }
            for (String string: stringList) {
                String[] words = string.split(" ");
                for (String word : words) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word.toLowerCase().replaceAll("[^a-z]", ""))
                                .append(" ");
                    }
                }
            }
            if (stringBuilder.toString().isEmpty()) {
                return new String[0];
            }
            String[] sortableStrings = stringBuilder.toString().split(" ");
            ArrayList<String> sortingList = new ArrayList<>(Arrays.asList(sortableStrings));
            Collections.sort(sortingList);
            String[] result = new String[sortingList.size()];
            return sortingList.toArray(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
