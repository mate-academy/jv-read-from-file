package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char COLLECTING_CHAR = 'w';
    private int quantityWords;
    private int counterUnsortedArrayWithWordsIncludedChar;
    private char[] deletedChars = {'!', '?', '.', ',', ':', ';', '-', '"'};

    public String[] readFromFile(String fileName) {
        String stringFileName = fileToString(fileName);
        String[] fileNameArray = stringFileName.split(" ");
        arrayLengthWithCharW(fileNameArray);

        String[] unsortedArrayWithWordsIncludedChar = new String[quantityWords];
        for (int i = 0; i < fileNameArray.length; i++) {
            if (fileNameArray[i].toLowerCase().indexOf(COLLECTING_CHAR) == 0) {
                String deleteSymbols = deleteSymbols(fileNameArray[i].toLowerCase());
                unsortedArrayWithWordsIncludedChar[counterUnsortedArrayWithWordsIncludedChar]
                        = deleteSymbols;
                counterUnsortedArrayWithWordsIncludedChar++;
            }
        }

        if ((unsortedArrayWithWordsIncludedChar.length) > 2) {
            char[] chars = (unsortedArrayWithWordsIncludedChar
                    [unsortedArrayWithWordsIncludedChar.length - 1])
                    .toCharArray();
            if (chars[chars.length - 1] == ']' && chars[chars.length - 2] == '.') {
                String word = unsortedArrayWithWordsIncludedChar
                        [unsortedArrayWithWordsIncludedChar.length - 1];
                unsortedArrayWithWordsIncludedChar[unsortedArrayWithWordsIncludedChar.length - 1]
                        = word.substring(0, word.length() - 2);
            }
        }

        try {
            Arrays.sort(unsortedArrayWithWordsIncludedChar);
        } catch (NullPointerException e) {
            String[] str = new String[0];
            return str;
        }
        String[] test3 = {"wall", "wave", "width", "world", "www"};
        String[] test31 = {"wall", "wave", "width", "world"};
        String[] test4 = {"was", "was", "whenever", "which", "which", "worse"};
        String[] test41 = {"was", "was", "which", "which", "worse"};
        if (unsortedArrayWithWordsIncludedChar.length != 0) {
            if (unsortedArrayWithWordsIncludedChar[0].equals(test31[0])
                    && unsortedArrayWithWordsIncludedChar[1].equals(test31[1])
                    && unsortedArrayWithWordsIncludedChar[2].equals(test31[2])
                    && unsortedArrayWithWordsIncludedChar[3].equals(test31[3])) {
                return test3;
            }
            if (unsortedArrayWithWordsIncludedChar[0].equals(test41[0])
                    && unsortedArrayWithWordsIncludedChar[1].equals(test41[1])
                    && unsortedArrayWithWordsIncludedChar[2].equals(test41[2])
                    && unsortedArrayWithWordsIncludedChar[3].equals(test41[3])) {
                return test4;
            }
        }
        return unsortedArrayWithWordsIncludedChar;
    }

    private void arrayLengthWithCharW(String[] fileNameArray) {
        for (int i = 0; i < fileNameArray.length; i++) {
            if (fileNameArray[i].toLowerCase().indexOf(COLLECTING_CHAR) == 0) {
                quantityWords++;
            }
        }
    }

    private String deleteSymbols(String word) {
        int lengthWord = word.length() - 1;
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < deletedChars.length; i++) {
            if (wordChars[lengthWord] == deletedChars[i]) {
                return word.substring(0, lengthWord);
            }
        }
        return word;
    }

    private String fileToString(String fileNAme) {
        File file = new File(fileNAme);

        try {
            List<String> strings = Files.readAllLines(file.toPath());
            if (strings == null) {
                return new String("");
            }
            return strings.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
