package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        System.out.println(Arrays.toString(fileWork.readFromFile("mytest1510.txt")));
    }
}
