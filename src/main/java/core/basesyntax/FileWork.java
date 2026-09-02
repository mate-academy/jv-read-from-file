package core.basesyntax;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        String lower = word.toLowerCase();
                        if (lower.charAt(0) == 'w') {
                            result.add(lower);
                        }
                    }
                }
            }

        } catch (Exception e) {
            return new String[0];
        }

        Collections.sort(result);
        return result.toArray(new String[0]);

    }
}
