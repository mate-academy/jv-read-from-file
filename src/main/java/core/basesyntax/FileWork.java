package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Can't read file", e);
            }
        }
        String[] readFile = stringBuilder.toString().toLowerCase().split("\\W+");
        int amountWorld = 0;
        String[] worldSpecifiedCharacter = new String[0];
        for (int i = 0; i < readFile.length; i++) {
            if (readFile[i].startsWith(SPECIFIED_CHARACTER)) {
                amountWorld++;
            }
        }
        worldSpecifiedCharacter = new String[amountWorld];
        int i = -1;
        for (int j = 0; j < readFile.length; j++) {
            if (readFile[j].startsWith(SPECIFIED_CHARACTER)) {
                i++;
                worldSpecifiedCharacter[i] = readFile[j];
            }
        }
        Arrays.sort(worldSpecifiedCharacter);
        return worldSpecifiedCharacter;
    }
}
