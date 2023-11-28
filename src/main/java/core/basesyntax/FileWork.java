package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();

            while (value != null) {
                fileContent.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file to read", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file", e);
        }

        Pattern pattern = Pattern.compile("\\bw\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileContent.toString());

        int size = 0;

        while (matcher.find()) {
            size += 1;
        }

        String[] result = new String[size];

        matcher.reset();
        while (matcher.find()) {
            result[result.length - size] = matcher.group().toLowerCase();
            size -= 1;
        }

        Arrays.sort(result);

        return result;
    }
}
