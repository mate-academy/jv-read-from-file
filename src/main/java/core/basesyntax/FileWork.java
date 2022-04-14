package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final char START_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        String fileString = readFile(fileName);
        if (!fileString.equals("")) {
            String[] words = splitFileString(fileString);
            StringBuilder builder = new StringBuilder();
            for (String word : words) {
                if (startWithLetter(word)) {
                    builder.append(word).append(" ");
                }
            }
            if (builder.toString().length() != 0) {
                String[] resultArray = builder.toString().split(" ");
                return sortArray(resultArray);
            }
        }
        return new String[]{};
    }
    
    public String[] sortArray(String[] resultArray) {
        List<String> arrayList = Arrays.asList(resultArray);
        arrayList.sort(Comparator.naturalOrder());
        String[] array = new String[arrayList.size()];
        arrayList.toArray(array);
        return array;
    }

    public String readFile(String fileName) {
        File file = new File(fileName);
        String string;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            string = bufferedReader.readLine();
            while (string != null) {
                builder.append(string).append(System.lineSeparator());
                string = bufferedReader.readLine();
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public String[] splitFileString(String fileString) {
        fileString = fileString.toLowerCase();
        return fileString.split("\\W+");
    }

    public boolean startWithLetter(String word) {
        char[] wordChars = word.toCharArray();
        return wordChars[0] == START_LETTER;
    }
}
