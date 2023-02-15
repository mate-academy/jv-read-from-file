package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() != 0) {
            try {
                List<String> resultlist = new ArrayList<>();
                String result = Files.readAllLines(file.toPath()).toString()
                        .toLowerCase().replaceAll("\\p{Punct}", "");
                String[] words = result.split(" ");
                words = Stream.of(words).sorted().toArray(String[]::new);
                for (int i = 0; i < words.length; i++) {
                    if (words[i].startsWith("w") || words[i].startsWith("W")) {
                        resultlist.add(words[i]);
                    }
                }
                return resultlist.toArray(String[]::new);
            } catch (IOException e) {
                throw new RuntimeException("Can not read file",e);
            }
        } else {
            return new String[0];
        }
    }
}
