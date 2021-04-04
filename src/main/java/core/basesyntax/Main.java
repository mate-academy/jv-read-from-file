package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can`t create file" + file, e);
        }
        FileWork testFile = new FileWork();
        System.out.println(Arrays.toString(testFile.readFromFile(file.getPath())));
    }
}
