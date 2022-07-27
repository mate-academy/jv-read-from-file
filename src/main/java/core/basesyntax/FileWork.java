package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_DELETE_CONDITION = "[^a-z]";
    private static final String START_OF_WORD_CHARACTER = "w";
    StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();

            while (value != null) {
                getStringFromArray((value));
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return createArrayForWords();
    }

    private String[] createArrayForWords() {
        String[] checkedWords = new String[0];
        if (stringBuilder.length() > 0) {
            Arrays.sort(checkedWords = stringBuilder.toString().split(" "));
        }
        return checkedWords;
    }

    private void getStringFromArray(String string) {
        for (String wordFromArray : string.split(" ")) {
            if (wordFromArray.toLowerCase().startsWith(START_OF_WORD_CHARACTER)) {
                String resultWordFromArray = wordFromArray.toLowerCase().replaceAll(REGEX_DELETE_CONDITION, "");
                stringBuilder.append(resultWordFromArray).append(" ");
            }
        }
    }


}

