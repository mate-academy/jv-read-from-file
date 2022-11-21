package core.basesyntax;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String fileName = "test1";
        String[] array = fileWork.readFromFile(fileName);
        System.out.println(Arrays.toString(array));
    }
}
