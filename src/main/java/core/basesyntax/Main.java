package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "test.txt";
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile(fileName);
        System.out.println(Arrays.toString(result));
    }
}
