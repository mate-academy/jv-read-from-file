package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(Paths.get(fileName)),
                        StandardCharsets.UTF_8))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

        } catch (IOException e) {
            return new String[0];
        }

        String text = content.toString();

        if (text.isEmpty()) {
            return new String[0];
        }

        String[] tokens = text.split("[\\s\\W]+");

        List<String> result = new ArrayList<>();

        for (String word : tokens) {
            if (!word.isEmpty()
                    && Character.toLowerCase(word.charAt(0)) == 'w') {
                result.add(word.toLowerCase());
            }
        }

        Collections.sort(result);

        return result.isEmpty()
                ? new String[0]
                : result.toArray(new String[0]);
    }
}
