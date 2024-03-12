package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String stringFromFile = builder.toString().toLowerCase().replace("\n"," ");

        String[] stringTableFromFile = stringFromFile.split(" ");

        int counter = 0;

        for (int i = 0; i < stringTableFromFile.length; i++) {
            if (stringTableFromFile[i].startsWith("w")) {
                counter++;
            }
        }

        String[] finalString = new String[counter];
        int finalStringCounter = 0;
        for (int i = 0; i < stringTableFromFile.length; i++) {
            String temporary = stringTableFromFile[i].trim();
            if (temporary.startsWith("w")) {
                if (temporary.endsWith("!")
                        || temporary.endsWith("?")
                        || temporary.endsWith(".")) {
                    finalString[finalStringCounter++] = temporary.substring(0, temporary.length() - 1);
                } else {
                    finalString[finalStringCounter++] = temporary;
                }
            }
        }
        Arrays.sort(finalString);
        return finalString;
    }
}
