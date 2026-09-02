package core.basesyntax;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");

        FileWork wordFilter = new FileWork();
        String fileName = file.getPath();
        String[] filteredWords = wordFilter.readFromFile(fileName);

        for (String word : filteredWords) {
            System.out.println(word);
        }
    }
}
