package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String CUSTOM_REGEX = "[\\n\\r\\p{P}]";
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();
        try {
            String data = Files.readString(file.toPath()).replaceAll(CUSTOM_REGEX, WHITESPACE);
            for (String wordFromData : data.split(WHITESPACE)) {
                if (wordFromData.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    result.add(wordFromData.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
