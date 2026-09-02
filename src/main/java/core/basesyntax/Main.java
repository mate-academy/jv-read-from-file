package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileWork fileWork = new FileWork();
        System.out.println(Arrays.toString(fileWork.readFromFile("example.txt")));

    }
}
