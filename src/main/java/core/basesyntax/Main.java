package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();

        String[] result1 = fileWork.readFromFile("test1");
        System.out.println("test1: " + Arrays.toString(result1));

        String[] result2 = fileWork.readFromFile("test2");
        System.out.println("test2: " + Arrays.toString(result2));

        String[] result3 = fileWork.readFromFile("test3");
        System.out.println("test3: " + Arrays.toString(result3));

        String[] result4 = fileWork.readFromFile("test4");
        System.out.println("test4: " + Arrays.toString(result4));

        String[] result5 = fileWork.readFromFile("test5");
        System.out.println("test5: " + Arrays.toString(result5));
    }
}
