package core.basesyntax;

import java.io.IOException;

public class FileWork {
  public String[] readFromFile(String fileName) {

        Reader readerFile = new Reader();
        CreateArr createdArr = new CreateArr();
        try {
            return createdArr.createArr(readerFile.reader(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
