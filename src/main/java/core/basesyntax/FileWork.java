package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private static final String ERROR_MSG = "Can't read from file.";
    private static final String REGEX_TO_SPLIT = "[^a-zA-Z]";
    private List<String[]> stringArraysList;
    private File file;
    private String[] finalSortedArray;
    private String[] filteredWords;

    public String[] readFromFile(String fileName) {
        stringArraysList = new ArrayList<>();
        file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                filteredWords = filterByLetter(value.split(REGEX_TO_SPLIT));
                stringArraysList.add(filteredWords);
                value = reader.readLine();
            }

            finalSortedArray = concatenateArrays(stringArraysList);
            Arrays.sort(finalSortedArray);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MSG + e);
        }

        return finalSortedArray.length != 0 ? finalSortedArray : new String[]{};
    }

    private String[] filterByLetter(String[] wordsArray) {
        List<String> wordsWithStartLetter = new ArrayList<>();

        for (String word : wordsArray) {
            if (!word.isEmpty() && (word.toLowerCase().startsWith("w"))) {
                wordsWithStartLetter.add(word.toLowerCase());
            }
        }
        return wordsWithStartLetter.toArray(new String[]{});
    }

    private String[] concatenateArrays(List<String[]> arraysList) {
        List<String> resultList = new ArrayList<>();

        for (String[] array : arraysList) {
            resultList.addAll(Arrays.asList(array));
        }
        return resultList.toArray(new String[0]);
    }
}
