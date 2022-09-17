package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            String readString = bufferedReader.readLine();
            while (readString != null) {
                String[] as = readString.toLowerCase().trim().replaceAll("[^A-Za-zА,-]", " ").trim().split(" ");
                for (String asd : as) {
                    if (asd.indexOf("w") == 0) {
                        stringBuilder.append(asd + " ");
                    }
                }
                readString = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("don't directory file");
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(" ");
        }
        String[] qwe = String.valueOf(stringBuilder).split(" ");
        Arrays.sort(qwe);
        return qwe;
    }
}

