package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIAL_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] linesArr;
        String[] words = {};
        int counter = 0;

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            linesArr = lines.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line: linesArr) {
            words = concatWithCollection(words, line.split("\\W+"));
        }

        for (String word: words) {
            String lowWord = word.toLowerCase();
            if (lowWord.startsWith(SPECIAL_CHAR)) {
                counter++;
            }
        }

        String[] res = new String[counter];
        counter = 0;

        for (String word: words) {
            String lowWord = word.toLowerCase();
            if (lowWord.startsWith(SPECIAL_CHAR)) {
                res[counter] = lowWord;
                counter++;
            }
        }

        Arrays.sort(res);

        return res;
    }

    static <T> T[] concatWithCollection(T[] array1, T[] array2) {
        List<T> resultList = new ArrayList<>(array1.length + array2.length);
        Collections.addAll(resultList, array1);
        Collections.addAll(resultList, array2);

        @SuppressWarnings("unchecked")
        //the type cast is safe as the array1 has the type T[]
        T[] resultArray = (T[]) Array.newInstance(array1.getClass().getComponentType(), 0);
        return resultList.toArray(resultArray);
    }

}
