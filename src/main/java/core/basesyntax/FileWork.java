package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DEMILITED = " ";
    private static final String PATTERN_FOR_LINE = "\\b[wW]\\w*\\b";

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line = bf.readLine();
            while (line != null) {
                sb.append(getRightWords(line));
                line = bf.readLine();
            }
            if (sb.isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + fileName);
        }

        String[] array = sb.toString().split(DEMILITED);
        Arrays.sort(array);
        return array;
    }

    private String getRightWords(String line) {
        String[] lines = line.split(DEMILITED);
        StringBuilder sb = new StringBuilder();
        for (String s : lines) {
            s = withoutPoint(s);
            if (isMatch(s)) {
                sb.append(s.toLowerCase()).append(" ");
            }
        }
        return sb.toString();
    }

    private String withoutPoint(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetterOrDigit(ch[i])) {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    private boolean isMatch(String line) {
        return line.matches(PATTERN_FOR_LINE);
    }
}
