package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileWork {
    private static final String LOOKING_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String dataFromFile = "";
        Path path = Paths.get(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        dataFromFile = stringBuilder.toString().replaceAll("[!\\.,?]", "");
        Stream<String> streamOfString = Pattern.compile(" ").splitAsStream(dataFromFile);
        return streamOfString
                .map(String::toLowerCase)
                .filter(word -> word.startsWith(LOOKING_CHARACTER))
                .sorted()
                .toArray(size -> new String[size]);
    }
}
