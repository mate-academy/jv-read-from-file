package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String text = null;

        try {
            text = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            return new String[0];
        }

        text = text.toLowerCase(Locale.ROOT);

        String[] token = text.split("[^A-Za-z0-9]+");

        int count = 0;

        for (String tokens : token) {
            if (tokens.isEmpty()) {
                continue;
            }

            if (tokens.startsWith("w")) {
                count++;
            }
        }

        String[] answer = new String[count];

        int index = 0;

        for (String tokens : token) {
            if (tokens.isEmpty()) {
                continue;
            }

            if (tokens.startsWith("w")) {
                answer[index++] = tokens;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
