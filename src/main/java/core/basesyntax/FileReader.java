package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    private final WordExtractor wordExtractor;

    public FileReader(WordExtractor wordExtractor) {
        this.wordExtractor = wordExtractor;
    }

    public String[] read(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            builder.append(strings);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.");
        }
        return wordExtractor.extract(builder.toString());
    }
}
