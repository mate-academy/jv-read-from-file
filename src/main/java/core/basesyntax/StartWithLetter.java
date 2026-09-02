package core.basesyntax;

public class StartWithLetter {
    private static final String SPECIFIED_CHARACTER = "w";

    public static boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
