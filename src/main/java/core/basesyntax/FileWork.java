package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            FileReader fileReader = new FileReader(fileName);
            String[] separated = fileReader.read();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + e);
        }
        return null;
    }
    public boolean startWithLetterW(String word) {
        return true;
    }
}
