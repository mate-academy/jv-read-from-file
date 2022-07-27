package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Stream<String> stream;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            stream = bufferedReader.lines()
                    .flatMap(str -> Arrays.stream(str.split(" ")))
                    .map(String::toLowerCase)
                    .filter(string -> string.startsWith("w"))
                    .map(str -> str.replaceAll("\\W",""))
                    .sorted();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stream.toArray(String[]::new);
    }
}
