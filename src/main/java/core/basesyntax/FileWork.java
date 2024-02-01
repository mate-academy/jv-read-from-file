package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();

            if (value == -1) {
                return new String[0];
            }

            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }

            String sentence = stringBuilder.toString();
            String[] splitSentence = sentence.split("\\W+");
            int j = 0;
            for (int i = 0; i < splitSentence.length; i++) {
                if (splitSentence[i].toLowerCase().charAt(0) == 'w') {
                    j++;
                }
            }

            String[] resul = new String[j];
            int k = 0;
            for (int i = 0; i < splitSentence.length; i++) {
                if (splitSentence[i].toLowerCase().charAt(0) == 'w') {
                    resul[k] = splitSentence[i].toLowerCase();
                    k++;
                }
            }

            Arrays.sort(resul);
            return resul;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
