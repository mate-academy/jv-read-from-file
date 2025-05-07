package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String[] textInArrayFromFile = getTextFromFile(fileName).split("\\W+");
        int countOfW = 0;
        StringBuilder strBuild = new StringBuilder();

        for (int i = 0; i < textInArrayFromFile.length; i++) {
            char[] word = textInArrayFromFile[i].toCharArray();

            if (word.length > 0 && Character.toLowerCase(word[0]) == 'w') {
                countOfW++;
                if (strBuild.length() > 0) {
                    strBuild.append(", ");
                }
                strBuild.append(new String(word).toLowerCase());
            }
        }

        if (countOfW == 0) {
            return new String[0];
        }

        return toArrayWithWAndSorting(strBuild.toString(), countOfW);
    }

    public String getTextFromFile(String fileName) {
        StringBuilder strBuild = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String value = reader.readLine();
            while (value != null) {
                strBuild.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        return strBuild.toString();
    }

    public String[] toArrayWithWAndSorting(String textWithSpace, int size) {
        //String[] resultArray = new String[size];
        String[] resultArray = textWithSpace.split(", ");

        Arrays.sort(resultArray);
        return resultArray;
    }
}
