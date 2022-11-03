package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private final ArrayList<String> arrayList = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String[] format = makeArray(stringBuilder);
        return checkWord(format);
    }

    private String[] makeArray(StringBuilder stringBuilder) {
        return stringBuilder.toString().toLowerCase().split("\\W+");
    }

    private String[] checkWord(String[] format) {
        for (String word : format) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                arrayList.add(word);
            }
        }
        Collections.sort(arrayList);
        return arrayList.toArray(new String[arrayList.size()]);
    }
}
