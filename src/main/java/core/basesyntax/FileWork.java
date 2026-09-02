package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    private StringBuilder inputText = new StringBuilder();
    private String inputString = "";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            inputString = bufferedReader.readLine();
            while (inputString != null) {
                inputText.append(inputString).append(" ");
                inputString = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] words = inputText.toString().split(" ");
        int wordsCount = 0;
        for (int i = 0; i < words.length; i++) {
            wordsCount = Pattern.matches("[wW].*", words[i]) ? wordsCount + 1 : wordsCount;
        }
        String[] res = new String[wordsCount];
        for (int i = 0, j = 0; i < words.length; i++) {
            if (Pattern.matches("[wW].*", words[i])) {
                res[j] = words[i].replaceAll("\\W+", "").toLowerCase();
                j++;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
