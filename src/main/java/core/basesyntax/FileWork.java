package core.basesyntax;

public class FileWork {
    private static final int EMPTY_ARRAY_LENGTH = 1;
    private static String[] EMPTY_ARRAY = {};

    public String[] readFromFile(String fileName) {
        WordExtractor wordExtractor = new WordExtractor();
        StringBuilder builder = new StringBuilder();
        FileReader fileReader = new FileReader(wordExtractor);
        return fileReader.read(fileName).length > EMPTY_ARRAY_LENGTH
                ? fileReader.read(fileName) : EMPTY_ARRAY;
    }
}
