package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String text = "";
        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        text = text.toLowerCase();
        ArrayList<String> textWithoutPunctuation =
                new ArrayList<>(Arrays.asList(text.split("\\W+")));
        for (int i = 0; i < textWithoutPunctuation.size(); i++) {
            if (textWithoutPunctuation.get(i).charAt(0) != 'w') {
                textWithoutPunctuation.remove(i);
                i--;
            }
        }
        String[] answer = textWithoutPunctuation.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
     }
}
