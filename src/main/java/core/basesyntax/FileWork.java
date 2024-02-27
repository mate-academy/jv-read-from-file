package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder content = new StringBuilder();
        String line;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            content.append(line);
            content.append(System.lineSeparator());
        }
        String toSplit = content.toString();
        String[] tab = toSplit.split("([.,!?:;'\"-]|\\s)");
        int index = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].indexOf("w") == 0 || tab[i].indexOf("W") == 0) {
                index++;
            }
        }
        String[] endTab = new String[index];
        for (int i = 0, y = 0; i < tab.length && y < endTab.length; i++) {
            if (tab[i].indexOf("w") == 0 || tab[i].indexOf("W") == 0) {
                endTab[y] = tab[i].toLowerCase();
                y++;
            }
        }
        Arrays.sort(endTab);
        return endTab;
    }
}
