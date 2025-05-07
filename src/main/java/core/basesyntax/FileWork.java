package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String W_WORDS = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String strings;
        String wordInLowerCase;
        ArrayList<String> resultArrList = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String eachString = reader.readLine();
            if (eachString == null) {
                return new String[]{};
            }
            while (eachString != null) {
                builder.append(eachString).append(System.lineSeparator());
                eachString = reader.readLine();
            }
            strings = builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("File Not found! ", e);
        }
        String[] eachStringWord = strings.split("\\W+");
        for (String words : eachStringWord) {
            wordInLowerCase = words.toLowerCase();

            if (wordInLowerCase.startsWith(W_WORDS)) {
                resultArrList.add(wordInLowerCase);
            }
        }
        String[] result = resultArrList.toArray(new String[resultArrList.size()]);
        Arrays.sort(result);
        return result;
    }
}
