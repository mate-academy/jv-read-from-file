package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        getResult(result,getBufferedReader(fileName));

        return result.toArray(String[]::new);
    }

    private BufferedReader getBufferedReader(String file) {
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return bufferedReader;
    }

    private List getResult(List result, BufferedReader bufferedReader) {
        String line;
        try {

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.toLowerCase().split("[\\p{Punct}\\s]+");
                for (String wordArray : array) {
                    if (wordArray.startsWith("w")) {
                        result.add(wordArray);
                    }
                }
            }
            Collections.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return result;
    }
}

