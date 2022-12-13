package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {

    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try {
            builder.append(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String[] separatedFileTxt = builder.toString().toLowerCase().split("\\W+");
        String[] answer = new String[separatedFileTxt.length];
        int counter = 0;
        for (String word : separatedFileTxt) {
            if (word.startsWith(FIRST_LETTER)) {
                answer[counter] = word;
                counter++;
            }
        }

        if (answer == null) {
            return new String[0];
        }
        Arrays.sort(answer);
        //write your code here
        return answer;
    }
}
