package core.basesyntax;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String letterForSorting = "w";

    public String[] readFromFile(String fileName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String content = bufferedReader.readLine();

            while (content != null) {
                stringBuilder.append(content);
                content = bufferedReader.readLine();
            }
            String inputText = stringBuilder.toString().toLowerCase();

            Pattern pattern = Pattern.compile("[^a-z]+");
            Matcher matcher = pattern.matcher(inputText);
            String result = matcher.replaceAll(" ");

            String[] wordsArray = result.split(" ");
            int count = 0;

            for (String word : wordsArray) {
                if (word.startsWith(letterForSorting)) {
                    count++;
                }
            }

            String[] filteredWords = new String[count];
            int index = 0;

            for (String word : wordsArray) {
                if (word.startsWith("w")) {
                    filteredWords[index++] = word;
                }
            }
            Arrays.sort(filteredWords);
            System.out.println(Arrays.toString(filteredWords));
            return new String[]{Arrays.toString(filteredWords)};
        } catch (Exception e) {
            return new String[0];
        }
    }

}
