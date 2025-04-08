package core.basesyntax;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileWork {
    public String[] readFromFile(String fileName) {
        String fileContent = "";
        try {
            fileContent = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result of file: ");
        System.out.println(fileContent);

        String[] words = fileContent.split("\\W+");
        System.out.println("Split words: ");
        for (String word : words) {
            System.out.println(word);
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                String lowerCaseWord = word.toLowerCase();
                if (lowerCaseWord.startsWith("w")) {
                    result.add(lowerCaseWord);
                }
            }
        }

        System.out.println("After filtering: ");
        for (String word : result) {
            System.out.println(word);
        }

        Collections.sort(result);
        return result.toArray(new String[0]);

    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile("test1");

        System.out.println("Result: ");
        for (String word : result) {
            System.out.println(word);
        }
    }

}

