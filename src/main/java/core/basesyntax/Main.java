package core.basesyntax;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        File file = new File("test5");
        Path path = file.toPath();
        String fileName = String.valueOf(path);
        String[] words = (String[]) FileWork.readFromFile(fileName);
        for (String word : words) {
            System.out.println(word);
        }
    }
}
