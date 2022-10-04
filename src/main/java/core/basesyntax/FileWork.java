package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[]{};
        }
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        String inPutString = builder.toString();
        String[] splitSentense = inPutString.split("\\W+");
        int count = 0;
        for (int i = 0; i < splitSentense.length; i++) {
            String[] words = splitSentense[i].split("");
            if (words[0].equals("W") || words[0].equals("w")) {
                count = count + 1;
            }
        }
        String[] outPutMass = new String[count];
        int h = 0;
        for (int a = 0; a < splitSentense.length; a++) {
            String[] words = splitSentense[a].split("");
            if (words[0].equals("W") || words[0].equals("w")) {
                outPutMass[h] = splitSentense[a];
                h = h + 1;
            }
        }
        for (int g = 0; g < outPutMass.length; g++) {
            outPutMass[g] = outPutMass[g].toLowerCase();
        }
        Arrays.sort(outPutMass);
        return outPutMass;
    }
}
