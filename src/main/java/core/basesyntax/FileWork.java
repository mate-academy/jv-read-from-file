package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

//public class FileWork {
//    public String[] readFromFile(String fileName) {
//        File file = new File(fileName);
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            List<String> stringList = new ArrayList<>();
//            StringBuilder stringBuilder = new StringBuilder();
//            int value = bufferedReader.read();
//            while (value != -1) {
//                char currentChar = (char) value;
//                if (Character.isLetter(currentChar)) {
//                    stringBuilder.append(currentChar);
//                } else {
//                    if (!stringBuilder.isEmpty()) {
//                        stringList.add(stringBuilder.toString());
//                        stringBuilder.setLength(0);
//                    }
//                }
//                value = bufferedReader.read();
//            }
//
//            if (!stringBuilder.isEmpty()) {
//                stringList.add(stringBuilder.toString());
//            }
//
//            ListIterator<String> iterator = stringList.listIterator();
//            while (iterator.hasNext()) {
//                String s = iterator.next().toLowerCase();
//                if (s.charAt(0) != 'w') {
//                    iterator.remove();
//                } else {
//                    iterator.set(s.toLowerCase());
//                }
//            }
//
//            if (!stringList.isEmpty()) {
//                stringList.sort(String.CASE_INSENSITIVE_ORDER);
//                return stringList.toArray(new String[0]);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Can't read file", e);
//        }
//        return new String[0];
//    }
//}




// код сверху с первой попытки ужасный :D
// так что я решил его переписать полегче

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> stringList = Files.readAllLines(file.toPath());
            List<String> cleanedStringList = new ArrayList<>();
            for (String string : stringList) {
                String[] stringArray = string.split(" ");
                for (int j = 0; j < stringArray.length; j++) {
                    String s = stringArray[j].replaceAll("[,.!?]+", "");
                    stringArray[j] = s.toLowerCase();
                    if (stringArray[j].charAt(0) == 'w') {
                        cleanedStringList.add(stringArray[j]);
                    }
                }
            }
            cleanedStringList.sort(String.CASE_INSENSITIVE_ORDER);
            return cleanedStringList.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
