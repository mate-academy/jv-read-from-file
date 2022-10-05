package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        Reader reader = new Reader();
        System.out.println(Arrays.toString(fileWork.readFromFile("test4")));
    }
}
