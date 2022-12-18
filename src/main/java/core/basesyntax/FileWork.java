package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        fileName = fileName.toLowerCase();
        fileName = fileName.replaceAll("[^a-zA-Z0]", " ");
        String[] temp = fileName.split(" ");
        List<String> tempList = Arrays.asList(temp);
        ArrayList<String> stringList = new ArrayList<>();
        for (String s : tempList) {
            if (!s.equals("") && s.charAt(0) == 'w') {
                stringList.add(s);
            }
        }
        if (stringList.size() == 0) {
            return new String[0];
        }
        String[] result = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            result[i] = stringList.get(i);
        }
        //System.out.println(Arrays.toString(result));
        return result;
    }
}
