package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] val1 = fileWork.readFromFile("./test1");
        System.out.println(Arrays.toString(val1));
        String[] val2 = fileWork.readFromFile("./test2");
        System.out.println(Arrays.toString(val2));
        String[] val3 = fileWork.readFromFile("./test3");
        System.out.println(Arrays.toString(val3));
        String[] val4 = fileWork.readFromFile("./test4");
        System.out.println(Arrays.toString(val4));
        String[] val5 = fileWork.readFromFile("./test5");
        System.out.println(Arrays.toString(val5));
    }
}
