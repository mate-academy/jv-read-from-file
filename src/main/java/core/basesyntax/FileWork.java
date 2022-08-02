package core.basesyntax;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            String[] sortedArr = Files
                    .readAllLines(file.toPath())
                    .toString()
                    .toLowerCase(Locale.ROOT)
                    .split("\\W+");
            for (int i = 1; i < sortedArr.length; i++) {
                if (sortedArr[i].charAt(0) == 'w') {
                    builder.append(sortedArr[i]).append(" ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (builder.toString().isEmpty()) {
            return new String[]{};
        } else {
            String[] finalArr = builder.toString().split(" ");
            Arrays.sort(finalArr);
            return finalArr;
        }

    }
}
