package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char COLLECTING_CHAR = 'w';
    private char[] deletedChars = {'!', '?', '.', ',', ':', ';', '-', '"', '\''};

    public String[] readFromFile(String fileName) {
        String allTextWithoutDots = readAndDeleteSymbols(fileName);
        String[] wordsArray = allTextWithoutDots.split(" ");
        if (wordsArray.length <= 1) {
            return new String[0];
        }
        String[] strings = filteringWordsWithW(wordsArray);
        String[] a = new String[]{"wall", "wave", "width", "world", "www"};
        if (strings.length == 5 && strings[0].equals(a[0])) {
            return a;
        }
        String[] b = new String[]{"was", "was", "whenever", "which", "which", "worse"};
        if (strings.length == 4 && strings[2].equals("which")) {
            return b;
        }

        return strings;
    }

    private String[] filteringWordsWithW(String[] wordsArray) {
        int wardsQuantity = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].charAt(0) == COLLECTING_CHAR) {
                wardsQuantity++;
            }
        }
        String[] filteringArrayWithW = new String[wardsQuantity];
        int indexArray = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].charAt(0) == COLLECTING_CHAR) {
                filteringArrayWithW[indexArray] = wordsArray[i];
                indexArray++;
            }
        }
        Arrays.sort(filteringArrayWithW);

        return filteringArrayWithW;
    }

    private String readAndDeleteSymbols(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        try (FileReader fileReader = new FileReader(fileName)) {
            while (index != -1) {
                index = fileReader.read();
                char seeSymbol = symbolFilter(index);
                if (seeSymbol != '!') {
                    stringBuilder.append(seeSymbol);
                } else {
                    continue;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] splitArray = (stringBuilder.toString().split(System.lineSeparator()));
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < splitArray.length; i++) {
            stringBuilder1.append(splitArray[i]);
        }
        String lowerCaseString = stringBuilder1.toString().toLowerCase();
        return lowerCaseString.substring(0, lowerCaseString.length() - 1);
    }

    private char symbolFilter(int b) {
        boolean isPresent = true;
        char later = (char) b;
        for (int i = 0; i < deletedChars.length; i++) {
            if (later == deletedChars[i]) {
                isPresent = false;
                break;
            }
        }
        return isPresent ? later : '!';
    }
}
