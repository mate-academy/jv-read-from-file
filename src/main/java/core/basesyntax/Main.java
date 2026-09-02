package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile("test4");
        // Wyświetlenie wyników
        if (result.length == 0) {
            System.out.println("No words found starting with 'w'.");
        } else {
            System.out.println("Filtered words: " + Arrays.toString(result));
        }
    }
}
