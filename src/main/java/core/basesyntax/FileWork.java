package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder constructionBuilder = new StringBuilder();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file", e);
        }

        String fileString = stringBuilder.toString();
        String[] allWordsArray = fileString.split("\\W+");
        for (String s : allWordsArray) {
            if (s.equals("")) {
                s = " ";
            }

            if (s.charAt(0) == 'w' || s.charAt(0) == 'W') {
                constructionBuilder.append(s.toLowerCase()).append(" ");
            } else {
                continue;
            }
        }

        String[] done = constructionBuilder.toString().split(" ");
        if (done.length == 1) {
            return new String[0];
        }

        Collator collatorMy = Collator.getInstance();
        Arrays.sort(done, collatorMy::compare);
        return done;
    }

}
