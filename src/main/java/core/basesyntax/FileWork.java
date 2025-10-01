package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    static final int END_OF_FILE = -1;
    static final int MIN_LETTER_NUM = 65;
    static final int FIRST_CHAR = 0;
    static final int RESET = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder word = new StringBuilder();
        List<String> fileText = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            int value = reader.read();
            while (value != END_OF_FILE) {
                if (value > MIN_LETTER_NUM) {
                    word.append((char) value);
                } else {
                    if (!word.isEmpty() && (word.charAt(FIRST_CHAR) == 'w'
                            || word.charAt(FIRST_CHAR) == 'W')) {
                        fileText.add(word.toString().toLowerCase());
                    }
                    word.setLength(RESET);
                }

                value = reader.read();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file", e);
        }

        fileText.sort(Comparator.naturalOrder());

        return fileText.toArray(new String[RESET]);
    }
}
