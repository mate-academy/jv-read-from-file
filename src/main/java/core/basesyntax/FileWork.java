package core.basesyntax;

import java.io.*;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int counter = 1;
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        String[] sortedWords = new String[counter];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while (value != null) {
                value = reader.readLine();
                stringBuilder.append(value).append(System.lineSeparator());
            }
            String wordsFromFile = stringBuilder.toString();
            String[] splitted = wordsFromFile.split("\\W+");
            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].charAt(0) == 'w') {
                    counter = counter + 1;
                    for (int j = 0; j < sortedWords.length; j++) {
                        sortedWords[j] = splitted[i];
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return  sortedWords;
    }
}
