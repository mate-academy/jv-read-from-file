package core.basesyntax;

import java.util.Arrays;

public class TestProgram {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        for (int i = 1; i <= 5; i++) {
            System.out.println(Arrays.toString(fileWork.readFromFile("test" + i)));
        }
    }
}
