package core.basesyntax;

import java.util.Arrays;

public class CreateArr {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] createArr(String textFormFile) {

        if (textFormFile.equals("")) {
            String[] emptyArr = new String[] {};
            return emptyArr;
        }

        String[] arrFromFile = textFormFile.split("\\W+");
        int arrlength = 0;
        for (int i = 0; i < arrFromFile.length; i++) {
            if (arrFromFile[i].charAt(0) == SPECIFIED_CHARACTER) {
                arrlength += 1;
            }
        }
        String[] arrForAnswer = new String[arrlength];
        int index = 0;
        for (int i = 0; i < arrFromFile.length; i++) {
            if (arrFromFile[i].charAt(0) == SPECIFIED_CHARACTER) {
                arrForAnswer[index] = arrFromFile[i];
                index++;
            }
        }
        Arrays.sort(arrForAnswer);
        return arrForAnswer;
    }
}
