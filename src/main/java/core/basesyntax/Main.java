package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] filtredArry = fileWork.readFromFile("test1");
        System.out.println(Arrays.toString(filtredArry));

    }
}
