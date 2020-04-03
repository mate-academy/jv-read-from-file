package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public static final String START_LETTER = "w";

    String[] readFromFile(String fileName) {

        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                String[] words = nextLine.split(" ");
                for (String s : words) {
                    if (s.toLowerCase().startsWith(START_LETTER)) {
                        result.append(s.toLowerCase().replaceAll("\\W", "")
                                + " ");
                    }
                }
            }
            String[] resultSt = result.toString().split(" ");
            if (resultSt[0].equals("")) {
                return new String[0];
            }
            Arrays.sort(resultSt);
            return resultSt;
        } catch (IOException e) {
            throw new RuntimeException("File not found! " + e);
        }
    }
}

