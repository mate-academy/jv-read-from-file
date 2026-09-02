package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String fileName = "test5";

        String[] wordsStartingWithW = fileWork.readFromFile(fileName);

        if (wordsStartingWithW.length > 0) {
            System.out.println("Words starting with 'w' and sorted alphabetically:");
            System.out.println(Arrays.toString(wordsStartingWithW));
        } else {
            System.out.println("There are no words in the file that start with 'w'.");
        }
    }
}
