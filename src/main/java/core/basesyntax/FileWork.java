package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String ERROR_MASSAGE = "can't read from ";
    private static final String SPACE = " ";
    private static final String STARTING_LETTER = "w";
    private static final String[] EMPTY_STRING_ARRAY = {};
    private static final int MINIMUM_LENGTH = 1;

    public String[] readFromFile(String fileName) {
        StringBuilder fileText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                fileText.append(line).append(SPACE);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MASSAGE + fileName, e);
        }
        if (checkIfStringIsNotEmpty(fileText.toString())) {
            return EMPTY_STRING_ARRAY;
        }
        String result = getEditedString(fileText);
        if (checkIfStringIsNotEmpty(result)) {
            return EMPTY_STRING_ARRAY;
        }
        String[] arrayResult = result.toString().split(SPACE);
        sortArrayInAlphabeticalOrder(arrayResult);
        return arrayResult;
    }

    private boolean checkIfStringIsNotEmpty(String stringToCheck) {
        return stringToCheck.length() < MINIMUM_LENGTH;
    }

    private String getEditedString(StringBuilder fileText) {
        String[] fullFileText = fileText.toString().toLowerCase().split("\\W+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fullFileText.length; i++) {
            if (fullFileText[i].startsWith(STARTING_LETTER)) {
                result.append(fullFileText[i]).append(SPACE);
            }
        }
        return result.toString();
    }

    private void sortArrayInAlphabeticalOrder(String[] arrayResult) {
        for (int i = 1; i < arrayResult.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayResult[j].compareTo(arrayResult[j - 1]) < 0) {
                    String temp = arrayResult[j];
                    arrayResult[j] = arrayResult[j - 1];
                    arrayResult[j - 1] = temp;
                }
            }
        }
    }
}
