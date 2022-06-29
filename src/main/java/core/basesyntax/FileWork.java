package core.basesyntax;

import java.io.*;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder readFile = new StringBuilder();
        StringBuilder sortWords = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                int value = bufferedReader.read();
                while (value !=-1) {
                    readFile.append((char) value);
                    value = bufferedReader.read();
                }
                String [] wordsReadFile = readFile.toString().toLowerCase().trim()
                        .split("[?|!|-|(|)|:|;|'|\"| |.|,|\\s+|\\t|\\n|\\r|\\f]");
                int index;
                for (int i = 0; i<wordsReadFile.length; i++) {
                    index = i;
                    if (wordsReadFile[i].startsWith("w") || wordsReadFile[i].startsWith("W")) {
                        sortWords.append(wordsReadFile[i]).append(" ");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't to read file", e);
           }
            String[] resultReadFile = sortWords.toString().split(" ");
        return resultReadFile;
    }
}
