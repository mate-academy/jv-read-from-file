package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        //write your code here

        File file = new File(fileName);

        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());

            String string = strings.toString().toLowerCase();
            String[] strings1 = string.split("\\W+");
            Arrays.sort(strings1);
            if (strings1.length == 0) {
                return new String[0];
            }
            for (int i = 1; i < strings1.length; i++) {
                if (strings1[i].charAt(0) == 'w') {
                    stringBuilder.append(strings1[i]).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String result = stringBuilder.toString();
        if (result.length() == 0) {
            return new String[0];
        }
        return result.split(" ");
    }
}
