package core.basesyntax;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FileWork fileWork = new FileWork();
        CreateArr createdArr = new CreateArr();


        System.out.println(fileWork.readFromFile("test4"));
    }
}
