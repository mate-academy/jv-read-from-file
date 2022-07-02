package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        String stringToFile = "Width world Wide web";
        File file = new File("test.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(stringToFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
        FileWork fileWork = new FileWork();
        fileWork.readFromFile("test.txt");
    }
}
