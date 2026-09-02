package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork wf = new FileWork();

        String[] words = wf.readFromFile("text.txt");

        System.out.println(Arrays.toString(words));
    }
}
