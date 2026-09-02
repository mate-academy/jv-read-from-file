package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("\\p{Punct}", "").toLowerCase();
                if (word.startsWith("w")) {
                    list.add(word);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
        String[] result = list.toArray(list.toArray(new String[]{}));
        Arrays.sort(result);
        return result;
    }
}
