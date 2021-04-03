package core.basesyntax;

import java.util.Arrays;

public class Main {
    private static final String SECOND_FILE_NAME = "test2";

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        System.out.println(Arrays.toString(fileWork.readFromFile(SECOND_FILE_NAME)));
    }
}
