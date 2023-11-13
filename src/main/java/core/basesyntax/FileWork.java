package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {

    private static final String TOKEN_FIRST_CHARACTER = "w";

    private static final String TOKEN_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        String fileContent;

        try {
            fileContent = new String(Files.readAllBytes(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return Arrays.stream(fileContent.toLowerCase().split(System.lineSeparator()))
                .flatMap(line -> Arrays.stream(line.split(TOKEN_SEPARATOR)))
                .filter(token -> token.startsWith(TOKEN_FIRST_CHARACTER))
                .map(filteredToken -> filteredToken.replaceAll("\\W", ""))
                .sorted()
                .toArray(String[]::new);
    }
}
