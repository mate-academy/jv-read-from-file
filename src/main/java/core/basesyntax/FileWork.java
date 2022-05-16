package core.basesyntax;

import java.util.Arrays;

public class FileWork {
    public static void main(String[] args) {
        FileWork data = new FileWork();
        System.out.println("Output array of strings: "
                + Arrays.toString(data.readFromFile("test2")));
    }

    public String[] readFromFile(String fileName) {
        String data = new ReadDataFromFile().readFromFile(fileName);
        return new ProcessData().processData(data);
    }
}
