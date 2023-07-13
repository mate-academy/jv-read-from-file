package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String fileContent = getStringFromFile(fileName);
        String filterResultString;

        if (fileContent.length() == 0) {
            return new String[0];
        }

        filterResultString = filterContent(fileContent);

        if (filterResultString.length() == 0) {
            return new String[0];
        }

        String[] filterResultArray = filterResultString.split(" ");
        Arrays.sort(filterResultArray);

        return filterResultArray;
    }

    private String getStringFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file, ", e);
        }

        return stringBuilder.toString();
    }

    private String filterContent(String fileContent) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splits = fileContent.split("\\W+");

        for (String split : splits) {
            String lowerCaseSplit = split.toLowerCase();

            if (lowerCaseSplit.charAt(0) == 'w') {
                stringBuilder.append(lowerCaseSplit).append(" ");
            }
        }

        return stringBuilder.toString();
    }

}
