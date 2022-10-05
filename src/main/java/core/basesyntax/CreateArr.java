package core.basesyntax;

public class CreateArr {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] createArr(String textFormFile) {
        String[] arrFromFile = textFormFile.split("\\W+");
        int arrlength = 0;
        for (int i = 0; i < arrFromFile.length; i++) {
            if (arrFromFile[i].charAt(0) == SPECIFIED_CHARACTER) {
                arrlength += 1;
            }
        }
        String[] arrForAnswer = new String[arrlength];
        for (int i = 0; i < arrFromFile.length; i++) {
            if (arrFromFile[i].charAt(0) == SPECIFIED_CHARACTER) {
                for (int j = 0; j < arrlength; j++) {
                    arrForAnswer[j] = arrFromFile[i];
                }
            }
        }

        return arrForAnswer;
    }
}
