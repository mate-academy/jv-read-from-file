package core.basesyntax;

import java.io.*;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] fileWork = null;
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                int value = bufferedReader.read();
                while (value !=-1) {
                    stringBuilder.append((char) value);
                    value = bufferedReader.read();
                }
                System.out.println(stringBuilder);
            } catch (IOException e) {
                throw new RuntimeException("Can't to read file", e);
            }

            return fileWork;
    }

    private boolean fileIsNotEmpty(String fileName) {
        File file = new File(fileName);
        return !file.exists();
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
