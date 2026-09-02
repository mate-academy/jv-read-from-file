package core.basesyntax;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        System.out.println(Arrays.toString(fileWork.readFromFile("test2")));
    }
}
