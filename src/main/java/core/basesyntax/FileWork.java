package core.basesyntax;

import java.io.*;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] fileWork = null;
        File file = new File(fileName);
        if (fileIsNotEmpty(fileName)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                System.out.println(bufferedReader.read());


            } catch (IOException e) {
                throw new RuntimeException("Can't to read file", e);
            }


            return null;
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
