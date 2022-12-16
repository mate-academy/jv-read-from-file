package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_LETTER = "w";
    private String[] emptyArr = new String[0];
    private StringBuilder builder = new StringBuilder();
    private StringBuilder builderResult = new StringBuilder();
    private int count = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            if (value == null) {
                return emptyArr;
            } else {
                while (value != null) {
                    builder.append(value).append(":");
                    value = reader.readLine();
                }
            }
            String lowerStrOfWords = builder.toString();
            lowerStrOfWords = lowerStrOfWords.toLowerCase();
            String[] splitArr = lowerStrOfWords.split("\\W+");
            for (String words : splitArr) {
                String firstLetter = String.valueOf(words.charAt(0));
                if (firstLetter.equals(SPECIAL_LETTER)) {
                    builderResult.append(words).append(" ");
                    count++;
                }
            }
            if (count == 0) {
                return emptyArr;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String resultStrOfWords = builderResult.toString();
        String[] resultArrOfWords = resultStrOfWords.split(" ");
        Arrays.sort(resultArrOfWords);
        return resultArrOfWords;
    }
}
