package core.basesyntax;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        FileWork fileWork = new FileWork();
        try {
            fileWork.readFromFile("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }
}
