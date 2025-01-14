package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile("test.txt");
        System.out.println(Arrays.toString(result));
    }
}
