package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }

            bufferedReader.close();

            String resould = stringBuilder.toString();

            String[] array = resould.split("\\W+");
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < array.length; i++) {
                if (array[i].startsWith("w") || array[i].startsWith("W")) {
                    list.add(array[i].toLowerCase(Locale.ROOT));
                }
            }

            String[] arrays = new String[list.size()];

            Arrays.sort(list.toArray(arrays));

            return arrays;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
