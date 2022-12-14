package core.basesyntax;

import java.util.Arrays;

public class FileDataConverter {
    public static final Character STARTS_WITH_W = 'w';
    public static final Character SPACE_CHARACTER = ' ';
    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";

    public String[] convert(String source) {
        String[] result = new String[]{};
        String removePunctuationString = removePunctuation(source);
        String[] dataFileArray = removePunctuationString.toLowerCase().split(SPACE_STRING);
        String startsWithWWords = startsWithWWords(dataFileArray);
        if (EMPTY_STRING.equals(startsWithWWords)) {
            return result;
        }
        result = startsWithWWords.split(SPACE_STRING);
        Arrays.sort(result);
        return result;
    }

    public String startsWithWWords(String[] dataFileArray) {
        StringBuilder bufferStringBuilder = new StringBuilder();
        for (String word : dataFileArray) {
            if (word.charAt(0) == STARTS_WITH_W) {
                bufferStringBuilder.append(word).append(SPACE_STRING);
            }
        }
        return bufferStringBuilder.toString();
    }

    public String removePunctuation(String input) {
        final StringBuilder builder = new StringBuilder();
        for (char letterChar : input.toCharArray()) {
            if (Character.isLetterOrDigit(letterChar) || letterChar == SPACE_CHARACTER) {
                builder.append(Character.isLowerCase(letterChar) ? letterChar
                        : Character.toLowerCase(letterChar));
            }
        }
        return builder.toString();
    }
}
