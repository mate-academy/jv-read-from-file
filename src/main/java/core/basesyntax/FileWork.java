package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "w+.*";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            String reader = String.valueOf(Files.readAllLines(file.toPath()));
            int length = 0;
            for (String s: reader.split("\\W")) {
                if (s.toLowerCase().matches((REGEX))) {
                    System.out.println(s);
                    length++;
                }
            }
            String[] result = new String[length];
            return getWordsStartedW(reader, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getWordsStartedW(String value, String[] array) {
        int count = 0;
        for (String strings : value.split("\\W")) {
            if (strings.toLowerCase().matches(REGEX)) {
                array[count] = strings.toLowerCase();
                count++;
            }
        }
        Arrays.sort(array);
        return array;
    }
}
