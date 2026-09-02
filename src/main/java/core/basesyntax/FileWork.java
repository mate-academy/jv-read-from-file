package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileWork implements Comparator<String> {

    private ArrayList<String> arrayString;

    public String[] readFromFile(String fileName) {
        arrayString = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitedWords = line.split(" ");

                for (String word : splitedWords) {
                    String stringWithoutPunctuation = word.replaceAll("\\p{Punct}", "");
                    String loweredCaseString = stringWithoutPunctuation.toLowerCase();
                    if (!loweredCaseString.isEmpty()
                            && loweredCaseString.startsWith("w")) {
                        arrayString.add(loweredCaseString);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: ", e);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred: ", e);
        }

        Collections.sort(arrayString, new FileWork());

        return arrayString.toArray(new String[arrayString.size()]);
    }

    @Override
    public int compare(String s1, String s2) {
        char secondLetter1 = s1.charAt(1);
        char secondLetter2 = s2.charAt(1);

        if (secondLetter1 != secondLetter2) {
            return Character.compare(secondLetter1, secondLetter2);
        } else {
            return s1.compareTo(s2);
        }
    }
}
