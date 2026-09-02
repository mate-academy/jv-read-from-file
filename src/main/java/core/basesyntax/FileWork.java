package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder temptStr = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                String [] tempMass = readLine.toLowerCase().split("\\W+");
                for (String mass : tempMass) {
                    if (mass.charAt(0) == SPECIFIED_CHARACTER) {
                        temptStr.append(mass).append(" ");
                    }
                }
                readLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (temptStr.toString().isEmpty()) {
            return new String[0];
        }
        String [] resultStr = temptStr.toString().split(" ");
        for (int i = 0; i <= resultStr.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (resultStr[j].compareTo(resultStr[i]) > 0) {
                    String temp = resultStr[i];
                    resultStr[i] = resultStr[j];
                    resultStr[j] = temp;
                }
            }
        }
        return resultStr;
    }
}

