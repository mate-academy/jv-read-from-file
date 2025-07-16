package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        fileWork.readFromFile("C:\\projects\\jv-read-from-file\\test2");
        System.out.println(Arrays.toString(
                fileWork.readFromFile("C:\\projects\\jv-read-from-file\\test2")));
    }
}
