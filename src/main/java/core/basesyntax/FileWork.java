package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String fileSepar = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            if (stringBuilder.length() == 0) {
                return new String[]{};
            }
            fileSepar = stringBuilder.toString();

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        int count = 0;
        String fileNameLowerCase = fileSepar.toLowerCase();
        String[] stringList1 = fileNameLowerCase.split("\\W+");
        for (String word : stringList1) {
            char[] x = word.toCharArray();
            if (x[0] == 'w') {
                count++;
            }
        }
        String[] stringList = new String[count];
        int j = 0;
        for (int i = 0; i < stringList1.length; i++) {
            char[] x = stringList1[i].toCharArray();
            if (x[0] == 'w') {
                stringList[j] = stringList1[i];
                j++;
            }
        }
        Arrays.sort(stringList);
        return stringList;
    }
}
