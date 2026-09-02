package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork filework = new FileWork();
        String[] result = filework.readFromFile("File.txt");
        System.out.println(Arrays.toString(result));
    }
}
