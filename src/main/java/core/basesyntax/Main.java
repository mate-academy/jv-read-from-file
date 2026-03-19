package core.basesyntax;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FileMateAcademy fileMateAcademy = new FileMateAcademy();

        File file = fileMateAcademy.createNewFile();
        fileMateAcademy.writeToFile(file.getPath());

        FileWork fileWork = new FileWork();

        String[] result = fileWork.readFromFile(file.getPath());
        System.out.println(Arrays.toString(result));
    }
}
