package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final char LOWER_CASE = 'w';
    private static final char UPPER_CASE = 'W';

    public String[] readFromFile(String fileName) {
        int countStartW = 0;
        int wordIndex = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] matchLines = value.split("\\W+");
                for (String word : matchLines) {
                    if (!word.isEmpty() && (word.charAt(0) == LOWER_CASE
                            || word.charAt(0) == UPPER_CASE)) {
                        countStartW++;
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + fileName + " not found " + e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName + " " + e);
        }

        String[] suitWords = new String[countStartW];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] matchLines = value.split("\\W+");
                for (String word : matchLines) {
                    if (!word.isEmpty() && (word.charAt(0) == LOWER_CASE
                            || word.charAt(0) == UPPER_CASE)) {
                        suitWords[wordIndex] = word.toLowerCase();
                        wordIndex++;
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + fileName + " not found " + e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName + " " + e);
        }

        for (int i = 0; i < suitWords.length; i++) {
            for (int j = i + 1; j < suitWords.length; j++) {
                if (suitWords[i].compareTo(suitWords[j]) > 0) {
                    String swap = suitWords[i];
                    suitWords[i] = suitWords[j];
                    suitWords[j] = swap;
                }
            }
        }

        return suitWords;
    }
}
