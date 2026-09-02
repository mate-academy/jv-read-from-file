package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork parser = new FileWork();
        String[] words = parser.readFromFile("input.txt");
        System.out.println(Arrays.toString(words));
    }
}
