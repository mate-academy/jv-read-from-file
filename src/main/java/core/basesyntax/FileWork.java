package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_LETTER = "w";
    private String[] resultArrOfWords = {};
    private String[] emptyArr = new String[0];
    private String[] splitArr;
    private String lowerStrOfWords;
    private String value;
    private String firstLetter;
    private String resultStrOfWords;
    private StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if (file.exists() && file.length() != 0) {
                value = reader.readLine();
                lowerStrOfWords = value.toLowerCase();
                splitArr = lowerStrOfWords.split("\\W+");
                for (String words : splitArr) {
                    firstLetter = String.valueOf(words.charAt(0));
                    if (firstLetter.equals(SPECIAL_LETTER)) {
                        builder.append(words).append(" ");
                    } else {
                        return emptyArr;
                    }
                }
                resultStrOfWords = builder.toString();
                resultArrOfWords = resultStrOfWords.split(" ");
                Arrays.sort(resultArrOfWords);
                return resultArrOfWords;
            } else {
                return emptyArr;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
