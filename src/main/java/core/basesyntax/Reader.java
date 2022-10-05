package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String reader(String fileName) throws IOException {
        File newFile = new File(fileName);
        try {
            BufferedReader readerFirstFile = new BufferedReader(new FileReader(newFile));
            StringBuilder stringBuilder = new StringBuilder();
            int value = readerFirstFile.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = readerFirstFile.read();
            }
            return stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
