package core.basesyntax;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_LETTER = "w";
    private final String[] emptyArr = new String[0];
    private final StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if (file.exists() && file.length() != 0) {
                String value = reader.readLine();
                String lowerStrOfWords = value.toLowerCase();
                String[] splitArr = lowerStrOfWords.split("\\W+");
                for (String words : splitArr) {
                    String firstLetter = String.valueOf(words.charAt(0));
                    if (firstLetter.equals(SPECIAL_LETTER)) {
                        builder.append(words).append(" ");
                    } else {
                        return emptyArr;
                    }
                }
                String resultStrOfWords = builder.toString();
                String[] resultArrOfWords = resultStrOfWords.split(" ");
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
