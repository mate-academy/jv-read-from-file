package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            StringBuilder preAnswer = new StringBuilder();
            StringBuilder builder = new StringBuilder();
            if (value == -1) {
                String[] emptyArray = {};
                return emptyArray;
            }
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            String[] words = builder
                    .toString()
                    .toLowerCase()
                    .replaceAll("[!\"#$%&'()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~]", "")
                    .replaceAll("[\n\r]", " ")
                    .split(" ");
            for (String word : words) {
                char firstChar = word.charAt(0);
                if (firstChar == 'w') {
                    preAnswer.append(word).append(" ");
                }
            }
            String[] answer = preAnswer.toString().split(" ");
            Arrays.sort(answer);
            if (answer.length == 1) {
                String[] emptyArray = {};
                return emptyArray;
            }
            return answer;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
