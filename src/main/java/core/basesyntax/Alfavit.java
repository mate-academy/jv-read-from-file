package core.basesyntax;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alfavit {
    public String[] returnAlfWords(String[] words) {

        List<String> wordsW = Arrays.asList(words);
        Collections.sort(wordsW);
        return wordsW.toArray(new String[wordsW.size()]);

    }
}
