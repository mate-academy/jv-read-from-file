package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            builder.append(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] value = builder.toString().toLowerCase().split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: value) {
            if (s.startsWith("w")) {
                stringBuilder.append(s).append(" ");
            }
        }
        String qwer = stringBuilder.toString();
        if (qwer.length() == 0) {
            return new String[0];
        }
        String[] qwe = qwer.split(" ");
        Arrays.sort(qwe);
        return qwe;
    }
}
