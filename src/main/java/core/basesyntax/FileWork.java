package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String line;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            line = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }
        if (line.length() == 0) {
            String[] x = {};
            return x;
        }
        //write your code here
        String[] temp = line.split("\\W+");
        String[] answer;

        String tmpLine = "";
        for (String word:temp) {
            if (word.toLowerCase().charAt(0) == 'w') {
                tmpLine += word.toLowerCase() + " ";
            }
        }
        if (tmpLine.length() == 0) {
            String[] x = {};
            return x;
        }
        answer = tmpLine.split(" ");
        Arrays.sort(answer);
        return answer;
    }
}
